package com.yb.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yb.utils.PageUtils;
import com.yb.utils.Query;


import com.yb.dao.ChufaxinxiDao;
import com.yb.entity.ChufaxinxiEntity;
import com.yb.service.ChufaxinxiService;
import com.yb.entity.vo.ChufaxinxiVO;
import com.yb.entity.view.ChufaxinxiView;

@Service("chufaxinxiService")
public class ChufaxinxiServiceImpl extends ServiceImpl<ChufaxinxiDao, ChufaxinxiEntity> implements ChufaxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChufaxinxiEntity> page = baseMapper.selectPage(new Query<ChufaxinxiEntity>(params).getPage(),new QueryWrapper<ChufaxinxiEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<ChufaxinxiEntity> wrapper) {
        Page<ChufaxinxiEntity> page = baseMapper.selectPage(new Query<ChufaxinxiEntity>(params).getPage(),wrapper);
        Page<ChufaxinxiView> pageVo = (Page<ChufaxinxiView>)page.convert(ChufaxinxiView::new);
        return new PageUtils(pageVo);
 	}

    
    @Override
	public List<ChufaxinxiVO> selectListVO(QueryWrapper<ChufaxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChufaxinxiVO selectVO(QueryWrapper<ChufaxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChufaxinxiView> selectListView(QueryWrapper<ChufaxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChufaxinxiView selectView(QueryWrapper<ChufaxinxiEntity> wrapper) {
        ChufaxinxiEntity entity = baseMapper.selectOne(wrapper);
        if (null != entity) {
            return new ChufaxinxiView(entity);
        } else {
            return null;
        }
	}


}
