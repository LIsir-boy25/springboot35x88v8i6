package com.yb.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yb.utils.PageUtils;
import com.yb.utils.Query;


import com.yb.dao.SijiDao;
import com.yb.entity.SijiEntity;
import com.yb.service.SijiService;
import com.yb.entity.vo.SijiVO;
import com.yb.entity.view.SijiView;

@Service("sijiService")
public class SijiServiceImpl extends ServiceImpl<SijiDao, SijiEntity> implements SijiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SijiEntity> page = baseMapper.selectPage(new Query<SijiEntity>(params).getPage(),new QueryWrapper<SijiEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<SijiEntity> wrapper) {
        Page<SijiEntity> page = baseMapper.selectPage(new Query<SijiEntity>(params).getPage(),wrapper);
        Page<SijiView> pageVo = (Page<SijiView>)page.convert(SijiView::new);
        return new PageUtils(pageVo);
 	}

    
    @Override
	public List<SijiVO> selectListVO(QueryWrapper<SijiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public SijiVO selectVO(QueryWrapper<SijiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<SijiView> selectListView(QueryWrapper<SijiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public SijiView selectView(QueryWrapper<SijiEntity> wrapper) {
        SijiEntity entity = baseMapper.selectOne(wrapper);
        if (null != entity) {
            return new SijiView(entity);
        } else {
            return null;
        }
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, QueryWrapper<SijiEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, QueryWrapper<SijiEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, QueryWrapper<SijiEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
