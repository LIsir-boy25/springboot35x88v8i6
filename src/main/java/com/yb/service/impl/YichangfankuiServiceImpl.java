package com.yb.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yb.utils.PageUtils;
import com.yb.utils.Query;


import com.yb.dao.YichangfankuiDao;
import com.yb.entity.YichangfankuiEntity;
import com.yb.service.YichangfankuiService;
import com.yb.entity.vo.YichangfankuiVO;
import com.yb.entity.view.YichangfankuiView;

@Service("yichangfankuiService")
public class YichangfankuiServiceImpl extends ServiceImpl<YichangfankuiDao, YichangfankuiEntity> implements YichangfankuiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YichangfankuiEntity> page = baseMapper.selectPage(new Query<YichangfankuiEntity>(params).getPage(),new QueryWrapper<YichangfankuiEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<YichangfankuiEntity> wrapper) {
        Page<YichangfankuiEntity> page = baseMapper.selectPage(new Query<YichangfankuiEntity>(params).getPage(),wrapper);
        Page<YichangfankuiView> pageVo = (Page<YichangfankuiView>)page.convert(YichangfankuiView::new);
        return new PageUtils(pageVo);
 	}

    
    @Override
	public List<YichangfankuiVO> selectListVO(QueryWrapper<YichangfankuiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YichangfankuiVO selectVO(QueryWrapper<YichangfankuiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YichangfankuiView> selectListView(QueryWrapper<YichangfankuiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YichangfankuiView selectView(QueryWrapper<YichangfankuiEntity> wrapper) {
        YichangfankuiEntity entity = baseMapper.selectOne(wrapper);
        if (null != entity) {
            return new YichangfankuiView(entity);
        } else {
            return null;
        }
	}


}
