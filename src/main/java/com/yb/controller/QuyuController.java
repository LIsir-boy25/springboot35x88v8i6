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

import com.yb.entity.QuyuEntity;
import com.yb.entity.view.QuyuView;

import com.yb.service.QuyuService;
import com.yb.utils.PageUtils;
import com.yb.utils.R;
import com.yb.utils.EncryptUtil;
import com.yb.utils.MPUtil;
import com.yb.utils.MapUtils;
import com.yb.utils.CommonUtil;
import java.io.IOException;

/**
 * 区域
 * 后端接口
 * @author 
 * @email 
 * @date 2026-01-10 20:50:16
 */
@RestController
@RequestMapping("/quyu")
public class QuyuController {
    @Autowired
    private QuyuService quyuService;










    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,QuyuEntity quyu,
		HttpServletRequest request){
        //设置查询条件
        QueryWrapper<QuyuEntity> ew = new QueryWrapper<QuyuEntity>();


        //查询结果
		PageUtils page = quyuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, quyu), params), params));
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
    public R list(@RequestParam Map<String, Object> params,QuyuEntity quyu,
		HttpServletRequest request){
        //设置查询条件
        QueryWrapper<QuyuEntity> ew = new QueryWrapper<QuyuEntity>();

        //查询结果
		PageUtils page = quyuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, quyu), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( QuyuEntity quyu){
       	QueryWrapper<QuyuEntity> ew = new QueryWrapper<QuyuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( quyu, "quyu"));
        return R.ok().put("data", quyuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(QuyuEntity quyu){
        QueryWrapper< QuyuEntity> ew = new QueryWrapper< QuyuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( quyu, "quyu"));
		QuyuView quyuView =  quyuService.selectView(ew);
		return R.ok("查询区域成功").put("data", quyuView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        QuyuEntity quyu = quyuService.getById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(quyu,deSens);
        return R.ok().put("data", quyu);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        QuyuEntity quyu = quyuService.getById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(quyu,deSens);
        return R.ok().put("data", quyu);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增区域")
    public R save(@RequestBody QuyuEntity quyu, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(quyuService.count(new QueryWrapper<QuyuEntity>().eq("quyu", quyu.getQuyu()))>0) {
            return R.error("区域已存在");
        }
        //ValidatorUtils.validateEntity(quyu);
        quyuService.save(quyu);
        return R.ok().put("data",quyu.getId());
    }

    /**
     * 前台保存
     */
    @SysLog("新增区域")
    @RequestMapping("/add")
    public R add(@RequestBody QuyuEntity quyu, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(quyuService.count(new QueryWrapper<QuyuEntity>().eq("quyu", quyu.getQuyu()))>0) {
            return R.error("区域已存在");
        }
        //ValidatorUtils.validateEntity(quyu);
        quyuService.save(quyu);
        return R.ok().put("data",quyu.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改区域")
    public R update(@RequestBody QuyuEntity quyu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(quyu);
        //验证字段唯一性，否则返回错误信息
        if(quyuService.count(new QueryWrapper<QuyuEntity>().ne("id", quyu.getId()).eq("quyu", quyu.getQuyu()))>0) {
            return R.error("区域已存在");
        }
        //全部更新
        quyuService.updateById(quyu);
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除区域")
    public R delete(@RequestBody Long[] ids){
        quyuService.removeBatchByIds(Arrays.asList(ids));
        return R.ok();
    }





    // hasAlipay:否




}
