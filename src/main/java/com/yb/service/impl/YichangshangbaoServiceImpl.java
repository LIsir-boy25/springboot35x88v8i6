package com.yb.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yb.utils.PageUtils;
import com.yb.utils.Query;


import com.yb.dao.YichangshangbaoDao;
import com.yb.entity.YichangshangbaoEntity;
import com.yb.service.YichangshangbaoService;
import com.yb.entity.vo.YichangshangbaoVO;
import com.yb.entity.view.YichangshangbaoView;

@Service("yichangshangbaoService")
public class YichangshangbaoServiceImpl extends ServiceImpl<YichangshangbaoDao, YichangshangbaoEntity> implements YichangshangbaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YichangshangbaoEntity> page = baseMapper.selectPage(new Query<YichangshangbaoEntity>(params).getPage(),new QueryWrapper<YichangshangbaoEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<YichangshangbaoEntity> wrapper) {
        Page<YichangshangbaoEntity> page = baseMapper.selectPage(new Query<YichangshangbaoEntity>(params).getPage(),wrapper);
        Page<YichangshangbaoView> pageVo = (Page<YichangshangbaoView>)page.convert(YichangshangbaoView::new);
        return new PageUtils(pageVo);
 	}

    
    @Override
	public List<YichangshangbaoVO> selectListVO(QueryWrapper<YichangshangbaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YichangshangbaoVO selectVO(QueryWrapper<YichangshangbaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YichangshangbaoView> selectListView(QueryWrapper<YichangshangbaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YichangshangbaoView selectView(QueryWrapper<YichangshangbaoEntity> wrapper) {
        YichangshangbaoEntity entity = baseMapper.selectOne(wrapper);
        if (null != entity) {
            return new YichangshangbaoView(entity);
        } else {
            return null;
        }
	}


}
