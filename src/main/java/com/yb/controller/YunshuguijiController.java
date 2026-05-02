package com.yb.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yb.entity.YunshuguijiEntity;
import com.yb.service.YunshuguijiService;
import com.yb.utils.R; // 关键：添加这一行导入
import com.yb.websocket.TrackWebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/yunshuguiji")
public class YunshuguijiController {

    @Autowired
    private YunshuguijiService yunshuguijiService;

    // 司机上传定位
    @RequestMapping("/upload")
    public R upload(@RequestBody YunshuguijiEntity entity){
        entity.setAddtime(new Date());
        entity.setShijian(new Date());
        yunshuguijiService.save(entity);

        // 推送实时位置
        JSONObject obj = new JSONObject();
        obj.put("jingdu", entity.getJingdu());
        obj.put("weidu", entity.getWeidu());
        obj.put("dizhi", entity.getDizhi());
        obj.put("shijian", entity.getShijian());
        TrackWebSocketServer.sendInfo(entity.getDingdanbianhao(), obj);
        return R.ok("上传成功");
    }

    // 查询轨迹历史
    @RequestMapping("/list")
    public R list(@RequestParam String dingdanbianhao){
        List<YunshuguijiEntity> list = yunshuguijiService.list(
                new QueryWrapper<YunshuguijiEntity>()
                        .eq("dingdanbianhao", dingdanbianhao)
                        .orderByAsc("shijian")
        );
        return R.ok().put("data",list);
    }
}