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

import com.yb.entity.XiehuoxinxiEntity;
import com.yb.entity.view.XiehuoxinxiView;

import com.yb.service.XiehuoxinxiService;
import com.yb.utils.PageUtils;
import com.yb.utils.R;
import com.yb.utils.EncryptUtil;
import com.yb.utils.MPUtil;
import com.yb.utils.MapUtils;
import com.yb.utils.CommonUtil;
import java.io.IOException;

/**
 * 卸货信息
 * 后端接口
 * @author 
 * @email 
 * @date 2026-01-10 20:50:17
 */
@RestController
@RequestMapping("/xiehuoxinxi")
public class XiehuoxinxiController {
    @Autowired
    private XiehuoxinxiService xiehuoxinxiService;










    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XiehuoxinxiEntity xiehuoxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("huozhu")) {
			xiehuoxinxi.setHuozhuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("siji")) {
			xiehuoxinxi.setSijizhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        QueryWrapper<XiehuoxinxiEntity> ew = new QueryWrapper<XiehuoxinxiEntity>();


        //查询结果
		PageUtils page = xiehuoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiehuoxinxi), params), params));
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
    public R list(@RequestParam Map<String, Object> params,XiehuoxinxiEntity xiehuoxinxi,
                @RequestParam(required = false) Double lichengstart,
                @RequestParam(required = false) Double lichengend,
                @RequestParam(required = false) Double jiagestart,
                @RequestParam(required = false) Double jiageend,
                @RequestParam(required = false) Double yuestart,
                @RequestParam(required = false) Double yueend,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date xiehuoshijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date xiehuoshijianend,
		HttpServletRequest request){
        //设置查询条件
        QueryWrapper<XiehuoxinxiEntity> ew = new QueryWrapper<XiehuoxinxiEntity>();
        if(lichengstart!=null) ew.ge("licheng", lichengstart);
        if(lichengend!=null) ew.le("licheng", lichengend);
        if(jiagestart!=null) ew.ge("jiage", jiagestart);
        if(jiageend!=null) ew.le("jiage", jiageend);
        if(yuestart!=null) ew.ge("yue", yuestart);
        if(yueend!=null) ew.le("yue", yueend);
        if(xiehuoshijianstart!=null) ew.ge("xiehuoshijian", xiehuoshijianstart);
        if(xiehuoshijianend!=null) ew.le("xiehuoshijian", xiehuoshijianend);

        //查询结果
		PageUtils page = xiehuoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiehuoxinxi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XiehuoxinxiEntity xiehuoxinxi){
       	QueryWrapper<XiehuoxinxiEntity> ew = new QueryWrapper<XiehuoxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xiehuoxinxi, "xiehuoxinxi"));
        return R.ok().put("data", xiehuoxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XiehuoxinxiEntity xiehuoxinxi){
        QueryWrapper< XiehuoxinxiEntity> ew = new QueryWrapper< XiehuoxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xiehuoxinxi, "xiehuoxinxi"));
		XiehuoxinxiView xiehuoxinxiView =  xiehuoxinxiService.selectView(ew);
		return R.ok("查询卸货信息成功").put("data", xiehuoxinxiView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XiehuoxinxiEntity xiehuoxinxi = xiehuoxinxiService.getById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(xiehuoxinxi,deSens);
        return R.ok().put("data", xiehuoxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XiehuoxinxiEntity xiehuoxinxi = xiehuoxinxiService.getById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(xiehuoxinxi,deSens);
        return R.ok().put("data", xiehuoxinxi);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增卸货信息")
    public R save(@RequestBody XiehuoxinxiEntity xiehuoxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xiehuoxinxi);
        xiehuoxinxiService.save(xiehuoxinxi);
        return R.ok().put("data",xiehuoxinxi.getId());
    }

    /**
     * 前台保存
     */
    @SysLog("新增卸货信息")
    @RequestMapping("/add")
    public R add(@RequestBody XiehuoxinxiEntity xiehuoxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xiehuoxinxi);
        xiehuoxinxiService.save(xiehuoxinxi);
        return R.ok().put("data",xiehuoxinxi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改卸货信息")
    public R update(@RequestBody XiehuoxinxiEntity xiehuoxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xiehuoxinxi);
        //全部更新
        xiehuoxinxiService.updateById(xiehuoxinxi);
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除卸货信息")
    public R delete(@RequestBody Long[] ids){
        xiehuoxinxiService.removeBatchByIds(Arrays.asList(ids));
        return R.ok();
    }





    // hasAlipay:否




}
