package com.yb.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yb.utils.PageUtils;
import com.yb.utils.Query;


import com.yb.dao.ChexingDao;
import com.yb.entity.ChexingEntity;
import com.yb.service.ChexingService;
import com.yb.entity.vo.ChexingVO;
import com.yb.entity.view.ChexingView;

@Service("chexingService")
public class ChexingServiceImpl extends ServiceImpl<ChexingDao, ChexingEntity> implements ChexingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChexingEntity> page = baseMapper.selectPage(new Query<ChexingEntity>(params).getPage(),new QueryWrapper<ChexingEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<ChexingEntity> wrapper) {
        Page<ChexingEntity> page = baseMapper.selectPage(new Query<ChexingEntity>(params).getPage(),wrapper);
        Page<ChexingView> pageVo = (Page<ChexingView>)page.convert(ChexingView::new);
        return new PageUtils(pageVo);
 	}

    
    @Override
	public List<ChexingVO> selectListVO(QueryWrapper<ChexingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChexingVO selectVO(QueryWrapper<ChexingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChexingView> selectListView(QueryWrapper<ChexingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChexingView selectView(QueryWrapper<ChexingEntity> wrapper) {
        ChexingEntity entity = baseMapper.selectOne(wrapper);
        if (null != entity) {
            return new ChexingView(entity);
        } else {
            return null;
        }
	}


}
