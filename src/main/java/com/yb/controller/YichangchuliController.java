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

import com.yb.entity.YichangchuliEntity;
import com.yb.entity.view.YichangchuliView;

import com.yb.service.YichangchuliService;
import com.yb.utils.PageUtils;
import com.yb.utils.R;
import com.yb.utils.EncryptUtil;
import com.yb.utils.MPUtil;
import com.yb.utils.MapUtils;
import com.yb.utils.CommonUtil;
import java.io.IOException;

/**
 * 异常处理
 * 后端接口
 * @author 
 * @email 
 * @date 2026-01-10 20:50:17
 */
@RestController
@RequestMapping("/yichangchuli")
public class YichangchuliController {
    @Autowired
    private YichangchuliService yichangchuliService;










    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YichangchuliEntity yichangchuli,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("huozhu")) {
			yichangchuli.setHuozhuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("siji")) {
			yichangchuli.setSijizhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        QueryWrapper<YichangchuliEntity> ew = new QueryWrapper<YichangchuliEntity>();


        //查询结果
		PageUtils page = yichangchuliService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yichangchuli), params), params));
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
    public R list(@RequestParam Map<String, Object> params,YichangchuliEntity yichangchuli,
                @RequestParam(required = false) Double lichengstart,
                @RequestParam(required = false) Double lichengend,
                @RequestParam(required = false) Double jiagestart,
                @RequestParam(required = false) Double jiageend,
                @RequestParam(required = false) Double yuestart,
                @RequestParam(required = false) Double yueend,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date chulishijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date chulishijianend,
		HttpServletRequest request){
        //设置查询条件
        QueryWrapper<YichangchuliEntity> ew = new QueryWrapper<YichangchuliEntity>();
        if(lichengstart!=null) ew.ge("licheng", lichengstart);
        if(lichengend!=null) ew.le("licheng", lichengend);
        if(jiagestart!=null) ew.ge("jiage", jiagestart);
        if(jiageend!=null) ew.le("jiage", jiageend);
        if(yuestart!=null) ew.ge("yue", yuestart);
        if(yueend!=null) ew.le("yue", yueend);
        if(chulishijianstart!=null) ew.ge("chulishijian", chulishijianstart);
        if(chulishijianend!=null) ew.le("chulishijian", chulishijianend);

        //查询结果
		PageUtils page = yichangchuliService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yichangchuli), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YichangchuliEntity yichangchuli){
       	QueryWrapper<YichangchuliEntity> ew = new QueryWrapper<YichangchuliEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yichangchuli, "yichangchuli"));
        return R.ok().put("data", yichangchuliService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YichangchuliEntity yichangchuli){
        QueryWrapper< YichangchuliEntity> ew = new QueryWrapper< YichangchuliEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yichangchuli, "yichangchuli"));
		YichangchuliView yichangchuliView =  yichangchuliService.selectView(ew);
		return R.ok("查询异常处理成功").put("data", yichangchuliView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YichangchuliEntity yichangchuli = yichangchuliService.getById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yichangchuli,deSens);
        return R.ok().put("data", yichangchuli);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YichangchuliEntity yichangchuli = yichangchuliService.getById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yichangchuli,deSens);
        return R.ok().put("data", yichangchuli);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增异常处理")
    public R save(@RequestBody YichangchuliEntity yichangchuli, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yichangchuli);
        yichangchuliService.save(yichangchuli);
        return R.ok().put("data",yichangchuli.getId());
    }

    /**
     * 前台保存
     */
    @SysLog("新增异常处理")
    @RequestMapping("/add")
    public R add(@RequestBody YichangchuliEntity yichangchuli, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yichangchuli);
        yichangchuliService.save(yichangchuli);
        return R.ok().put("data",yichangchuli.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改异常处理")
    public R update(@RequestBody YichangchuliEntity yichangchuli, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yichangchuli);
        //全部更新
        yichangchuliService.updateById(yichangchuli);
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除异常处理")
    public R delete(@RequestBody Long[] ids){
        yichangchuliService.removeBatchByIds(Arrays.asList(ids));
        return R.ok();
    }





    // hasAlipay:否




}
