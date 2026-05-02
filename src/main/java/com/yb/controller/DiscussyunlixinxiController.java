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

import com.yb.entity.DiscussyunlixinxiEntity;
import com.yb.entity.view.DiscussyunlixinxiView;

import com.yb.service.DiscussyunlixinxiService;
import com.yb.utils.PageUtils;
import com.yb.utils.R;
import com.yb.utils.EncryptUtil;
import com.yb.utils.MPUtil;
import com.yb.utils.MapUtils;
import com.yb.utils.CommonUtil;
import java.io.IOException;

/**
 * 运力信息评论
 * 后端接口
 * @author 
 * @email 
 * @date 2026-01-10 20:50:19
 */
@RestController
@RequestMapping("/discussyunlixinxi")
public class DiscussyunlixinxiController {
    @Autowired
    private DiscussyunlixinxiService discussyunlixinxiService;










    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussyunlixinxiEntity discussyunlixinxi,
		HttpServletRequest request){
        //设置查询条件
        QueryWrapper<DiscussyunlixinxiEntity> ew = new QueryWrapper<DiscussyunlixinxiEntity>();


        //查询结果
		PageUtils page = discussyunlixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussyunlixinxi), params), params));
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
    public R list(@RequestParam Map<String, Object> params,DiscussyunlixinxiEntity discussyunlixinxi,
                @RequestParam(required = false) Double thumbsupnumstart,
                @RequestParam(required = false) Double thumbsupnumend,
                @RequestParam(required = false) Double crazilynumstart,
                @RequestParam(required = false) Double crazilynumend,
                @RequestParam(required = false) Double istopstart,
                @RequestParam(required = false) Double istopend,
		HttpServletRequest request){
        //设置查询条件
        QueryWrapper<DiscussyunlixinxiEntity> ew = new QueryWrapper<DiscussyunlixinxiEntity>();
        if(thumbsupnumstart!=null) ew.ge("thumbsupnum", thumbsupnumstart);
        if(thumbsupnumend!=null) ew.le("thumbsupnum", thumbsupnumend);
        if(crazilynumstart!=null) ew.ge("crazilynum", crazilynumstart);
        if(crazilynumend!=null) ew.le("crazilynum", crazilynumend);
        if(istopstart!=null) ew.ge("istop", istopstart);
        if(istopend!=null) ew.le("istop", istopend);

        //查询结果
		PageUtils page = discussyunlixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussyunlixinxi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussyunlixinxiEntity discussyunlixinxi){
       	QueryWrapper<DiscussyunlixinxiEntity> ew = new QueryWrapper<DiscussyunlixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussyunlixinxi, "discussyunlixinxi"));
        return R.ok().put("data", discussyunlixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussyunlixinxiEntity discussyunlixinxi){
        QueryWrapper< DiscussyunlixinxiEntity> ew = new QueryWrapper< DiscussyunlixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussyunlixinxi, "discussyunlixinxi"));
		DiscussyunlixinxiView discussyunlixinxiView =  discussyunlixinxiService.selectView(ew);
		return R.ok("查询运力信息评论成功").put("data", discussyunlixinxiView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussyunlixinxiEntity discussyunlixinxi = discussyunlixinxiService.getById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(discussyunlixinxi,deSens);
        return R.ok().put("data", discussyunlixinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussyunlixinxiEntity discussyunlixinxi = discussyunlixinxiService.getById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(discussyunlixinxi,deSens);
        return R.ok().put("data", discussyunlixinxi);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增运力信息评论")
    public R save(@RequestBody DiscussyunlixinxiEntity discussyunlixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussyunlixinxi);
        discussyunlixinxiService.save(discussyunlixinxi);
        return R.ok().put("data",discussyunlixinxi.getId());
    }

    /**
     * 前台保存
     */
    @SysLog("新增运力信息评论")
    @RequestMapping("/add")
    public R add(@RequestBody DiscussyunlixinxiEntity discussyunlixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussyunlixinxi);
        discussyunlixinxiService.save(discussyunlixinxi);
        return R.ok().put("data",discussyunlixinxi.getId());
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        DiscussyunlixinxiEntity discussyunlixinxi = discussyunlixinxiService.getOne(new QueryWrapper<DiscussyunlixinxiEntity>().eq("", username));
        return R.ok().put("data", discussyunlixinxi);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscussyunlixinxiEntity discussyunlixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussyunlixinxi);
        //全部更新
        discussyunlixinxiService.updateById(discussyunlixinxi);
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除运力信息评论")
    public R delete(@RequestBody Long[] ids){
        discussyunlixinxiService.removeBatchByIds(Arrays.asList(ids));
        return R.ok();
    }

	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussyunlixinxiEntity discussyunlixinxi, HttpServletRequest request,String pre){
        QueryWrapper<DiscussyunlixinxiEntity> ew = new QueryWrapper<DiscussyunlixinxiEntity>();
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

		PageUtils page = discussyunlixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussyunlixinxi), params), params));
        return R.ok().put("data", page);
    }




    // hasAlipay:$hasAlipay




}
