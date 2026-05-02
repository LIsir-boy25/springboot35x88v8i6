package com.yb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yb.entity.YunlixinxiEntity;
import com.yb.entity.YunshudingdanEntity;
import com.yb.service.YunlixinxiService;
import com.yb.service.YunshudingdanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CapacityMatchService {

    @Autowired
    private YunlixinxiService yunlixinxiService;
    @Autowired
    private YunshudingdanService yunshudingdanService;

    public List<YunlixinxiEntity> match(Long orderId){
        YunshudingdanEntity order = yunshudingdanService.getById(orderId);
        if(order == null) return new ArrayList<>();

        // 硬条件匹配：车型+区域+空闲+载重
        QueryWrapper<YunlixinxiEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("chexing", order.getChexing());
        wrapper.eq("quyu", order.getQuyu());
        wrapper.eq("zhuangtai","空闲");
        wrapper.ge("zaizhong", order.getZhongliang());

        List<YunlixinxiEntity> list = yunlixinxiService.list(wrapper);
        return list;
    }
}