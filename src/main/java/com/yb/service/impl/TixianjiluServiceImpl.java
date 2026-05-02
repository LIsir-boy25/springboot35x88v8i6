package com.yb.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yb.utils.PageUtils;
import com.yb.utils.Query;


import com.yb.dao.TixianjiluDao;
import com.yb.entity.TixianjiluEntity;
import com.yb.service.TixianjiluService;
import com.yb.entity.vo.TixianjiluVO;
import com.yb.entity.view.TixianjiluView;

@Service("tixianjiluService")
public class TixianjiluServiceImpl extends ServiceImpl<TixianjiluDao, TixianjiluEntity> implements TixianjiluService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TixianjiluEntity> page = baseMapper.selectPage(new Query<TixianjiluEntity>(params).getPage(),new QueryWrapper<TixianjiluEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<TixianjiluEntity> wrapper) {
        Page<TixianjiluEntity> page = baseMapper.selectPage(new Query<TixianjiluEntity>(params).getPage(),wrapper);
        Page<TixianjiluView> pageVo = (Page<TixianjiluView>)page.convert(TixianjiluView::new);
        return new PageUtils(pageVo);
 	}

    
    @Override
	public List<TixianjiluVO> selectListVO(QueryWrapper<TixianjiluEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public TixianjiluVO selectVO(QueryWrapper<TixianjiluEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<TixianjiluView> selectListView(QueryWrapper<TixianjiluEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TixianjiluView selectView(QueryWrapper<TixianjiluEntity> wrapper) {
        TixianjiluEntity entity = baseMapper.selectOne(wrapper);
        if (null != entity) {
            return new TixianjiluView(entity);
        } else {
            return null;
        }
	}


}
