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

import com.yb.entity.ZhuanghuoxinxiEntity;
import com.yb.entity.view.ZhuanghuoxinxiView;

import com.yb.service.ZhuanghuoxinxiService;
import com.yb.utils.PageUtils;
import com.yb.utils.R;
import com.yb.utils.EncryptUtil;
import com.yb.utils.MPUtil;
import com.yb.utils.MapUtils;
import com.yb.utils.CommonUtil;
import java.io.IOException;

/**
 * 装货信息
 * 后端接口
 * @author 
 * @email 
 * @date 2026-01-10 20:50:17
 */
@RestController
@RequestMapping("/zhuanghuoxinxi")
public class ZhuanghuoxinxiController {
    @Autowired
    private ZhuanghuoxinxiService zhuanghuoxinxiService;










    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhuanghuoxinxiEntity zhuanghuoxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("huozhu")) {
			zhuanghuoxinxi.setHuozhuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("siji")) {
			zhuanghuoxinxi.setSijizhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        QueryWrapper<ZhuanghuoxinxiEntity> ew = new QueryWrapper<ZhuanghuoxinxiEntity>();


        //查询结果
		PageUtils page = zhuanghuoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhuanghuoxinxi), params), params));
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
    public R list(@RequestParam Map<String, Object> params,ZhuanghuoxinxiEntity zhuanghuoxinxi,
                @RequestParam(required = false) Double lichengstart,
                @RequestParam(required = false) Double lichengend,
                @RequestParam(required = false) Double jiagestart,
                @RequestParam(required = false) Double jiageend,
                @RequestParam(required = false) Double yuestart,
                @RequestParam(required = false) Double yueend,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date zhuanghuoshijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date zhuanghuoshijianend,
		HttpServletRequest request){
        //设置查询条件
        QueryWrapper<ZhuanghuoxinxiEntity> ew = new QueryWrapper<ZhuanghuoxinxiEntity>();
        if(lichengstart!=null) ew.ge("licheng", lichengstart);
        if(lichengend!=null) ew.le("licheng", lichengend);
        if(jiagestart!=null) ew.ge("jiage", jiagestart);
        if(jiageend!=null) ew.le("jiage", jiageend);
        if(yuestart!=null) ew.ge("yue", yuestart);
        if(yueend!=null) ew.le("yue", yueend);
        if(zhuanghuoshijianstart!=null) ew.ge("zhuanghuoshijian", zhuanghuoshijianstart);
        if(zhuanghuoshijianend!=null) ew.le("zhuanghuoshijian", zhuanghuoshijianend);

        //查询结果
		PageUtils page = zhuanghuoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhuanghuoxinxi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhuanghuoxinxiEntity zhuanghuoxinxi){
       	QueryWrapper<ZhuanghuoxinxiEntity> ew = new QueryWrapper<ZhuanghuoxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhuanghuoxinxi, "zhuanghuoxinxi"));
        return R.ok().put("data", zhuanghuoxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhuanghuoxinxiEntity zhuanghuoxinxi){
        QueryWrapper< ZhuanghuoxinxiEntity> ew = new QueryWrapper< ZhuanghuoxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhuanghuoxinxi, "zhuanghuoxinxi"));
		ZhuanghuoxinxiView zhuanghuoxinxiView =  zhuanghuoxinxiService.selectView(ew);
		return R.ok("查询装货信息成功").put("data", zhuanghuoxinxiView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhuanghuoxinxiEntity zhuanghuoxinxi = zhuanghuoxinxiService.getById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(zhuanghuoxinxi,deSens);
        return R.ok().put("data", zhuanghuoxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhuanghuoxinxiEntity zhuanghuoxinxi = zhuanghuoxinxiService.getById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(zhuanghuoxinxi,deSens);
        return R.ok().put("data", zhuanghuoxinxi);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增装货信息")
    public R save(@RequestBody ZhuanghuoxinxiEntity zhuanghuoxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhuanghuoxinxi);
        zhuanghuoxinxiService.save(zhuanghuoxinxi);
        return R.ok().put("data",zhuanghuoxinxi.getId());
    }

    /**
     * 前台保存
     */
    @SysLog("新增装货信息")
    @RequestMapping("/add")
    public R add(@RequestBody ZhuanghuoxinxiEntity zhuanghuoxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhuanghuoxinxi);
        zhuanghuoxinxiService.save(zhuanghuoxinxi);
        return R.ok().put("data",zhuanghuoxinxi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改装货信息")
    public R update(@RequestBody ZhuanghuoxinxiEntity zhuanghuoxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhuanghuoxinxi);
        //全部更新
        zhuanghuoxinxiService.updateById(zhuanghuoxinxi);
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除装货信息")
    public R delete(@RequestBody Long[] ids){
        zhuanghuoxinxiService.removeBatchByIds(Arrays.asList(ids));
        return R.ok();
    }





    // hasAlipay:否




}
