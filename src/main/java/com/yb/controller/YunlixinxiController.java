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
import com.yb.utils.UserBasedCollaborativeFiltering;

import com.yb.entity.YunlixinxiEntity;
import com.yb.entity.view.YunlixinxiView;

import com.yb.service.YunlixinxiService;
import com.yb.utils.PageUtils;
import com.yb.utils.R;
import com.yb.utils.EncryptUtil;
import com.yb.utils.MPUtil;
import com.yb.utils.MapUtils;
import com.yb.utils.CommonUtil;
import java.io.IOException;
import com.yb.service.StoreupService;
import com.yb.entity.StoreupEntity;

/**
 * 运力信息
 * 后端接口
 * @author 
 * @email 
 * @date 2026-01-10 20:50:16
 */
@RestController
@RequestMapping("/yunlixinxi")
public class YunlixinxiController {
    @Autowired
    private YunlixinxiService yunlixinxiService;

    @Autowired
    private StoreupService storeupService;









    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YunlixinxiEntity yunlixinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("siji")) {
			yunlixinxi.setSijizhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        QueryWrapper<YunlixinxiEntity> ew = new QueryWrapper<YunlixinxiEntity>();


        //查询结果
		PageUtils page = yunlixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yunlixinxi), params), params));
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
    public R list(@RequestParam Map<String, Object> params,YunlixinxiEntity yunlixinxi,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date clicktimestart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date clicktimeend,
                @RequestParam(required = false) Double discussnumstart,
                @RequestParam(required = false) Double discussnumend,
                @RequestParam(required = false) Double storeupnumstart,
                @RequestParam(required = false) Double storeupnumend,
		HttpServletRequest request){
        //设置查询条件
        QueryWrapper<YunlixinxiEntity> ew = new QueryWrapper<YunlixinxiEntity>();
        if(clicktimestart!=null) ew.ge("clicktime", clicktimestart);
        if(clicktimeend!=null) ew.le("clicktime", clicktimeend);
        if(discussnumstart!=null) ew.ge("discussnum", discussnumstart);
        if(discussnumend!=null) ew.le("discussnum", discussnumend);
        if(storeupnumstart!=null) ew.ge("storeupnum", storeupnumstart);
        if(storeupnumend!=null) ew.le("storeupnum", storeupnumend);

        //查询结果
		PageUtils page = yunlixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yunlixinxi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YunlixinxiEntity yunlixinxi){
       	QueryWrapper<YunlixinxiEntity> ew = new QueryWrapper<YunlixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yunlixinxi, "yunlixinxi"));
        return R.ok().put("data", yunlixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YunlixinxiEntity yunlixinxi){
        QueryWrapper< YunlixinxiEntity> ew = new QueryWrapper< YunlixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yunlixinxi, "yunlixinxi"));
		YunlixinxiView yunlixinxiView =  yunlixinxiService.selectView(ew);
		return R.ok("查询运力信息成功").put("data", yunlixinxiView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YunlixinxiEntity yunlixinxi = yunlixinxiService.getById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yunlixinxi,deSens);
        return R.ok().put("data", yunlixinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YunlixinxiEntity yunlixinxi = yunlixinxiService.getById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yunlixinxi,deSens);
        return R.ok().put("data", yunlixinxi);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增运力信息")
    public R save(@RequestBody YunlixinxiEntity yunlixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yunlixinxi);
        yunlixinxiService.save(yunlixinxi);
        return R.ok().put("data",yunlixinxi.getId());
    }

    /**
     * 前台保存
     */
    @SysLog("新增运力信息")
    @RequestMapping("/add")
    public R add(@RequestBody YunlixinxiEntity yunlixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yunlixinxi);
        yunlixinxiService.save(yunlixinxi);
        return R.ok().put("data",yunlixinxi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改运力信息")
    public R update(@RequestBody YunlixinxiEntity yunlixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yunlixinxi);
        //全部更新
        yunlixinxiService.updateById(yunlixinxi);
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除运力信息")
    public R delete(@RequestBody Long[] ids){
        yunlixinxiService.removeBatchByIds(Arrays.asList(ids));
        return R.ok();
    }

	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,YunlixinxiEntity yunlixinxi, HttpServletRequest request,String pre){
        QueryWrapper<YunlixinxiEntity> ew = new QueryWrapper<YunlixinxiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
        // 组装参数
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");

		PageUtils page = yunlixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yunlixinxi), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 协同算法（基于用户的协同算法：购买、收藏、关注）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,YunlixinxiEntity yunlixinxi, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        Integer limit = params.get("limit") == null ? 10 : Integer.parseInt(params.get("limit").toString());
        // 创建协同过滤对象
        UserBasedCollaborativeFiltering filter = new UserBasedCollaborativeFiltering();
        //用户行为数据
        List<UserBasedCollaborativeFiltering.UserBehavior> userBehaviors = new ArrayList<>();
        // 查询收藏/关注数据
        userBehaviors.addAll(storeupService.list(new QueryWrapper<StoreupEntity>().eq("type", 1 ).eq("tablename", "yunlixinxi")).stream().map(storeup -> {
            return new UserBasedCollaborativeFiltering.UserBehavior(storeup.getUserid().toString(), storeup.getRefid().toString());
        }).collect(Collectors.toList()));
        // 根据物品推荐用户
        List<String> recommendations = filter.recommendItems(userBehaviors, userId, limit, true );

        // 输出推荐结果
        System.out.println("Recommendations for " + userId + ":");
        for (String item : recommendations) {
            System.out.println(item);
        }

        QueryWrapper<YunlixinxiEntity> ew = new QueryWrapper<YunlixinxiEntity>();
        if(recommendations!=null && recommendations.size()>0 && recommendations.size()>0) {
            ew.in("id", recommendations);
            ew.last("order by FIELD(id, "+String.join(",", recommendations)+")");
        }
        // 根据协同结果查询结果并返回
        PageUtils page = yunlixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yunlixinxi), params), params));
        List<YunlixinxiEntity> pageList = (List<YunlixinxiEntity>)page.getList();
        if(recommendations!=null && recommendations.size()>0 && pageList.size()<limit) {
            int toAddNum = limit-pageList.size();
            ew = new QueryWrapper<YunlixinxiEntity>();
            ew.notIn("id", recommendations);
            ew.orderByAsc("id");
            ew.last("limit "+toAddNum);
            pageList.addAll(yunlixinxiService.list(ew));
        } else if(pageList.size()>limit) {
            pageList = pageList.subList(0, limit);
        }
        page.setList(pageList);

        return R.ok().put("data", page);
    }


    // hasAlipay:否




}
