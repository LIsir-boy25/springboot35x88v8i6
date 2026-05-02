package com.yb.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yb.utils.PageUtils;
import com.yb.utils.Query;


import com.yb.dao.HuozhuDao;
import com.yb.entity.HuozhuEntity;
import com.yb.service.HuozhuService;
import com.yb.entity.vo.HuozhuVO;
import com.yb.entity.view.HuozhuView;

@Service("huozhuService")
public class HuozhuServiceImpl extends ServiceImpl<HuozhuDao, HuozhuEntity> implements HuozhuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HuozhuEntity> page = baseMapper.selectPage(new Query<HuozhuEntity>(params).getPage(),new QueryWrapper<HuozhuEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<HuozhuEntity> wrapper) {
        Page<HuozhuEntity> page = baseMapper.selectPage(new Query<HuozhuEntity>(params).getPage(),wrapper);
        Page<HuozhuView> pageVo = (Page<HuozhuView>)page.convert(HuozhuView::new);
        return new PageUtils(pageVo);
 	}

    
    @Override
	public List<HuozhuVO> selectListVO(QueryWrapper<HuozhuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public HuozhuVO selectVO(QueryWrapper<HuozhuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<HuozhuView> selectListView(QueryWrapper<HuozhuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HuozhuView selectView(QueryWrapper<HuozhuEntity> wrapper) {
        HuozhuEntity entity = baseMapper.selectOne(wrapper);
        if (null != entity) {
            return new HuozhuView(entity);
        } else {
            return null;
        }
	}


}
