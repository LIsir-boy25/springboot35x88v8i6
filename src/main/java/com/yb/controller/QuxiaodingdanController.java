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

import com.yb.entity.QuxiaodingdanEntity;
import com.yb.entity.view.QuxiaodingdanView;

import com.yb.service.QuxiaodingdanService;
import com.yb.utils.PageUtils;
import com.yb.utils.R;
import com.yb.utils.EncryptUtil;
import com.yb.utils.MPUtil;
import com.yb.utils.MapUtils;
import com.yb.utils.CommonUtil;
import java.io.IOException;

/**
 * 取消订单
 * 后端接口
 * @author 
 * @email 
 * @date 2026-01-10 20:50:16
 */
@RestController
@RequestMapping("/quxiaodingdan")
public class QuxiaodingdanController {
    @Autowired
    private QuxiaodingdanService quxiaodingdanService;










    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,QuxiaodingdanEntity quxiaodingdan,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("huozhu")) {
			quxiaodingdan.setHuozhuzhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        QueryWrapper<QuxiaodingdanEntity> ew = new QueryWrapper<QuxiaodingdanEntity>();


        //查询结果
		PageUtils page = quxiaodingdanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, quxiaodingdan), params), params));
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
    public R list(@RequestParam Map<String, Object> params,QuxiaodingdanEntity quxiaodingdan,
                @RequestParam(required = false) Double lichengstart,
                @RequestParam(required = false) Double lichengend,
                @RequestParam(required = false) Double jiagestart,
                @RequestParam(required = false) Double jiageend,
                @RequestParam(required = false) Double yuestart,
                @RequestParam(required = false) Double yueend,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date quxiaoshijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date quxiaoshijianend,
		HttpServletRequest request){
        //设置查询条件
        QueryWrapper<QuxiaodingdanEntity> ew = new QueryWrapper<QuxiaodingdanEntity>();
        if(lichengstart!=null) ew.ge("licheng", lichengstart);
        if(lichengend!=null) ew.le("licheng", lichengend);
        if(jiagestart!=null) ew.ge("jiage", jiagestart);
        if(jiageend!=null) ew.le("jiage", jiageend);
        if(yuestart!=null) ew.ge("yue", yuestart);
        if(yueend!=null) ew.le("yue", yueend);
        if(quxiaoshijianstart!=null) ew.ge("quxiaoshijian", quxiaoshijianstart);
        if(quxiaoshijianend!=null) ew.le("quxiaoshijian", quxiaoshijianend);

        //查询结果
		PageUtils page = quxiaodingdanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, quxiaodingdan), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( QuxiaodingdanEntity quxiaodingdan){
       	QueryWrapper<QuxiaodingdanEntity> ew = new QueryWrapper<QuxiaodingdanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( quxiaodingdan, "quxiaodingdan"));
        return R.ok().put("data", quxiaodingdanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(QuxiaodingdanEntity quxiaodingdan){
        QueryWrapper< QuxiaodingdanEntity> ew = new QueryWrapper< QuxiaodingdanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( quxiaodingdan, "quxiaodingdan"));
		QuxiaodingdanView quxiaodingdanView =  quxiaodingdanService.selectView(ew);
		return R.ok("查询取消订单成功").put("data", quxiaodingdanView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        QuxiaodingdanEntity quxiaodingdan = quxiaodingdanService.getById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(quxiaodingdan,deSens);
        return R.ok().put("data", quxiaodingdan);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        QuxiaodingdanEntity quxiaodingdan = quxiaodingdanService.getById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(quxiaodingdan,deSens);
        return R.ok().put("data", quxiaodingdan);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增取消订单")
    public R save(@RequestBody QuxiaodingdanEntity quxiaodingdan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(quxiaodingdan);
        quxiaodingdanService.save(quxiaodingdan);
        return R.ok().put("data",quxiaodingdan.getId());
    }

    /**
     * 前台保存
     */
    @SysLog("新增取消订单")
    @RequestMapping("/add")
    public R add(@RequestBody QuxiaodingdanEntity quxiaodingdan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(quxiaodingdan);
        quxiaodingdanService.save(quxiaodingdan);
        return R.ok().put("data",quxiaodingdan.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改取消订单")
    public R update(@RequestBody QuxiaodingdanEntity quxiaodingdan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(quxiaodingdan);
        //全部更新
        quxiaodingdanService.updateById(quxiaodingdan);
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除取消订单")
    public R delete(@RequestBody Long[] ids){
        quxiaodingdanService.removeBatchByIds(Arrays.asList(ids));
        return R.ok();
    }





    // hasAlipay:否




}
