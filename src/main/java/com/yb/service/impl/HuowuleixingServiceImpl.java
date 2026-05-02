package com.yb.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yb.utils.PageUtils;
import com.yb.utils.Query;


import com.yb.dao.HuowuleixingDao;
import com.yb.entity.HuowuleixingEntity;
import com.yb.service.HuowuleixingService;
import com.yb.entity.vo.HuowuleixingVO;
import com.yb.entity.view.HuowuleixingView;

@Service("huowuleixingService")
public class HuowuleixingServiceImpl extends ServiceImpl<HuowuleixingDao, HuowuleixingEntity> implements HuowuleixingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HuowuleixingEntity> page = baseMapper.selectPage(new Query<HuowuleixingEntity>(params).getPage(),new QueryWrapper<HuowuleixingEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<HuowuleixingEntity> wrapper) {
        Page<HuowuleixingEntity> page = baseMapper.selectPage(new Query<HuowuleixingEntity>(params).getPage(),wrapper);
        Page<HuowuleixingView> pageVo = (Page<HuowuleixingView>)page.convert(HuowuleixingView::new);
        return new PageUtils(pageVo);
 	}

    
    @Override
	public List<HuowuleixingVO> selectListVO(QueryWrapper<HuowuleixingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public HuowuleixingVO selectVO(QueryWrapper<HuowuleixingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<HuowuleixingView> selectListView(QueryWrapper<HuowuleixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HuowuleixingView selectView(QueryWrapper<HuowuleixingEntity> wrapper) {
        HuowuleixingEntity entity = baseMapper.selectOne(wrapper);
        if (null != entity) {
            return new HuowuleixingView(entity);
        } else {
            return null;
        }
	}


}
