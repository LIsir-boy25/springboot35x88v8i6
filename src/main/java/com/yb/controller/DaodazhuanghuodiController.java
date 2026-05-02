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

import com.yb.entity.DaodazhuanghuodiEntity;
import com.yb.entity.view.DaodazhuanghuodiView;

import com.yb.service.DaodazhuanghuodiService;
import com.yb.utils.PageUtils;
import com.yb.utils.R;
import com.yb.utils.EncryptUtil;
import com.yb.utils.MPUtil;
import com.yb.utils.MapUtils;
import com.yb.utils.CommonUtil;
import java.io.IOException;

/**
 * 到达装货地
 * 后端接口
 * @author 
 * @email 
 * @date 2026-01-10 20:50:17
 */
@RestController
@RequestMapping("/daodazhuanghuodi")
public class DaodazhuanghuodiController {
    @Autowired
    private DaodazhuanghuodiService daodazhuanghuodiService;










    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DaodazhuanghuodiEntity daodazhuanghuodi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("huozhu")) {
			daodazhuanghuodi.setHuozhuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("siji")) {
			daodazhuanghuodi.setSijizhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        QueryWrapper<DaodazhuanghuodiEntity> ew = new QueryWrapper<DaodazhuanghuodiEntity>();


        //查询结果
		PageUtils page = daodazhuanghuodiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, daodazhuanghuodi), params), params));
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
    public R list(@RequestParam Map<String, Object> params,DaodazhuanghuodiEntity daodazhuanghuodi,
                @RequestParam(required = false) Double lichengstart,
                @RequestParam(required = false) Double lichengend,
                @RequestParam(required = false) Double jiagestart,
                @RequestParam(required = false) Double jiageend,
                @RequestParam(required = false) Double yuestart,
                @RequestParam(required = false) Double yueend,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date daodashijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date daodashijianend,
		HttpServletRequest request){
        //设置查询条件
        QueryWrapper<DaodazhuanghuodiEntity> ew = new QueryWrapper<DaodazhuanghuodiEntity>();
        if(lichengstart!=null) ew.ge("licheng", lichengstart);
        if(lichengend!=null) ew.le("licheng", lichengend);
        if(jiagestart!=null) ew.ge("jiage", jiagestart);
        if(jiageend!=null) ew.le("jiage", jiageend);
        if(yuestart!=null) ew.ge("yue", yuestart);
        if(yueend!=null) ew.le("yue", yueend);
        if(daodashijianstart!=null) ew.ge("daodashijian", daodashijianstart);
        if(daodashijianend!=null) ew.le("daodashijian", daodashijianend);

        //查询结果
		PageUtils page = daodazhuanghuodiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, daodazhuanghuodi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DaodazhuanghuodiEntity daodazhuanghuodi){
       	QueryWrapper<DaodazhuanghuodiEntity> ew = new QueryWrapper<DaodazhuanghuodiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( daodazhuanghuodi, "daodazhuanghuodi"));
        return R.ok().put("data", daodazhuanghuodiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DaodazhuanghuodiEntity daodazhuanghuodi){
        QueryWrapper< DaodazhuanghuodiEntity> ew = new QueryWrapper< DaodazhuanghuodiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( daodazhuanghuodi, "daodazhuanghuodi"));
		DaodazhuanghuodiView daodazhuanghuodiView =  daodazhuanghuodiService.selectView(ew);
		return R.ok("查询到达装货地成功").put("data", daodazhuanghuodiView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DaodazhuanghuodiEntity daodazhuanghuodi = daodazhuanghuodiService.getById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(daodazhuanghuodi,deSens);
        return R.ok().put("data", daodazhuanghuodi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DaodazhuanghuodiEntity daodazhuanghuodi = daodazhuanghuodiService.getById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(daodazhuanghuodi,deSens);
        return R.ok().put("data", daodazhuanghuodi);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增到达装货地")
    public R save(@RequestBody DaodazhuanghuodiEntity daodazhuanghuodi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(daodazhuanghuodi);
        daodazhuanghuodiService.save(daodazhuanghuodi);
        return R.ok().put("data",daodazhuanghuodi.getId());
    }

    /**
     * 前台保存
     */
    @SysLog("新增到达装货地")
    @RequestMapping("/add")
    public R add(@RequestBody DaodazhuanghuodiEntity daodazhuanghuodi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(daodazhuanghuodi);
        daodazhuanghuodiService.save(daodazhuanghuodi);
        return R.ok().put("data",daodazhuanghuodi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改到达装货地")
    public R update(@RequestBody DaodazhuanghuodiEntity daodazhuanghuodi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(daodazhuanghuodi);
        //全部更新
        daodazhuanghuodiService.updateById(daodazhuanghuodi);
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除到达装货地")
    public R delete(@RequestBody Long[] ids){
        daodazhuanghuodiService.removeBatchByIds(Arrays.asList(ids));
        return R.ok();
    }





    // hasAlipay:否




}
