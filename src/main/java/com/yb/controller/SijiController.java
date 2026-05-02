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

import com.yb.entity.SijiEntity;
import com.yb.entity.view.SijiView;

import com.yb.service.SijiService;
import com.yb.utils.PageUtils;
import com.yb.utils.R;
import com.yb.utils.EncryptUtil;
import com.yb.utils.MPUtil;
import com.yb.utils.MapUtils;
import com.yb.utils.CommonUtil;
import java.io.IOException;

/**
 * 司机
 * 后端接口
 * @author 
 * @email 
 * @date 2026-01-10 20:50:15
 */
@RestController
@RequestMapping("/siji")
public class SijiController {
    @Autowired
    private SijiService sijiService;







	@Autowired
	private TokenService tokenService;

	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		// 根据登录查询用户信息
        SijiEntity u = sijiService.getOne(new QueryWrapper<SijiEntity>().eq("sijizhanghao", username));
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
        // 如果用户是待审核状态，返回请联系管理员审核提示
        if(!"是".equals(u.getSfsh())) return R.error("账号已锁定，请联系管理员审核。");
        // 获取登录token
		String token = tokenService.generateToken(u.getId(), username,"siji",  "司机" );
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
        List<SijiEntity> uList = sijiService.list(new QueryWrapper<SijiEntity>());
        R result = null;
        SijiEntity user = null;
        for(SijiEntity u : uList) {
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
        // 如果用户是待审核状态，返回请联系管理员审核提示
        if(!"是".equals(user.getSfsh())) return R.error("账号已锁定，请联系管理员审核。");
        // 获取登录token
		String token = tokenService.generateToken(user.getId(), user.getSijizhanghao(),"siji", "司机");
                //返回token及登录账号
        return R.ok().put("token", token).put("username", user.getSijizhanghao());
    }


	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody SijiEntity siji){
    	//ValidatorUtils.validateEntity(siji);
        //根据登录账号获取用户信息判断是否存在该用户，否则返回错误信息
    	SijiEntity u = sijiService.getOne(new QueryWrapper<SijiEntity>().eq("sijizhanghao", siji.getSijizhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
        //判断是否存在相同司机账号，否则返回错误信息
        if(sijiService.count(new QueryWrapper<SijiEntity>().eq("sijizhanghao", siji.getSijizhanghao()))>0) {
            return R.error("司机账号已存在");
        }
		Long uId = new Date().getTime();
		siji.setId(uId);
        //设置登录密码md5方式加密
        siji.setMima(EncryptUtil.md5(siji.getMima()));
        //保存用户
        sijiService.save(siji);
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
        SijiEntity u = sijiService.getById(id);
        return R.ok().put("data", u);
    }

    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	//根据登录账号判断是否存在用户信息，否则返回错误信息
        SijiEntity u = sijiService.getOne(new QueryWrapper<SijiEntity>().eq("sijizhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        //重置密码为123456，并使用md5方式加密
        u.setMima(EncryptUtil.md5("123456"));
        sijiService.updateById(u);
        return R.ok("密码已重置为：123456");
    }

    /**
     * 获取账号列表
     */
    @RequestMapping("/accountList")
    public R getAccountList(@RequestParam Map<String, Object> params,SijiEntity siji){
        QueryWrapper<SijiEntity> ew = new QueryWrapper<SijiEntity>();
        QueryWrapper<SijiEntity> wrapper =MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, siji), params), params);
        List<Map> list = sijiService.list(wrapper).stream().map(v -> {
            Map<String, Object> map = new HashMap<>();
            map.put("id", v.getId());
            map.put("account", v.getSijizhanghao());
            return map;
        }).collect(Collectors.toList());
        return R.ok().put("data", list);
    }






    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,SijiEntity siji,
		HttpServletRequest request){
        //设置查询条件
        QueryWrapper<SijiEntity> ew = new QueryWrapper<SijiEntity>();


        //查询结果
		PageUtils page = sijiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, siji), params), params));
        Map<String, String> deSens = new HashMap<>();
        deSens.put("sijixingming","名");
        deSens.put("shoujihao","手");
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }


    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,SijiEntity siji,
                @RequestParam(required = false) Double yuestart,
                @RequestParam(required = false) Double yueend,
                @RequestParam(required = false) Double statusstart,
                @RequestParam(required = false) Double statusend,
		HttpServletRequest request){
        //设置查询条件
        QueryWrapper<SijiEntity> ew = new QueryWrapper<SijiEntity>();
        if(yuestart!=null) ew.ge("yue", yuestart);
        if(yueend!=null) ew.le("yue", yueend);
        if(statusstart!=null) ew.ge("status", statusstart);
        if(statusend!=null) ew.le("status", statusend);

        //查询结果
		PageUtils page = sijiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, siji), params), params));
        Map<String, String> deSens = new HashMap<>();
        deSens.put("sijixingming","名");
        deSens.put("shoujihao","手");
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( SijiEntity siji){
       	QueryWrapper<SijiEntity> ew = new QueryWrapper<SijiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( siji, "siji"));
        return R.ok().put("data", sijiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(SijiEntity siji){
        QueryWrapper< SijiEntity> ew = new QueryWrapper< SijiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( siji, "siji"));
		SijiView sijiView =  sijiService.selectView(ew);
		return R.ok("查询司机成功").put("data", sijiView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        SijiEntity siji = sijiService.getById(id);
        Map<String, String> deSens = new HashMap<>();
        deSens.put("sijixingming","名");
        deSens.put("shoujihao","手");
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(siji,deSens);
        return R.ok().put("data", siji);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        SijiEntity siji = sijiService.getById(id);
        Map<String, String> deSens = new HashMap<>();
        deSens.put("sijixingming","名");
        deSens.put("shoujihao","手");
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(siji,deSens);
        return R.ok().put("data", siji);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增司机")
    public R save(@RequestBody SijiEntity siji, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(sijiService.count(new QueryWrapper<SijiEntity>().eq("sijizhanghao", siji.getSijizhanghao()))>0) {
            return R.error("司机账号已存在");
        }
        //ValidatorUtils.validateEntity(siji);
        //验证账号唯一性，否则返回错误信息
        SijiEntity u = sijiService.getOne(new QueryWrapper<SijiEntity>().eq("sijizhanghao", siji.getSijizhanghao()));
        if(u!=null) {
            return R.error("用户已存在");
        }
    	siji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
		siji.setId(new Date().getTime());
        //密码使用md5方式加密
        siji.setMima(EncryptUtil.md5(siji.getMima()));
        sijiService.save(siji);
        return R.ok().put("data",siji.getId());
    }

    /**
     * 前台保存
     */
    @SysLog("新增司机")
    @RequestMapping("/add")
    public R add(@RequestBody SijiEntity siji, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(sijiService.count(new QueryWrapper<SijiEntity>().eq("sijizhanghao", siji.getSijizhanghao()))>0) {
            return R.error("司机账号已存在");
        }
        //ValidatorUtils.validateEntity(siji);
        //验证账号唯一性，否则返回错误信息
        SijiEntity u = sijiService.getOne(new QueryWrapper<SijiEntity>().eq("sijizhanghao", siji.getSijizhanghao()));
        if(u!=null) {
            return R.error("用户已存在");
        }
    	siji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
		siji.setId(new Date().getTime());
        //密码使用md5方式加密
        siji.setMima(EncryptUtil.md5(siji.getMima()));
        sijiService.save(siji);
        return R.ok().put("data",siji.getId());
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        SijiEntity siji = sijiService.getOne(new QueryWrapper<SijiEntity>().eq("sijizhanghao", username));
        return R.ok().put("data", siji);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody SijiEntity siji, HttpServletRequest request){
        //ValidatorUtils.validateEntity(siji);
        //验证字段唯一性，否则返回错误信息
        if(sijiService.count(new QueryWrapper<SijiEntity>().ne("id", siji.getId()).eq("sijizhanghao", siji.getSijizhanghao()))>0) {
            return R.error("司机账号已存在");
        }
	    SijiEntity sijiEntity = sijiService.getById(siji.getId());
        //如果密码不为空，则判断是否和输入密码一致，不一致则重新设置
        if(StringUtils.isNotBlank(siji.getMima()) && !siji.getMima().equals(sijiEntity.getMima())) {
            //密码使用md5方式加密
            siji.setMima(EncryptUtil.md5(siji.getMima()));
        }
        //全部更新
        sijiService.updateById(siji);
        if(null!=siji.getSijizhanghao())
        {
            // 修改token
            TokenEntity tokenEntity = new TokenEntity();
            tokenEntity.setUsername(siji.getSijizhanghao());
            tokenService.update(tokenEntity, new UpdateWrapper<TokenEntity>().eq("userid", siji.getId()));
        }
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    @SysLog("审核司机")
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<SijiEntity> list = new ArrayList<SijiEntity>();
        for(Long id : ids) {
            SijiEntity siji = sijiService.getById(id);
            siji.setSfsh(sfsh);
            siji.setShhf(shhf);
            list.add(siji);
        }
        sijiService.updateBatchById(list);
        return R.ok();
    }




    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除司机")
    public R delete(@RequestBody Long[] ids){
        sijiService.removeBatchByIds(Arrays.asList(ids));
        return R.ok();
    }





    // hasAlipay:否


    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @RequestParam(required = false) String conditionColumn, @RequestParam(required = false) String conditionValue, @RequestParam(required = false, defaultValue = "总和") String func, HttpServletRequest request) throws IOException {
        //读取文件，如果文件存在，则优先返回文件内容
        java.nio.file.Path path = java.nio.file.Paths.get("value_siji_" + xColumnName + "_" + yColumnName + "_timeType.json");
        if(java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }
        //构建查询统计条件
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("method", func);
        QueryWrapper<SijiEntity> ew = new QueryWrapper<SijiEntity>();
        String order = request.getParameter("order");
        if (StringUtils.isNotBlank(order)) {
            String orderType = request.getParameter("orderType");
            if (null != orderType) {
                if (order.equals("asc")) {
                    ew.orderByAsc(orderType.equals("x") ? xColumnName : yColumnName);
                } else {
                    ew.orderByDesc(orderType.equals("x") ? xColumnName :yColumnName);
                }
            }
        }
        if(StringUtils.isNotBlank(conditionColumn)&&StringUtils.isNotBlank(conditionValue))
        {
            String[] conditionColumns = conditionColumn.split(";");
            String[] conditionValues = conditionValue.split(";");

            for (int i = 0; i < conditionColumns.length; i++) {
                String column = conditionColumns[i];
                String value = conditionValues[i];

                // 处理范围查询：如果列名包含逗号，表示是范围查询
                if (column.contains(",")) {
                    String[] rangeColumns = column.split(",");
                    String[] rangeValues = value.split(",");

                    if (rangeColumns.length == 2 && rangeValues.length == 2) {
                        // 第一个列名使用 >= 条件
                        ew.ge(rangeColumns[0], rangeValues[0]);
                        // 第二个列名使用 <= 条件
                        ew.le(rangeColumns[1], rangeValues[1]);
                    }
                } else {
                    // 普通等值查询
                    ew.eq(column, value);
                }
            }
        }

        //获取结果
        List<Map<String, Object>> result = sijiService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul, @RequestParam(required = false) String conditionColumn, @RequestParam(required = false) String conditionValue, HttpServletRequest request)  throws IOException {
        //读取文件，如果文件存在，则优先返回文件内容
        java.nio.file.Path path = java.nio.file.Paths.get("value_siji_" + xColumnName + "_" + String.join("_", yColumnNameMul.split(",")) + "_timeType.json");
        if(java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        //构建查询统计条件
        QueryWrapper<SijiEntity> ew = new QueryWrapper<SijiEntity>();
        String order = request.getParameter("order");
        if (StringUtils.isNotBlank(order)) {
            String orderType = request.getParameter("orderType");
            if (null != orderType) {
                if (order.equals("asc")) {
                    ew.orderByAsc(orderType.equals("x") ? Arrays.asList(xColumnName) : Arrays.asList(yColumnNames));
                } else {
                    ew.orderByDesc(orderType.equals("x") ? Arrays.asList(xColumnName) : Arrays.asList(yColumnNames));
                }
            }
        }
        if(StringUtils.isNotBlank(conditionColumn)&&StringUtils.isNotBlank(conditionValue))
        {
            String[] conditionColumns = conditionColumn.split(";");
            String[] conditionValues = conditionValue.split(";");

            for (int i = 0; i < conditionColumns.length; i++) {
                String column = conditionColumns[i];
                String value = conditionValues[i];

                // 处理范围查询：如果列名包含逗号，表示是范围查询
                if (column.contains(",")) {
                    String[] rangeColumns = column.split(",");
                    String[] rangeValues = value.split(",");

                    if (rangeColumns.length == 2 && rangeValues.length == 2) {
                        // 第一个列名使用 >= 条件
                        ew.ge(rangeColumns[0], rangeValues[0]);
                        // 第二个列名使用 <= 条件
                        ew.le(rangeColumns[1], rangeValues[1]);
                    }
                } else {
                    // 普通等值查询
                    ew.eq(column, value);
                }
            }
        }
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = sijiService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType, @RequestParam(required = false) String conditionColumn, @RequestParam(required = false) String conditionValue, @RequestParam(required = false, defaultValue = "总和") String func, HttpServletRequest request) throws IOException {
        //读取文件，如果文件存在，则优先返回文件内容
        java.nio.file.Path path = java.nio.file.Paths.get("value_siji_" + xColumnName + "_" + yColumnName + "_"+timeStatType+".json");
        if(java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        params.put("method", func);
        //构建查询统计条件
        QueryWrapper<SijiEntity> ew = new QueryWrapper<SijiEntity>();
        String order = request.getParameter("order");
        if (StringUtils.isNotBlank(order)) {
            String orderType = request.getParameter("orderType");
            if (null != orderType) {
                if (order.equals("asc")) {
                    ew.orderByAsc(orderType.equals("x") ? xColumnName : yColumnName);
                } else {
                    ew.orderByDesc(orderType.equals("x") ? xColumnName :yColumnName);
                }
            }
        }
        if(StringUtils.isNotBlank(conditionColumn)&&StringUtils.isNotBlank(conditionValue))
        {
            String[] conditionColumns = conditionColumn.split(";");
            String[] conditionValues = conditionValue.split(";");

            for (int i = 0; i < conditionColumns.length; i++) {
                String column = conditionColumns[i];
                String value = conditionValues[i];

                // 处理范围查询：如果列名包含逗号，表示是范围查询
                if (column.contains(",")) {
                    String[] rangeColumns = column.split(",");
                    String[] rangeValues = value.split(",");

                    if (rangeColumns.length == 2 && rangeValues.length == 2) {
                        // 第一个列名使用 >= 条件
                        ew.ge(rangeColumns[0], rangeValues[0]);
                        // 第二个列名使用 <= 条件
                        ew.le(rangeColumns[1], rangeValues[1]);
                    }
                } else {
                    // 普通等值查询
                    ew.eq(column, value);
                }
            }
        }
        List<Map<String, Object>> result = sijiService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType, @RequestParam String yColumnNameMul, @RequestParam(required = false) String conditionColumn, @RequestParam(required = false) String conditionValue, HttpServletRequest request) throws IOException
    {
        //读取文件，如果文件存在，则优先返回文件内容
        java.nio.file.Path path = java.nio.file.Paths.get("value_siji_" + xColumnName + "_" + String.join("_", yColumnNameMul.split(",")) + ".json");
        if (java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("timeStatType", timeStatType);
        //构建查询统计条件
        QueryWrapper<SijiEntity> ew = new QueryWrapper<SijiEntity>();
        String order = request.getParameter("order");
        if (StringUtils.isNotBlank(order)) {
            String orderType = request.getParameter("orderType");
            if (null != orderType) {
                if (order.equals("asc")) {
                    ew.orderByAsc(orderType.equals("x") ? Arrays.asList(xColumnName) : Arrays.asList(yColumnNames));
                } else {
                    ew.orderByDesc(orderType.equals("x") ? Arrays.asList(xColumnName) : Arrays.asList(yColumnNames));
                }
            }
        }
        if(StringUtils.isNotBlank(conditionColumn)&&StringUtils.isNotBlank(conditionValue))
        {
            String[] conditionColumns = conditionColumn.split(";");
            String[] conditionValues = conditionValue.split(";");

            for (int i = 0; i < conditionColumns.length; i++) {
                String column = conditionColumns[i];
                String value = conditionValues[i];

                // 处理范围查询：如果列名包含逗号，表示是范围查询
                if (column.contains(",")) {
                    String[] rangeColumns = column.split(",");
                    String[] rangeValues = value.split(",");

                    if (rangeColumns.length == 2 && rangeValues.length == 2) {
                        // 第一个列名使用 >= 条件
                        ew.ge(rangeColumns[0], rangeValues[0]);
                        // 第二个列名使用 <= 条件
                        ew.le(rangeColumns[1], rangeValues[1]);
                    }
                } else {
                    // 普通等值查询
                    ew.eq(column, value);
                }
            }
        }
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = sijiService.selectTimeStatValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName, @RequestParam(required = false) String conditionColumn, @RequestParam(required = false) String conditionValue, HttpServletRequest request) throws IOException {
        //读取文件，如果文件存在，则优先返回文件内容
        java.nio.file.Path path = java.nio.file.Paths.get("group_siji_" + columnName + "_timeType.json");
        if(java.nio.file.Files.exists(path)){
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        //构建查询统计条件
        QueryWrapper<SijiEntity> ew = new QueryWrapper<SijiEntity>();
        if(StringUtils.isNotBlank(conditionColumn)&&StringUtils.isNotBlank(conditionValue))
        {
            String[] conditionColumns = conditionColumn.split(";");
            String[] conditionValues = conditionValue.split(";");

            for (int i = 0; i < conditionColumns.length; i++) {
                String column = conditionColumns[i];
                String value = conditionValues[i];

                // 处理范围查询：如果列名包含逗号，表示是范围查询
                if (column.contains(",")) {
                    String[] rangeColumns = column.split(",");
                    String[] rangeValues = value.split(",");

                    if (rangeColumns.length == 2 && rangeValues.length == 2) {
                        // 第一个列名使用 >= 条件
                        ew.ge(rangeColumns[0], rangeValues[0]);
                        // 第二个列名使用 <= 条件
                        ew.le(rangeColumns[1], rangeValues[1]);
                    }
                } else {
                    // 普通等值查询
                    ew.eq(column, value);
                }
            }
        }
        List<Map<String, Object>> result = sijiService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }




    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,SijiEntity siji, HttpServletRequest request){
        QueryWrapper<SijiEntity> ew = new QueryWrapper<SijiEntity>();
        long count = sijiService.count(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, siji), params), params));
        return R.ok().put("data", count);
    }

}
