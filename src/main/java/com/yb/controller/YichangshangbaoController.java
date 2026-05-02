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

import com.yb.entity.YichangshangbaoEntity;
import com.yb.entity.view.YichangshangbaoView;

import com.yb.service.YichangshangbaoService;
import com.yb.utils.PageUtils;
import com.yb.utils.R;
import com.yb.utils.EncryptUtil;
import com.yb.utils.MPUtil;
import com.yb.utils.MapUtils;
import com.yb.utils.CommonUtil;
import java.io.IOException;

/**
 * 异常上报
 * 后端接口
 * @author 
 * @email 
 * @date 2026-01-10 20:50:17
 */
@RestController
@RequestMapping("/yichangshangbao")
public class YichangshangbaoController {
    @Autowired
    private YichangshangbaoService yichangshangbaoService;










    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YichangshangbaoEntity yichangshangbao,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("huozhu")) {
			yichangshangbao.setHuozhuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("siji")) {
			yichangshangbao.setSijizhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        QueryWrapper<YichangshangbaoEntity> ew = new QueryWrapper<YichangshangbaoEntity>();


        //查询结果
		PageUtils page = yichangshangbaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yichangshangbao), params), params));
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
    public R list(@RequestParam Map<String, Object> params,YichangshangbaoEntity yichangshangbao,
                @RequestParam(required = false) Double lichengstart,
                @RequestParam(required = false) Double lichengend,
                @RequestParam(required = false) Double jiagestart,
                @RequestParam(required = false) Double jiageend,
                @RequestParam(required = false) Double yuestart,
                @RequestParam(required = false) Double yueend,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date shangbaoshijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date shangbaoshijianend,
		HttpServletRequest request){
        //设置查询条件
        QueryWrapper<YichangshangbaoEntity> ew = new QueryWrapper<YichangshangbaoEntity>();
        if(lichengstart!=null) ew.ge("licheng", lichengstart);
        if(lichengend!=null) ew.le("licheng", lichengend);
        if(jiagestart!=null) ew.ge("jiage", jiagestart);
        if(jiageend!=null) ew.le("jiage", jiageend);
        if(yuestart!=null) ew.ge("yue", yuestart);
        if(yueend!=null) ew.le("yue", yueend);
        if(shangbaoshijianstart!=null) ew.ge("shangbaoshijian", shangbaoshijianstart);
        if(shangbaoshijianend!=null) ew.le("shangbaoshijian", shangbaoshijianend);

        //查询结果
		PageUtils page = yichangshangbaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yichangshangbao), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YichangshangbaoEntity yichangshangbao){
       	QueryWrapper<YichangshangbaoEntity> ew = new QueryWrapper<YichangshangbaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yichangshangbao, "yichangshangbao"));
        return R.ok().put("data", yichangshangbaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YichangshangbaoEntity yichangshangbao){
        QueryWrapper< YichangshangbaoEntity> ew = new QueryWrapper< YichangshangbaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yichangshangbao, "yichangshangbao"));
		YichangshangbaoView yichangshangbaoView =  yichangshangbaoService.selectView(ew);
		return R.ok("查询异常上报成功").put("data", yichangshangbaoView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YichangshangbaoEntity yichangshangbao = yichangshangbaoService.getById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yichangshangbao,deSens);
        return R.ok().put("data", yichangshangbao);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YichangshangbaoEntity yichangshangbao = yichangshangbaoService.getById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yichangshangbao,deSens);
        return R.ok().put("data", yichangshangbao);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增异常上报")
    public R save(@RequestBody YichangshangbaoEntity yichangshangbao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yichangshangbao);
        yichangshangbaoService.save(yichangshangbao);
        return R.ok().put("data",yichangshangbao.getId());
    }

    /**
     * 前台保存
     */
    @SysLog("新增异常上报")
    @RequestMapping("/add")
    public R add(@RequestBody YichangshangbaoEntity yichangshangbao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yichangshangbao);
        yichangshangbaoService.save(yichangshangbao);
        return R.ok().put("data",yichangshangbao.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改异常上报")
    public R update(@RequestBody YichangshangbaoEntity yichangshangbao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yichangshangbao);
        //全部更新
        yichangshangbaoService.updateById(yichangshangbao);
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除异常上报")
    public R delete(@RequestBody Long[] ids){
        yichangshangbaoService.removeBatchByIds(Arrays.asList(ids));
        return R.ok();
    }





    // hasAlipay:否




}
