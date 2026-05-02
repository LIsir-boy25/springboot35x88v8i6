package com.yb.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yb.utils.PageUtils;
import com.yb.utils.Query;


import com.yb.dao.DiscussyunlixinxiDao;
import com.yb.entity.DiscussyunlixinxiEntity;
import com.yb.service.DiscussyunlixinxiService;
import com.yb.entity.vo.DiscussyunlixinxiVO;
import com.yb.entity.view.DiscussyunlixinxiView;

@Service("discussyunlixinxiService")
public class DiscussyunlixinxiServiceImpl extends ServiceImpl<DiscussyunlixinxiDao, DiscussyunlixinxiEntity> implements DiscussyunlixinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussyunlixinxiEntity> page = baseMapper.selectPage(new Query<DiscussyunlixinxiEntity>(params).getPage(),new QueryWrapper<DiscussyunlixinxiEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<DiscussyunlixinxiEntity> wrapper) {
        Page<DiscussyunlixinxiEntity> page = baseMapper.selectPage(new Query<DiscussyunlixinxiEntity>(params).getPage(),wrapper);
        Page<DiscussyunlixinxiView> pageVo = (Page<DiscussyunlixinxiView>)page.convert(DiscussyunlixinxiView::new);
        return new PageUtils(pageVo);
 	}

    
    @Override
	public List<DiscussyunlixinxiVO> selectListVO(QueryWrapper<DiscussyunlixinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussyunlixinxiVO selectVO(QueryWrapper<DiscussyunlixinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussyunlixinxiView> selectListView(QueryWrapper<DiscussyunlixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussyunlixinxiView selectView(QueryWrapper<DiscussyunlixinxiEntity> wrapper) {
        DiscussyunlixinxiEntity entity = baseMapper.selectOne(wrapper);
        if (null != entity) {
            return new DiscussyunlixinxiView(entity);
        } else {
            return null;
        }
	}


}
