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

import com.yb.entity.HuozhuEntity;
import com.yb.entity.view.HuozhuView;

import com.yb.service.HuozhuService;
import com.yb.utils.PageUtils;
import com.yb.utils.R;
import com.yb.utils.EncryptUtil;
import com.yb.utils.MPUtil;
import com.yb.utils.MapUtils;
import com.yb.utils.CommonUtil;
import java.io.IOException;

/**
 * 货主
 * 后端接口
 * @author 
 * @email 
 * @date 2026-01-10 20:50:15
 */
@RestController
@RequestMapping("/huozhu")
public class HuozhuController {
    @Autowired
    private HuozhuService huozhuService;







	@Autowired
	private TokenService tokenService;

	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		// 根据登录查询用户信息
        HuozhuEntity u = huozhuService.getOne(new QueryWrapper<HuozhuEntity>().eq("huozhuzhanghao", username));
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
		String token = tokenService.generateToken(u.getId(), username,"huozhu",  "货主" );
        //返回token
		return R.ok().put("token", token);
	}

    /**
     * 人脸登录
     */
    @IgnoreAuth
    @RequestMapping(value = "/faceLogin")
    public R faceLogin(String face, HttpServletRequest request) {
        //获取所有用户信息
        List<HuozhuEntity> uList = huozhuService.list(new QueryWrapper<HuozhuEntity>());
        R result = null;
        HuozhuEntity user = null;
        for(HuozhuEntity u : uList) {
            if (null != CommonUtil.getPropertyByFieldNames(u, "touxiang", "headportrait")) {
                // 循环将集合中的用户头像跟前端提供的头像照片做比较
                result = CommonUtil.matchFace(face, CommonUtil.getPropertyByFieldNames(u, "touxiang", "headportrait").toString().substring(7));
                // 当照片相似度大于等于80时，则认为人脸匹配成功
                if (result.get("code").toString().equals("0")&&new BigDecimal(result.get("score").toString()).compareTo(new BigDecimal(80)) == 1) {
                    user = u;
                    break;
                }
            }
        }
        //当照片未匹配到相似度高于80的用户时，认为人脸识别失败，并返回提示
        if(user==null) {
            return R.error("人脸识别失败");
        }
        // 获取登录token
		String token = tokenService.generateToken(user.getId(), user.getHuozhuzhanghao(),"huozhu", "货主");
                //返回token及登录账号
        return R.ok().put("token", token).put("username", user.getHuozhuzhanghao());
    }


	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody HuozhuEntity huozhu){
    	//ValidatorUtils.validateEntity(huozhu);
        //根据登录账号获取用户信息判断是否存在该用户，否则返回错误信息
    	HuozhuEntity u = huozhuService.getOne(new QueryWrapper<HuozhuEntity>().eq("huozhuzhanghao", huozhu.getHuozhuzhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
        //判断是否存在相同货主账号，否则返回错误信息
        if(huozhuService.count(new QueryWrapper<HuozhuEntity>().eq("huozhuzhanghao", huozhu.getHuozhuzhanghao()))>0) {
            return R.error("货主账号已存在");
        }
		Long uId = new Date().getTime();
		huozhu.setId(uId);
        //设置登录密码md5方式加密
        huozhu.setMima(EncryptUtil.md5(huozhu.getMima()));
        //保存用户
        huozhuService.save(huozhu);
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
        HuozhuEntity u = huozhuService.getById(id);
        return R.ok().put("data", u);
    }

    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	//根据登录账号判断是否存在用户信息，否则返回错误信息
        HuozhuEntity u = huozhuService.getOne(new QueryWrapper<HuozhuEntity>().eq("huozhuzhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        //重置密码为123456，并使用md5方式加密
        u.setMima(EncryptUtil.md5("123456"));
        huozhuService.updateById(u);
        return R.ok("密码已重置为：123456");
    }

    /**
     * 获取账号列表
     */
    @RequestMapping("/accountList")
    public R getAccountList(@RequestParam Map<String, Object> params,HuozhuEntity huozhu){
        QueryWrapper<HuozhuEntity> ew = new QueryWrapper<HuozhuEntity>();
        QueryWrapper<HuozhuEntity> wrapper =MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huozhu), params), params);
        List<Map> list = huozhuService.list(wrapper).stream().map(v -> {
            Map<String, Object> map = new HashMap<>();
            map.put("id", v.getId());
            map.put("account", v.getHuozhuzhanghao());
            return map;
        }).collect(Collectors.toList());
        return R.ok().put("data", list);
    }






    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,HuozhuEntity huozhu,
		HttpServletRequest request){
        //设置查询条件
        QueryWrapper<HuozhuEntity> ew = new QueryWrapper<HuozhuEntity>();


        //查询结果
		PageUtils page = huozhuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huozhu), params), params));
        Map<String, String> deSens = new HashMap<>();
        deSens.put("huozhuxingming","名");
        deSens.put("lianxifangshi","手");
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }


    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,HuozhuEntity huozhu,
                @RequestParam(required = false) Double statusstart,
                @RequestParam(required = false) Double statusend,
		HttpServletRequest request){
        //设置查询条件
        QueryWrapper<HuozhuEntity> ew = new QueryWrapper<HuozhuEntity>();
        if(statusstart!=null) ew.ge("status", statusstart);
        if(statusend!=null) ew.le("status", statusend);

        //查询结果
		PageUtils page = huozhuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huozhu), params), params));
        Map<String, String> deSens = new HashMap<>();
        deSens.put("huozhuxingming","名");
        deSens.put("lianxifangshi","手");
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HuozhuEntity huozhu){
       	QueryWrapper<HuozhuEntity> ew = new QueryWrapper<HuozhuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( huozhu, "huozhu"));
        return R.ok().put("data", huozhuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HuozhuEntity huozhu){
        QueryWrapper< HuozhuEntity> ew = new QueryWrapper< HuozhuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( huozhu, "huozhu"));
		HuozhuView huozhuView =  huozhuService.selectView(ew);
		return R.ok("查询货主成功").put("data", huozhuView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HuozhuEntity huozhu = huozhuService.getById(id);
        Map<String, String> deSens = new HashMap<>();
        deSens.put("huozhuxingming","名");
        deSens.put("lianxifangshi","手");
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(huozhu,deSens);
        return R.ok().put("data", huozhu);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HuozhuEntity huozhu = huozhuService.getById(id);
        Map<String, String> deSens = new HashMap<>();
        deSens.put("huozhuxingming","名");
        deSens.put("lianxifangshi","手");
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(huozhu,deSens);
        return R.ok().put("data", huozhu);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增货主")
    public R save(@RequestBody HuozhuEntity huozhu, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(huozhuService.count(new QueryWrapper<HuozhuEntity>().eq("huozhuzhanghao", huozhu.getHuozhuzhanghao()))>0) {
            return R.error("货主账号已存在");
        }
        //ValidatorUtils.validateEntity(huozhu);
        //验证账号唯一性，否则返回错误信息
        HuozhuEntity u = huozhuService.getOne(new QueryWrapper<HuozhuEntity>().eq("huozhuzhanghao", huozhu.getHuozhuzhanghao()));
        if(u!=null) {
            return R.error("用户已存在");
        }
    	huozhu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
		huozhu.setId(new Date().getTime());
        //密码使用md5方式加密
        huozhu.setMima(EncryptUtil.md5(huozhu.getMima()));
        huozhuService.save(huozhu);
        return R.ok().put("data",huozhu.getId());
    }

    /**
     * 前台保存
     */
    @SysLog("新增货主")
    @RequestMapping("/add")
    public R add(@RequestBody HuozhuEntity huozhu, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(huozhuService.count(new QueryWrapper<HuozhuEntity>().eq("huozhuzhanghao", huozhu.getHuozhuzhanghao()))>0) {
            return R.error("货主账号已存在");
        }
        //ValidatorUtils.validateEntity(huozhu);
        //验证账号唯一性，否则返回错误信息
        HuozhuEntity u = huozhuService.getOne(new QueryWrapper<HuozhuEntity>().eq("huozhuzhanghao", huozhu.getHuozhuzhanghao()));
        if(u!=null) {
            return R.error("用户已存在");
        }
    	huozhu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
		huozhu.setId(new Date().getTime());
        //密码使用md5方式加密
        huozhu.setMima(EncryptUtil.md5(huozhu.getMima()));
        huozhuService.save(huozhu);
        return R.ok().put("data",huozhu.getId());
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        HuozhuEntity huozhu = huozhuService.getOne(new QueryWrapper<HuozhuEntity>().eq("huozhuzhanghao", username));
        return R.ok().put("data", huozhu);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody HuozhuEntity huozhu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(huozhu);
        //验证字段唯一性，否则返回错误信息
        if(huozhuService.count(new QueryWrapper<HuozhuEntity>().ne("id", huozhu.getId()).eq("huozhuzhanghao", huozhu.getHuozhuzhanghao()))>0) {
            return R.error("货主账号已存在");
        }
	    HuozhuEntity huozhuEntity = huozhuService.getById(huozhu.getId());
        //如果密码不为空，则判断是否和输入密码一致，不一致则重新设置
        if(StringUtils.isNotBlank(huozhu.getMima()) && !huozhu.getMima().equals(huozhuEntity.getMima())) {
            //密码使用md5方式加密
            huozhu.setMima(EncryptUtil.md5(huozhu.getMima()));
        }
        //全部更新
        huozhuService.updateById(huozhu);
        if(null!=huozhu.getHuozhuzhanghao())
        {
            // 修改token
            TokenEntity tokenEntity = new TokenEntity();
            tokenEntity.setUsername(huozhu.getHuozhuzhanghao());
            tokenService.update(tokenEntity, new UpdateWrapper<TokenEntity>().eq("userid", huozhu.getId()));
        }
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除货主")
    public R delete(@RequestBody Long[] ids){
        huozhuService.removeBatchByIds(Arrays.asList(ids));
        return R.ok();
    }





    // hasAlipay:否




}
