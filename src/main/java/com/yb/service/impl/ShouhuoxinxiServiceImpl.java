package com.yb.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yb.utils.PageUtils;
import com.yb.utils.Query;


import com.yb.dao.ShouhuoxinxiDao;
import com.yb.entity.ShouhuoxinxiEntity;
import com.yb.service.ShouhuoxinxiService;
import com.yb.entity.vo.ShouhuoxinxiVO;
import com.yb.entity.view.ShouhuoxinxiView;

@Service("shouhuoxinxiService")
public class ShouhuoxinxiServiceImpl extends ServiceImpl<ShouhuoxinxiDao, ShouhuoxinxiEntity> implements ShouhuoxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShouhuoxinxiEntity> page = baseMapper.selectPage(new Query<ShouhuoxinxiEntity>(params).getPage(),new QueryWrapper<ShouhuoxinxiEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<ShouhuoxinxiEntity> wrapper) {
        Page<ShouhuoxinxiEntity> page = baseMapper.selectPage(new Query<ShouhuoxinxiEntity>(params).getPage(),wrapper);
        Page<ShouhuoxinxiView> pageVo = (Page<ShouhuoxinxiView>)page.convert(ShouhuoxinxiView::new);
        return new PageUtils(pageVo);
 	}

    
    @Override
	public List<ShouhuoxinxiVO> selectListVO(QueryWrapper<ShouhuoxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShouhuoxinxiVO selectVO(QueryWrapper<ShouhuoxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShouhuoxinxiView> selectListView(QueryWrapper<ShouhuoxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShouhuoxinxiView selectView(QueryWrapper<ShouhuoxinxiEntity> wrapper) {
        ShouhuoxinxiEntity entity = baseMapper.selectOne(wrapper);
        if (null != entity) {
            return new ShouhuoxinxiView(entity);
        } else {
            return null;
        }
	}


}
