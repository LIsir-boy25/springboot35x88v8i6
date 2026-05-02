package com.yb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yb.dao.YunshuguijiDao;
import com.yb.entity.YunshuguijiEntity;
import com.yb.service.YunshuguijiService;
import org.springframework.stereotype.Service;

@Service
// 注意：这里第一个泛型改成了YunshuguijiDao
public class YunshuguijiServiceImpl extends ServiceImpl<YunshuguijiDao, YunshuguijiEntity> implements YunshuguijiService {
}