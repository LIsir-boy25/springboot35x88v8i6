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

import com.yb.entity.ChufaxinxiEntity;
import com.yb.entity.view.ChufaxinxiView;

import com.yb.service.ChufaxinxiService;
import com.yb.utils.PageUtils;
import com.yb.utils.R;
import com.yb.utils.EncryptUtil;
import com.yb.utils.MPUtil;
import com.yb.utils.MapUtils;
import com.yb.utils.CommonUtil;
import java.io.IOException;

/**
 * 出发信息
 * 后端接口
 * @author 
 * @email 
 * @date 2026-01-10 20:50:16
 */
@RestController
@RequestMapping("/chufaxinxi")
public class ChufaxinxiController {
    @Autowired
    private ChufaxinxiService chufaxinxiService;










    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChufaxinxiEntity chufaxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("huozhu")) {
			chufaxinxi.setHuozhuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("siji")) {
			chufaxinxi.setSijizhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        QueryWrapper<ChufaxinxiEntity> ew = new QueryWrapper<ChufaxinxiEntity>();


        //查询结果
		PageUtils page = chufaxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chufaxinxi), params), params));
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
    public R list(@RequestParam Map<String, Object> params,ChufaxinxiEntity chufaxinxi,
                @RequestParam(required = false) Double lichengstart,
                @RequestParam(required = false) Double lichengend,
                @RequestParam(required = false) Double jiagestart,
                @RequestParam(required = false) Double jiageend,
                @RequestParam(required = false) Double yuestart,
                @RequestParam(required = false) Double yueend,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date chufashijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date chufashijianend,
		HttpServletRequest request){
        //设置查询条件
        QueryWrapper<ChufaxinxiEntity> ew = new QueryWrapper<ChufaxinxiEntity>();
        if(lichengstart!=null) ew.ge("licheng", lichengstart);
        if(lichengend!=null) ew.le("licheng", lichengend);
        if(jiagestart!=null) ew.ge("jiage", jiagestart);
        if(jiageend!=null) ew.le("jiage", jiageend);
        if(yuestart!=null) ew.ge("yue", yuestart);
        if(yueend!=null) ew.le("yue", yueend);
        if(chufashijianstart!=null) ew.ge("chufashijian", chufashijianstart);
        if(chufashijianend!=null) ew.le("chufashijian", chufashijianend);

        //查询结果
		PageUtils page = chufaxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chufaxinxi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChufaxinxiEntity chufaxinxi){
       	QueryWrapper<ChufaxinxiEntity> ew = new QueryWrapper<ChufaxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( chufaxinxi, "chufaxinxi"));
        return R.ok().put("data", chufaxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChufaxinxiEntity chufaxinxi){
        QueryWrapper< ChufaxinxiEntity> ew = new QueryWrapper< ChufaxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( chufaxinxi, "chufaxinxi"));
		ChufaxinxiView chufaxinxiView =  chufaxinxiService.selectView(ew);
		return R.ok("查询出发信息成功").put("data", chufaxinxiView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChufaxinxiEntity chufaxinxi = chufaxinxiService.getById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(chufaxinxi,deSens);
        return R.ok().put("data", chufaxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChufaxinxiEntity chufaxinxi = chufaxinxiService.getById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(chufaxinxi,deSens);
        return R.ok().put("data", chufaxinxi);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增出发信息")
    public R save(@RequestBody ChufaxinxiEntity chufaxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chufaxinxi);
        chufaxinxiService.save(chufaxinxi);
        return R.ok().put("data",chufaxinxi.getId());
    }

    /**
     * 前台保存
     */
    @SysLog("新增出发信息")
    @RequestMapping("/add")
    public R add(@RequestBody ChufaxinxiEntity chufaxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chufaxinxi);
        chufaxinxiService.save(chufaxinxi);
        return R.ok().put("data",chufaxinxi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改出发信息")
    public R update(@RequestBody ChufaxinxiEntity chufaxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chufaxinxi);
        //全部更新
        chufaxinxiService.updateById(chufaxinxi);
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除出发信息")
    public R delete(@RequestBody Long[] ids){
        chufaxinxiService.removeBatchByIds(Arrays.asList(ids));
        return R.ok();
    }





    // hasAlipay:否




}
