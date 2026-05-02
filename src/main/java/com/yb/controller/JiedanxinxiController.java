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

import com.yb.entity.JiedanxinxiEntity;
import com.yb.entity.view.JiedanxinxiView;

import com.yb.service.JiedanxinxiService;
import com.yb.utils.PageUtils;
import com.yb.utils.R;
import com.yb.utils.EncryptUtil;
import com.yb.utils.MPUtil;
import com.yb.utils.MapUtils;
import com.yb.utils.CommonUtil;
import java.io.IOException;

/**
 * 接单信息
 * 后端接口
 * @author 
 * @email 
 * @date 2026-01-10 20:50:16
 */
@RestController
@RequestMapping("/jiedanxinxi")
public class JiedanxinxiController {
    @Autowired
    private JiedanxinxiService jiedanxinxiService;










    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiedanxinxiEntity jiedanxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("huozhu")) {
			jiedanxinxi.setHuozhuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("siji")) {
			jiedanxinxi.setSijizhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        QueryWrapper<JiedanxinxiEntity> ew = new QueryWrapper<JiedanxinxiEntity>();


        //查询结果
		PageUtils page = jiedanxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiedanxinxi), params), params));
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
    public R list(@RequestParam Map<String, Object> params,JiedanxinxiEntity jiedanxinxi,
                @RequestParam(required = false) Double lichengstart,
                @RequestParam(required = false) Double lichengend,
                @RequestParam(required = false) Double jiagestart,
                @RequestParam(required = false) Double jiageend,
                @RequestParam(required = false) Double yuestart,
                @RequestParam(required = false) Double yueend,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date jiedanshijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date jiedanshijianend,
		HttpServletRequest request){
        //设置查询条件
        QueryWrapper<JiedanxinxiEntity> ew = new QueryWrapper<JiedanxinxiEntity>();
        if(lichengstart!=null) ew.ge("licheng", lichengstart);
        if(lichengend!=null) ew.le("licheng", lichengend);
        if(jiagestart!=null) ew.ge("jiage", jiagestart);
        if(jiageend!=null) ew.le("jiage", jiageend);
        if(yuestart!=null) ew.ge("yue", yuestart);
        if(yueend!=null) ew.le("yue", yueend);
        if(jiedanshijianstart!=null) ew.ge("jiedanshijian", jiedanshijianstart);
        if(jiedanshijianend!=null) ew.le("jiedanshijian", jiedanshijianend);

        //查询结果
		PageUtils page = jiedanxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiedanxinxi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiedanxinxiEntity jiedanxinxi){
       	QueryWrapper<JiedanxinxiEntity> ew = new QueryWrapper<JiedanxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiedanxinxi, "jiedanxinxi"));
        return R.ok().put("data", jiedanxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiedanxinxiEntity jiedanxinxi){
        QueryWrapper< JiedanxinxiEntity> ew = new QueryWrapper< JiedanxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiedanxinxi, "jiedanxinxi"));
		JiedanxinxiView jiedanxinxiView =  jiedanxinxiService.selectView(ew);
		return R.ok("查询接单信息成功").put("data", jiedanxinxiView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiedanxinxiEntity jiedanxinxi = jiedanxinxiService.getById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jiedanxinxi,deSens);
        return R.ok().put("data", jiedanxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiedanxinxiEntity jiedanxinxi = jiedanxinxiService.getById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jiedanxinxi,deSens);
        return R.ok().put("data", jiedanxinxi);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增接单信息")
    public R save(@RequestBody JiedanxinxiEntity jiedanxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiedanxinxi);
        jiedanxinxiService.save(jiedanxinxi);
        return R.ok().put("data",jiedanxinxi.getId());
    }

    /**
     * 前台保存
     */
    @SysLog("新增接单信息")
    @RequestMapping("/add")
    public R add(@RequestBody JiedanxinxiEntity jiedanxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiedanxinxi);
        jiedanxinxiService.save(jiedanxinxi);
        return R.ok().put("data",jiedanxinxi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改接单信息")
    public R update(@RequestBody JiedanxinxiEntity jiedanxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiedanxinxi);
        //全部更新
        jiedanxinxiService.updateById(jiedanxinxi);
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除接单信息")
    public R delete(@RequestBody Long[] ids){
        jiedanxinxiService.removeBatchByIds(Arrays.asList(ids));
        return R.ok();
    }





    // hasAlipay:否




}
