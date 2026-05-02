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

import com.yb.entity.ChexingEntity;
import com.yb.entity.view.ChexingView;

import com.yb.service.ChexingService;
import com.yb.utils.PageUtils;
import com.yb.utils.R;
import com.yb.utils.EncryptUtil;
import com.yb.utils.MPUtil;
import com.yb.utils.MapUtils;
import com.yb.utils.CommonUtil;
import java.io.IOException;

/**
 * 车型
 * 后端接口
 * @author 
 * @email 
 * @date 2026-01-10 20:50:16
 */
@RestController
@RequestMapping("/chexing")
public class ChexingController {
    @Autowired
    private ChexingService chexingService;










    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChexingEntity chexing,
		HttpServletRequest request){
        //设置查询条件
        QueryWrapper<ChexingEntity> ew = new QueryWrapper<ChexingEntity>();


        //查询结果
		PageUtils page = chexingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chexing), params), params));
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
    public R list(@RequestParam Map<String, Object> params,ChexingEntity chexing,
                @RequestParam(required = false) Double jiagestart,
                @RequestParam(required = false) Double jiageend,
		HttpServletRequest request){
        //设置查询条件
        QueryWrapper<ChexingEntity> ew = new QueryWrapper<ChexingEntity>();
        if(jiagestart!=null) ew.ge("jiage", jiagestart);
        if(jiageend!=null) ew.le("jiage", jiageend);

        //查询结果
		PageUtils page = chexingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chexing), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChexingEntity chexing){
       	QueryWrapper<ChexingEntity> ew = new QueryWrapper<ChexingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( chexing, "chexing"));
        return R.ok().put("data", chexingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChexingEntity chexing){
        QueryWrapper< ChexingEntity> ew = new QueryWrapper< ChexingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( chexing, "chexing"));
		ChexingView chexingView =  chexingService.selectView(ew);
		return R.ok("查询车型成功").put("data", chexingView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChexingEntity chexing = chexingService.getById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(chexing,deSens);
        return R.ok().put("data", chexing);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChexingEntity chexing = chexingService.getById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(chexing,deSens);
        return R.ok().put("data", chexing);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增车型")
    public R save(@RequestBody ChexingEntity chexing, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(chexingService.count(new QueryWrapper<ChexingEntity>().eq("chexing", chexing.getChexing()))>0) {
            return R.error("车型已存在");
        }
        //ValidatorUtils.validateEntity(chexing);
        chexingService.save(chexing);
        return R.ok().put("data",chexing.getId());
    }

    /**
     * 前台保存
     */
    @SysLog("新增车型")
    @RequestMapping("/add")
    public R add(@RequestBody ChexingEntity chexing, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(chexingService.count(new QueryWrapper<ChexingEntity>().eq("chexing", chexing.getChexing()))>0) {
            return R.error("车型已存在");
        }
        //ValidatorUtils.validateEntity(chexing);
        chexingService.save(chexing);
        return R.ok().put("data",chexing.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改车型")
    public R update(@RequestBody ChexingEntity chexing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chexing);
        //验证字段唯一性，否则返回错误信息
        if(chexingService.count(new QueryWrapper<ChexingEntity>().ne("id", chexing.getId()).eq("chexing", chexing.getChexing()))>0) {
            return R.error("车型已存在");
        }
        //全部更新
        chexingService.updateById(chexing);
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除车型")
    public R delete(@RequestBody Long[] ids){
        chexingService.removeBatchByIds(Arrays.asList(ids));
        return R.ok();
    }





    // hasAlipay:否




}
