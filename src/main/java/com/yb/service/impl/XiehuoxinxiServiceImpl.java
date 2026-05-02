package com.yb.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yb.utils.PageUtils;
import com.yb.utils.Query;


import com.yb.dao.XiehuoxinxiDao;
import com.yb.entity.XiehuoxinxiEntity;
import com.yb.service.XiehuoxinxiService;
import com.yb.entity.vo.XiehuoxinxiVO;
import com.yb.entity.view.XiehuoxinxiView;

@Service("xiehuoxinxiService")
public class XiehuoxinxiServiceImpl extends ServiceImpl<XiehuoxinxiDao, XiehuoxinxiEntity> implements XiehuoxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XiehuoxinxiEntity> page = baseMapper.selectPage(new Query<XiehuoxinxiEntity>(params).getPage(),new QueryWrapper<XiehuoxinxiEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<XiehuoxinxiEntity> wrapper) {
        Page<XiehuoxinxiEntity> page = baseMapper.selectPage(new Query<XiehuoxinxiEntity>(params).getPage(),wrapper);
        Page<XiehuoxinxiView> pageVo = (Page<XiehuoxinxiView>)page.convert(XiehuoxinxiView::new);
        return new PageUtils(pageVo);
 	}

    
    @Override
	public List<XiehuoxinxiVO> selectListVO(QueryWrapper<XiehuoxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XiehuoxinxiVO selectVO(QueryWrapper<XiehuoxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XiehuoxinxiView> selectListView(QueryWrapper<XiehuoxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XiehuoxinxiView selectView(QueryWrapper<XiehuoxinxiEntity> wrapper) {
        XiehuoxinxiEntity entity = baseMapper.selectOne(wrapper);
        if (null != entity) {
            return new XiehuoxinxiView(entity);
        } else {
            return null;
        }
	}


}
