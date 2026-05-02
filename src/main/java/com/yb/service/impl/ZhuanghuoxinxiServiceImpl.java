package com.yb.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yb.utils.PageUtils;
import com.yb.utils.Query;


import com.yb.dao.ZhuanghuoxinxiDao;
import com.yb.entity.ZhuanghuoxinxiEntity;
import com.yb.service.ZhuanghuoxinxiService;
import com.yb.entity.vo.ZhuanghuoxinxiVO;
import com.yb.entity.view.ZhuanghuoxinxiView;

@Service("zhuanghuoxinxiService")
public class ZhuanghuoxinxiServiceImpl extends ServiceImpl<ZhuanghuoxinxiDao, ZhuanghuoxinxiEntity> implements ZhuanghuoxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhuanghuoxinxiEntity> page = baseMapper.selectPage(new Query<ZhuanghuoxinxiEntity>(params).getPage(),new QueryWrapper<ZhuanghuoxinxiEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<ZhuanghuoxinxiEntity> wrapper) {
        Page<ZhuanghuoxinxiEntity> page = baseMapper.selectPage(new Query<ZhuanghuoxinxiEntity>(params).getPage(),wrapper);
        Page<ZhuanghuoxinxiView> pageVo = (Page<ZhuanghuoxinxiView>)page.convert(ZhuanghuoxinxiView::new);
        return new PageUtils(pageVo);
 	}

    
    @Override
	public List<ZhuanghuoxinxiVO> selectListVO(QueryWrapper<ZhuanghuoxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhuanghuoxinxiVO selectVO(QueryWrapper<ZhuanghuoxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhuanghuoxinxiView> selectListView(QueryWrapper<ZhuanghuoxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhuanghuoxinxiView selectView(QueryWrapper<ZhuanghuoxinxiEntity> wrapper) {
        ZhuanghuoxinxiEntity entity = baseMapper.selectOne(wrapper);
        if (null != entity) {
            return new ZhuanghuoxinxiView(entity);
        } else {
            return null;
        }
	}


}
