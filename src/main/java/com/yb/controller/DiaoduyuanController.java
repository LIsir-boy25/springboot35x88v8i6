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
import com.yb.service.TokenService;
import com.yb.entity.TokenEntity;
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

import com.yb.entity.DiaoduyuanEntity;
import com.yb.entity.view.DiaoduyuanView;

import com.yb.service.DiaoduyuanService;
import com.yb.utils.PageUtils;
import com.yb.utils.R;
import com.yb.utils.EncryptUtil;
import com.yb.utils.MPUtil;
import com.yb.utils.MapUtils;
import com.yb.utils.CommonUtil;
import java.io.IOException;

/**
 * 调度员
 * 后端接口
 * @author 
 * @email 
 * @date 2026-01-10 20:50:15
 */
@RestController
@RequestMapping("/diaoduyuan")
public class DiaoduyuanController {
    @Autowired
    private DiaoduyuanService diaoduyuanService;







	@Autowired
	private TokenService tokenService;

	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		// 根据登录查询用户信息
        DiaoduyuanEntity u = diaoduyuanService.getOne(new QueryWrapper<DiaoduyuanEntity>().eq("diaoduzhanghao", username));
        // 判断用户锁定状态
        if(u!=null && u.getStatus().intValue()==1) {
            //返回已锁定提示
            return R.error("账号已锁定，请联系管理员。");
        }
        // 当用户不存在或md5方式验证密码不通过时
        if(u==null || !u.getMima().equals(EncryptUtil.md5(password))) {
            //账号或密码不正确提示
			return R.error("账号或密码不正确");
		}
        // 获取登录token
		String token = tokenService.generateToken(u.getId(), username,"diaoduyuan",  "管理员" );
        //返回token
		return R.ok().put("token", token);
	}



	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody DiaoduyuanEntity diaoduyuan){
    	//ValidatorUtils.validateEntity(diaoduyuan);
        //根据登录账号获取用户信息判断是否存在该用户，否则返回错误信息
    	DiaoduyuanEntity u = diaoduyuanService.getOne(new QueryWrapper<DiaoduyuanEntity>().eq("diaoduzhanghao", diaoduyuan.getDiaoduzhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
        //判断是否存在相同调度账号，否则返回错误信息
        if(diaoduyuanService.count(new QueryWrapper<DiaoduyuanEntity>().eq("diaoduzhanghao", diaoduyuan.getDiaoduzhanghao()))>0) {
            return R.error("调度账号已存在");
        }
		Long uId = new Date().getTime();
		diaoduyuan.setId(uId);
        //设置登录密码md5方式加密
        diaoduyuan.setMima(EncryptUtil.md5(diaoduyuan.getMima()));
        //保存用户
        diaoduyuanService.save(diaoduyuan);
        return R.ok();
    }



	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}

	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        DiaoduyuanEntity u = diaoduyuanService.getById(id);
        return R.ok().put("data", u);
    }

    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	//根据登录账号判断是否存在用户信息，否则返回错误信息
        DiaoduyuanEntity u = diaoduyuanService.getOne(new QueryWrapper<DiaoduyuanEntity>().eq("diaoduzhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        //重置密码为123456，并使用md5方式加密
        u.setMima(EncryptUtil.md5("123456"));
        diaoduyuanService.updateById(u);
        return R.ok("密码已重置为：123456");
    }

    /**
     * 获取账号列表
     */
    @RequestMapping("/accountList")
    public R getAccountList(@RequestParam Map<String, Object> params,DiaoduyuanEntity diaoduyuan){
        QueryWrapper<DiaoduyuanEntity> ew = new QueryWrapper<DiaoduyuanEntity>();
        QueryWrapper<DiaoduyuanEntity> wrapper =MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, diaoduyuan), params), params);
        List<Map> list = diaoduyuanService.list(wrapper).stream().map(v -> {
            Map<String, Object> map = new HashMap<>();
            map.put("id", v.getId());
            map.put("account", v.getDiaoduzhanghao());
            return map;
        }).collect(Collectors.toList());
        return R.ok().put("data", list);
    }






    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiaoduyuanEntity diaoduyuan,
		HttpServletRequest request){
        //设置查询条件
        QueryWrapper<DiaoduyuanEntity> ew = new QueryWrapper<DiaoduyuanEntity>();


        //查询结果
		PageUtils page = diaoduyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, diaoduyuan), params), params));
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
    public R list(@RequestParam Map<String, Object> params,DiaoduyuanEntity diaoduyuan,
                @RequestParam(required = false) Double statusstart,
                @RequestParam(required = false) Double statusend,
		HttpServletRequest request){
        //设置查询条件
        QueryWrapper<DiaoduyuanEntity> ew = new QueryWrapper<DiaoduyuanEntity>();
        if(statusstart!=null) ew.ge("status", statusstart);
        if(statusend!=null) ew.le("status", statusend);

        //查询结果
		PageUtils page = diaoduyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, diaoduyuan), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiaoduyuanEntity diaoduyuan){
       	QueryWrapper<DiaoduyuanEntity> ew = new QueryWrapper<DiaoduyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( diaoduyuan, "diaoduyuan"));
        return R.ok().put("data", diaoduyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiaoduyuanEntity diaoduyuan){
        QueryWrapper< DiaoduyuanEntity> ew = new QueryWrapper< DiaoduyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( diaoduyuan, "diaoduyuan"));
		DiaoduyuanView diaoduyuanView =  diaoduyuanService.selectView(ew);
		return R.ok("查询调度员成功").put("data", diaoduyuanView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiaoduyuanEntity diaoduyuan = diaoduyuanService.getById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(diaoduyuan,deSens);
        return R.ok().put("data", diaoduyuan);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiaoduyuanEntity diaoduyuan = diaoduyuanService.getById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(diaoduyuan,deSens);
        return R.ok().put("data", diaoduyuan);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增调度员")
    public R save(@RequestBody DiaoduyuanEntity diaoduyuan, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(diaoduyuanService.count(new QueryWrapper<DiaoduyuanEntity>().eq("diaoduzhanghao", diaoduyuan.getDiaoduzhanghao()))>0) {
            return R.error("调度账号已存在");
        }
        //ValidatorUtils.validateEntity(diaoduyuan);
        //验证账号唯一性，否则返回错误信息
        DiaoduyuanEntity u = diaoduyuanService.getOne(new QueryWrapper<DiaoduyuanEntity>().eq("diaoduzhanghao", diaoduyuan.getDiaoduzhanghao()));
        if(u!=null) {
            return R.error("用户已存在");
        }
    	diaoduyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
		diaoduyuan.setId(new Date().getTime());
        //密码使用md5方式加密
        diaoduyuan.setMima(EncryptUtil.md5(diaoduyuan.getMima()));
        diaoduyuanService.save(diaoduyuan);
        return R.ok().put("data",diaoduyuan.getId());
    }

    /**
     * 前台保存
     */
    @SysLog("新增调度员")
    @RequestMapping("/add")
    public R add(@RequestBody DiaoduyuanEntity diaoduyuan, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(diaoduyuanService.count(new QueryWrapper<DiaoduyuanEntity>().eq("diaoduzhanghao", diaoduyuan.getDiaoduzhanghao()))>0) {
            return R.error("调度账号已存在");
        }
        //ValidatorUtils.validateEntity(diaoduyuan);
        //验证账号唯一性，否则返回错误信息
        DiaoduyuanEntity u = diaoduyuanService.getOne(new QueryWrapper<DiaoduyuanEntity>().eq("diaoduzhanghao", diaoduyuan.getDiaoduzhanghao()));
        if(u!=null) {
            return R.error("用户已存在");
        }
    	diaoduyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
		diaoduyuan.setId(new Date().getTime());
        //密码使用md5方式加密
        diaoduyuan.setMima(EncryptUtil.md5(diaoduyuan.getMima()));
        diaoduyuanService.save(diaoduyuan);
        return R.ok().put("data",diaoduyuan.getId());
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        DiaoduyuanEntity diaoduyuan = diaoduyuanService.getOne(new QueryWrapper<DiaoduyuanEntity>().eq("diaoduzhanghao", username));
        return R.ok().put("data", diaoduyuan);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiaoduyuanEntity diaoduyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(diaoduyuan);
        //验证字段唯一性，否则返回错误信息
        if(diaoduyuanService.count(new QueryWrapper<DiaoduyuanEntity>().ne("id", diaoduyuan.getId()).eq("diaoduzhanghao", diaoduyuan.getDiaoduzhanghao()))>0) {
            return R.error("调度账号已存在");
        }
	    DiaoduyuanEntity diaoduyuanEntity = diaoduyuanService.getById(diaoduyuan.getId());
        //如果密码不为空，则判断是否和输入密码一致，不一致则重新设置
        if(StringUtils.isNotBlank(diaoduyuan.getMima()) && !diaoduyuan.getMima().equals(diaoduyuanEntity.getMima())) {
            //密码使用md5方式加密
            diaoduyuan.setMima(EncryptUtil.md5(diaoduyuan.getMima()));
        }
        //全部更新
        diaoduyuanService.updateById(diaoduyuan);
        if(null!=diaoduyuan.getDiaoduzhanghao())
        {
            // 修改token
            TokenEntity tokenEntity = new TokenEntity();
            tokenEntity.setUsername(diaoduyuan.getDiaoduzhanghao());
            tokenService.update(tokenEntity, new UpdateWrapper<TokenEntity>().eq("userid", diaoduyuan.getId()));
        }
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除调度员")
    public R delete(@RequestBody Long[] ids){
        diaoduyuanService.removeBatchByIds(Arrays.asList(ids));
        return R.ok();
    }





    // hasAlipay:否




}
