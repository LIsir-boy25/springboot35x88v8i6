package com.yb.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
import com.yb.utils.*;
import java.util.stream.Collectors;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.yb.annotation.IgnoreAuth;
import com.yb.annotation.SysLog;

import com.yb.entity.SensitivewordsEntity;
import com.yb.entity.view.SensitivewordsView;

import com.yb.service.SensitivewordsService;
import com.yb.utils.PageUtils;
import com.yb.utils.R;
import com.yb.utils.EncryptUtil;
import com.yb.utils.MPUtil;
import com.yb.utils.MapUtils;
import com.yb.utils.CommonUtil;
import java.io.IOException;

/**
 * 敏感词
 * 后端接口
 * @author 
 * @email 
 * @date 2026-01-10 20:50:18
 */
@RestController
@RequestMapping("/sensitivewords")
public class SensitivewordsController {
    @Autowired
    private SensitivewordsService sensitivewordsService;










    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,SensitivewordsEntity sensitivewords,
		HttpServletRequest request){
        //设置查询条件
        QueryWrapper<SensitivewordsEntity> ew = new QueryWrapper<SensitivewordsEntity>();


        //查询结果
		PageUtils page = sensitivewordsService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, sensitivewords), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }


    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,SensitivewordsEntity sensitivewords,
		HttpServletRequest request){
        //设置查询条件
        QueryWrapper<SensitivewordsEntity> ew = new QueryWrapper<SensitivewordsEntity>();

        //查询结果
		PageUtils page = sensitivewordsService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, sensitivewords), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( SensitivewordsEntity sensitivewords){
       	QueryWrapper<SensitivewordsEntity> ew = new QueryWrapper<SensitivewordsEntity>();
      	ew.allEq(MPUtil.allEQMapPre( sensitivewords, "sensitivewords"));
        return R.ok().put("data", sensitivewordsService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(SensitivewordsEntity sensitivewords){
        QueryWrapper< SensitivewordsEntity> ew = new QueryWrapper< SensitivewordsEntity>();
 		ew.allEq(MPUtil.allEQMapPre( sensitivewords, "sensitivewords"));
		SensitivewordsView sensitivewordsView =  sensitivewordsService.selectView(ew);
		return R.ok("查询敏感词成功").put("data", sensitivewordsView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        SensitivewordsEntity sensitivewords = sensitivewordsService.getById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(sensitivewords,deSens);
        return R.ok().put("data", sensitivewords);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        SensitivewordsEntity sensitivewords = sensitivewordsService.getById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(sensitivewords,deSens);
        return R.ok().put("data", sensitivewords);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增敏感词")
    public R save(@RequestBody SensitivewordsEntity sensitivewords, HttpServletRequest request){
        //ValidatorUtils.validateEntity(sensitivewords);
        sensitivewordsService.save(sensitivewords);
        return R.ok().put("data",sensitivewords.getId());
    }

    /**
     * 前台保存
     */
    @SysLog("新增敏感词")
    @RequestMapping("/add")
    public R add(@RequestBody SensitivewordsEntity sensitivewords, HttpServletRequest request){
        //ValidatorUtils.validateEntity(sensitivewords);
        sensitivewordsService.save(sensitivewords);
        return R.ok().put("data",sensitivewords.getId());
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        SensitivewordsEntity sensitivewords = sensitivewordsService.getOne(new QueryWrapper<SensitivewordsEntity>().eq("", username));
        return R.ok().put("data", sensitivewords);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody SensitivewordsEntity sensitivewords, HttpServletRequest request){
        //ValidatorUtils.validateEntity(sensitivewords);
        //全部更新
        sensitivewordsService.updateById(sensitivewords);
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除敏感词")
    public R delete(@RequestBody Long[] ids){
        sensitivewordsService.removeBatchByIds(Arrays.asList(ids));
        return R.ok();
    }

	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,SensitivewordsEntity sensitivewords, HttpServletRequest request,String pre){
        QueryWrapper<SensitivewordsEntity> ew = new QueryWrapper<SensitivewordsEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
        // 组装参数
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");

		PageUtils page = sensitivewordsService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, sensitivewords), params), params));
        return R.ok().put("data", page);
    }




    // hasAlipay:$hasAlipay




}
