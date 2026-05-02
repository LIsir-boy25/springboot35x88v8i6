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

import com.yb.entity.YichangfankuiEntity;
import com.yb.entity.view.YichangfankuiView;

import com.yb.service.YichangfankuiService;
import com.yb.utils.PageUtils;
import com.yb.utils.R;
import com.yb.utils.EncryptUtil;
import com.yb.utils.MPUtil;
import com.yb.utils.MapUtils;
import com.yb.utils.CommonUtil;
import java.io.IOException;

/**
 * 异常反馈
 * 后端接口
 * @author 
 * @email 
 * @date 2026-01-10 20:50:17
 */
@RestController
@RequestMapping("/yichangfankui")
public class YichangfankuiController {
    @Autowired
    private YichangfankuiService yichangfankuiService;










    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YichangfankuiEntity yichangfankui,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("huozhu")) {
			yichangfankui.setHuozhuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("siji")) {
			yichangfankui.setSijizhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        QueryWrapper<YichangfankuiEntity> ew = new QueryWrapper<YichangfankuiEntity>();


        //查询结果
		PageUtils page = yichangfankuiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yichangfankui), params), params));
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
    public R list(@RequestParam Map<String, Object> params,YichangfankuiEntity yichangfankui,
                @RequestParam(required = false) Double lichengstart,
                @RequestParam(required = false) Double lichengend,
                @RequestParam(required = false) Double jiagestart,
                @RequestParam(required = false) Double jiageend,
                @RequestParam(required = false) Double yuestart,
                @RequestParam(required = false) Double yueend,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date fankuishijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date fankuishijianend,
		HttpServletRequest request){
        //设置查询条件
        QueryWrapper<YichangfankuiEntity> ew = new QueryWrapper<YichangfankuiEntity>();
        if(lichengstart!=null) ew.ge("licheng", lichengstart);
        if(lichengend!=null) ew.le("licheng", lichengend);
        if(jiagestart!=null) ew.ge("jiage", jiagestart);
        if(jiageend!=null) ew.le("jiage", jiageend);
        if(yuestart!=null) ew.ge("yue", yuestart);
        if(yueend!=null) ew.le("yue", yueend);
        if(fankuishijianstart!=null) ew.ge("fankuishijian", fankuishijianstart);
        if(fankuishijianend!=null) ew.le("fankuishijian", fankuishijianend);

        //查询结果
		PageUtils page = yichangfankuiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yichangfankui), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YichangfankuiEntity yichangfankui){
       	QueryWrapper<YichangfankuiEntity> ew = new QueryWrapper<YichangfankuiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yichangfankui, "yichangfankui"));
        return R.ok().put("data", yichangfankuiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YichangfankuiEntity yichangfankui){
        QueryWrapper< YichangfankuiEntity> ew = new QueryWrapper< YichangfankuiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yichangfankui, "yichangfankui"));
		YichangfankuiView yichangfankuiView =  yichangfankuiService.selectView(ew);
		return R.ok("查询异常反馈成功").put("data", yichangfankuiView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YichangfankuiEntity yichangfankui = yichangfankuiService.getById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yichangfankui,deSens);
        return R.ok().put("data", yichangfankui);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YichangfankuiEntity yichangfankui = yichangfankuiService.getById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yichangfankui,deSens);
        return R.ok().put("data", yichangfankui);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增异常反馈")
    public R save(@RequestBody YichangfankuiEntity yichangfankui, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yichangfankui);
        yichangfankuiService.save(yichangfankui);
        return R.ok().put("data",yichangfankui.getId());
    }

    /**
     * 前台保存
     */
    @SysLog("新增异常反馈")
    @RequestMapping("/add")
    public R add(@RequestBody YichangfankuiEntity yichangfankui, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yichangfankui);
        yichangfankuiService.save(yichangfankui);
        return R.ok().put("data",yichangfankui.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改异常反馈")
    public R update(@RequestBody YichangfankuiEntity yichangfankui, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yichangfankui);
        //全部更新
        yichangfankuiService.updateById(yichangfankui);
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除异常反馈")
    public R delete(@RequestBody Long[] ids){
        yichangfankuiService.removeBatchByIds(Arrays.asList(ids));
        return R.ok();
    }





    // hasAlipay:否




}
