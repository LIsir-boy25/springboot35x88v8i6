package com.yb.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yb.utils.PageUtils;
import com.yb.utils.Query;


import com.yb.dao.DaodazhuanghuodiDao;
import com.yb.entity.DaodazhuanghuodiEntity;
import com.yb.service.DaodazhuanghuodiService;
import com.yb.entity.vo.DaodazhuanghuodiVO;
import com.yb.entity.view.DaodazhuanghuodiView;

@Service("daodazhuanghuodiService")
public class DaodazhuanghuodiServiceImpl extends ServiceImpl<DaodazhuanghuodiDao, DaodazhuanghuodiEntity> implements DaodazhuanghuodiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DaodazhuanghuodiEntity> page = baseMapper.selectPage(new Query<DaodazhuanghuodiEntity>(params).getPage(),new QueryWrapper<DaodazhuanghuodiEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<DaodazhuanghuodiEntity> wrapper) {
        Page<DaodazhuanghuodiEntity> page = baseMapper.selectPage(new Query<DaodazhuanghuodiEntity>(params).getPage(),wrapper);
        Page<DaodazhuanghuodiView> pageVo = (Page<DaodazhuanghuodiView>)page.convert(DaodazhuanghuodiView::new);
        return new PageUtils(pageVo);
 	}

    
    @Override
	public List<DaodazhuanghuodiVO> selectListVO(QueryWrapper<DaodazhuanghuodiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DaodazhuanghuodiVO selectVO(QueryWrapper<DaodazhuanghuodiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DaodazhuanghuodiView> selectListView(QueryWrapper<DaodazhuanghuodiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DaodazhuanghuodiView selectView(QueryWrapper<DaodazhuanghuodiEntity> wrapper) {
        DaodazhuanghuodiEntity entity = baseMapper.selectOne(wrapper);
        if (null != entity) {
            return new DaodazhuanghuodiView(entity);
        } else {
            return null;
        }
	}


}
