package com.yb.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yb.utils.PageUtils;
import com.yb.utils.Query;


import com.yb.dao.YunlixinxiDao;
import com.yb.entity.YunlixinxiEntity;
import com.yb.service.YunlixinxiService;
import com.yb.entity.vo.YunlixinxiVO;
import com.yb.entity.view.YunlixinxiView;

@Service("yunlixinxiService")
public class YunlixinxiServiceImpl extends ServiceImpl<YunlixinxiDao, YunlixinxiEntity> implements YunlixinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YunlixinxiEntity> page = baseMapper.selectPage(new Query<YunlixinxiEntity>(params).getPage(),new QueryWrapper<YunlixinxiEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<YunlixinxiEntity> wrapper) {
        Page<YunlixinxiEntity> page = baseMapper.selectPage(new Query<YunlixinxiEntity>(params).getPage(),wrapper);
        Page<YunlixinxiView> pageVo = (Page<YunlixinxiView>)page.convert(YunlixinxiView::new);
        return new PageUtils(pageVo);
 	}

    
    @Override
	public List<YunlixinxiVO> selectListVO(QueryWrapper<YunlixinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YunlixinxiVO selectVO(QueryWrapper<YunlixinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YunlixinxiView> selectListView(QueryWrapper<YunlixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YunlixinxiView selectView(QueryWrapper<YunlixinxiEntity> wrapper) {
        YunlixinxiEntity entity = baseMapper.selectOne(wrapper);
        if (null != entity) {
            return new YunlixinxiView(entity);
        } else {
            return null;
        }
	}


}
