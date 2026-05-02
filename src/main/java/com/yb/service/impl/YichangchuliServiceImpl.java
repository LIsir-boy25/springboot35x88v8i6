package com.yb.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yb.utils.PageUtils;
import com.yb.utils.Query;


import com.yb.dao.YichangchuliDao;
import com.yb.entity.YichangchuliEntity;
import com.yb.service.YichangchuliService;
import com.yb.entity.vo.YichangchuliVO;
import com.yb.entity.view.YichangchuliView;

@Service("yichangchuliService")
public class YichangchuliServiceImpl extends ServiceImpl<YichangchuliDao, YichangchuliEntity> implements YichangchuliService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YichangchuliEntity> page = baseMapper.selectPage(new Query<YichangchuliEntity>(params).getPage(),new QueryWrapper<YichangchuliEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<YichangchuliEntity> wrapper) {
        Page<YichangchuliEntity> page = baseMapper.selectPage(new Query<YichangchuliEntity>(params).getPage(),wrapper);
        Page<YichangchuliView> pageVo = (Page<YichangchuliView>)page.convert(YichangchuliView::new);
        return new PageUtils(pageVo);
 	}

    
    @Override
	public List<YichangchuliVO> selectListVO(QueryWrapper<YichangchuliEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YichangchuliVO selectVO(QueryWrapper<YichangchuliEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YichangchuliView> selectListView(QueryWrapper<YichangchuliEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YichangchuliView selectView(QueryWrapper<YichangchuliEntity> wrapper) {
        YichangchuliEntity entity = baseMapper.selectOne(wrapper);
        if (null != entity) {
            return new YichangchuliView(entity);
        } else {
            return null;
        }
	}


}
