package com.yb.controller;

import com.yb.entity.YunlixinxiEntity;
import com.yb.service.impl.CapacityMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/capacity")
public class CapacityMatchController {

    @Autowired
    private CapacityMatchService capacityMatchService;

    // 智能匹配运力 - 用Map包装
    @RequestMapping("/match")
    public Map<String, Object> match(@RequestParam Long orderId) {
        List<YunlixinxiEntity> list = capacityMatchService.match(orderId);

        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("msg", "匹配成功");
        result.put("data", list);

        return result;
    }
}