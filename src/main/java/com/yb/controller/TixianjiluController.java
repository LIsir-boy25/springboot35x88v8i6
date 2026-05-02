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

import com.yb.entity.TixianjiluEntity;
import com.yb.entity.view.TixianjiluView;

import com.yb.service.TixianjiluService;
import com.yb.utils.PageUtils;
import com.yb.utils.R;
import com.yb.utils.EncryptUtil;
import com.yb.utils.MPUtil;
import com.yb.utils.MapUtils;
import com.yb.utils.CommonUtil;
import java.io.IOException;

/**
 * 提现记录
 * 后端接口
 * @author 
 * @email 
 * @date 2026-01-10 20:50:18
 */
@RestController
@RequestMapping("/tixianjilu")
public class TixianjiluController {
    @Autowired
    private TixianjiluService tixianjiluService;










    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TixianjiluEntity tixianjilu,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date tixianshijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date tixianshijianend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("siji")) {
			tixianjilu.setSijizhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        QueryWrapper<TixianjiluEntity> ew = new QueryWrapper<TixianjiluEntity>();
        if(tixianshijianstart!=null) ew.ge("tixianshijian", tixianshijianstart);
        if(tixianshijianend!=null) ew.le("tixianshijian", tixianshijianend);


        //查询结果
		PageUtils page = tixianjiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tixianjilu), params), params));
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
    public R list(@RequestParam Map<String, Object> params,TixianjiluEntity tixianjilu,
                @RequestParam(required = false) Double yuestart,
                @RequestParam(required = false) Double yueend,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date tixianshijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date tixianshijianend,
                @RequestParam(required = false) Double zhanghuyuestart,
                @RequestParam(required = false) Double zhanghuyueend,
		HttpServletRequest request){
        //设置查询条件
        QueryWrapper<TixianjiluEntity> ew = new QueryWrapper<TixianjiluEntity>();
        if(yuestart!=null) ew.ge("yue", yuestart);
        if(yueend!=null) ew.le("yue", yueend);
        if(tixianshijianstart!=null) ew.ge("tixianshijian", tixianshijianstart);
        if(tixianshijianend!=null) ew.le("tixianshijian", tixianshijianend);
        if(zhanghuyuestart!=null) ew.ge("zhanghuyue", zhanghuyuestart);
        if(zhanghuyueend!=null) ew.le("zhanghuyue", zhanghuyueend);

        //查询结果
		PageUtils page = tixianjiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tixianjilu), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TixianjiluEntity tixianjilu){
       	QueryWrapper<TixianjiluEntity> ew = new QueryWrapper<TixianjiluEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tixianjilu, "tixianjilu"));
        return R.ok().put("data", tixianjiluService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TixianjiluEntity tixianjilu){
        QueryWrapper< TixianjiluEntity> ew = new QueryWrapper< TixianjiluEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tixianjilu, "tixianjilu"));
		TixianjiluView tixianjiluView =  tixianjiluService.selectView(ew);
		return R.ok("查询提现记录成功").put("data", tixianjiluView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TixianjiluEntity tixianjilu = tixianjiluService.getById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(tixianjilu,deSens);
        return R.ok().put("data", tixianjilu);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TixianjiluEntity tixianjilu = tixianjiluService.getById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(tixianjilu,deSens);
        return R.ok().put("data", tixianjilu);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增提现记录")
    public R save(@RequestBody TixianjiluEntity tixianjilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tixianjilu);
        tixianjiluService.save(tixianjilu);
        return R.ok().put("data",tixianjilu.getId());
    }

    /**
     * 前台保存
     */
    @SysLog("新增提现记录")
    @RequestMapping("/add")
    public R add(@RequestBody TixianjiluEntity tixianjilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tixianjilu);
        tixianjiluService.save(tixianjilu);
        return R.ok().put("data",tixianjilu.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改提现记录")
    public R update(@RequestBody TixianjiluEntity tixianjilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tixianjilu);
        //全部更新
        tixianjiluService.updateById(tixianjilu);
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    @SysLog("审核提现记录")
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<TixianjiluEntity> list = new ArrayList<TixianjiluEntity>();
        for(Long id : ids) {
            TixianjiluEntity tixianjilu = tixianjiluService.getById(id);
            tixianjilu.setSfsh(sfsh);
            tixianjilu.setShhf(shhf);
            list.add(tixianjilu);
        }
        tixianjiluService.updateBatchById(list);
        return R.ok();
    }




    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除提现记录")
    public R delete(@RequestBody Long[] ids){
        tixianjiluService.removeBatchByIds(Arrays.asList(ids));
        return R.ok();
    }





    // hasAlipay:否




}
