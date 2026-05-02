package com.yb.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yb.utils.PageUtils;
import com.yb.utils.Query;


import com.yb.dao.JiedanxinxiDao;
import com.yb.entity.JiedanxinxiEntity;
import com.yb.service.JiedanxinxiService;
import com.yb.entity.vo.JiedanxinxiVO;
import com.yb.entity.view.JiedanxinxiView;

@Service("jiedanxinxiService")
public class JiedanxinxiServiceImpl extends ServiceImpl<JiedanxinxiDao, JiedanxinxiEntity> implements JiedanxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiedanxinxiEntity> page = baseMapper.selectPage(new Query<JiedanxinxiEntity>(params).getPage(),new QueryWrapper<JiedanxinxiEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<JiedanxinxiEntity> wrapper) {
        Page<JiedanxinxiEntity> page = baseMapper.selectPage(new Query<JiedanxinxiEntity>(params).getPage(),wrapper);
        Page<JiedanxinxiView> pageVo = (Page<JiedanxinxiView>)page.convert(JiedanxinxiView::new);
        return new PageUtils(pageVo);
 	}

    
    @Override
	public List<JiedanxinxiVO> selectListVO(QueryWrapper<JiedanxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JiedanxinxiVO selectVO(QueryWrapper<JiedanxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JiedanxinxiView> selectListView(QueryWrapper<JiedanxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiedanxinxiView selectView(QueryWrapper<JiedanxinxiEntity> wrapper) {
        JiedanxinxiEntity entity = baseMapper.selectOne(wrapper);
        if (null != entity) {
            return new JiedanxinxiView(entity);
        } else {
            return null;
        }
	}


}
