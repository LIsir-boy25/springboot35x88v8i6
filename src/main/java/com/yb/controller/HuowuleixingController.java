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

import com.yb.entity.HuowuleixingEntity;
import com.yb.entity.view.HuowuleixingView;

import com.yb.service.HuowuleixingService;
import com.yb.utils.PageUtils;
import com.yb.utils.R;
import com.yb.utils.EncryptUtil;
import com.yb.utils.MPUtil;
import com.yb.utils.MapUtils;
import com.yb.utils.CommonUtil;
import java.io.IOException;

/**
 * 货物类型
 * 后端接口
 * @author 
 * @email 
 * @date 2026-01-10 20:50:15
 */
@RestController
@RequestMapping("/huowuleixing")
public class HuowuleixingController {
    @Autowired
    private HuowuleixingService huowuleixingService;










    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,HuowuleixingEntity huowuleixing,
		HttpServletRequest request){
        //设置查询条件
        QueryWrapper<HuowuleixingEntity> ew = new QueryWrapper<HuowuleixingEntity>();


        //查询结果
		PageUtils page = huowuleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huowuleixing), params), params));
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
    public R list(@RequestParam Map<String, Object> params,HuowuleixingEntity huowuleixing,
		HttpServletRequest request){
        //设置查询条件
        QueryWrapper<HuowuleixingEntity> ew = new QueryWrapper<HuowuleixingEntity>();

        //查询结果
		PageUtils page = huowuleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huowuleixing), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HuowuleixingEntity huowuleixing){
       	QueryWrapper<HuowuleixingEntity> ew = new QueryWrapper<HuowuleixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( huowuleixing, "huowuleixing"));
        return R.ok().put("data", huowuleixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HuowuleixingEntity huowuleixing){
        QueryWrapper< HuowuleixingEntity> ew = new QueryWrapper< HuowuleixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( huowuleixing, "huowuleixing"));
		HuowuleixingView huowuleixingView =  huowuleixingService.selectView(ew);
		return R.ok("查询货物类型成功").put("data", huowuleixingView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HuowuleixingEntity huowuleixing = huowuleixingService.getById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(huowuleixing,deSens);
        return R.ok().put("data", huowuleixing);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HuowuleixingEntity huowuleixing = huowuleixingService.getById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(huowuleixing,deSens);
        return R.ok().put("data", huowuleixing);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增货物类型")
    public R save(@RequestBody HuowuleixingEntity huowuleixing, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(huowuleixingService.count(new QueryWrapper<HuowuleixingEntity>().eq("huowuleixing", huowuleixing.getHuowuleixing()))>0) {
            return R.error("货物类型已存在");
        }
        //ValidatorUtils.validateEntity(huowuleixing);
        huowuleixingService.save(huowuleixing);
        return R.ok().put("data",huowuleixing.getId());
    }

    /**
     * 前台保存
     */
    @SysLog("新增货物类型")
    @RequestMapping("/add")
    public R add(@RequestBody HuowuleixingEntity huowuleixing, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(huowuleixingService.count(new QueryWrapper<HuowuleixingEntity>().eq("huowuleixing", huowuleixing.getHuowuleixing()))>0) {
            return R.error("货物类型已存在");
        }
        //ValidatorUtils.validateEntity(huowuleixing);
        huowuleixingService.save(huowuleixing);
        return R.ok().put("data",huowuleixing.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改货物类型")
    public R update(@RequestBody HuowuleixingEntity huowuleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(huowuleixing);
        //验证字段唯一性，否则返回错误信息
        if(huowuleixingService.count(new QueryWrapper<HuowuleixingEntity>().ne("id", huowuleixing.getId()).eq("huowuleixing", huowuleixing.getHuowuleixing()))>0) {
            return R.error("货物类型已存在");
        }
        //全部更新
        huowuleixingService.updateById(huowuleixing);
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除货物类型")
    public R delete(@RequestBody Long[] ids){
        huowuleixingService.removeBatchByIds(Arrays.asList(ids));
        return R.ok();
    }





    // hasAlipay:否




}
