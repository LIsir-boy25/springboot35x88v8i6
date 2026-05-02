package com.yb.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yb.utils.PageUtils;
import com.yb.utils.Query;


import com.yb.dao.SensitivewordsDao;
import com.yb.entity.SensitivewordsEntity;
import com.yb.service.SensitivewordsService;
import com.yb.entity.vo.SensitivewordsVO;
import com.yb.entity.view.SensitivewordsView;

@Service("sensitivewordsService")
public class SensitivewordsServiceImpl extends ServiceImpl<SensitivewordsDao, SensitivewordsEntity> implements SensitivewordsService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SensitivewordsEntity> page = baseMapper.selectPage(new Query<SensitivewordsEntity>(params).getPage(),new QueryWrapper<SensitivewordsEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<SensitivewordsEntity> wrapper) {
        Page<SensitivewordsEntity> page = baseMapper.selectPage(new Query<SensitivewordsEntity>(params).getPage(),wrapper);
        Page<SensitivewordsView> pageVo = (Page<SensitivewordsView>)page.convert(SensitivewordsView::new);
        return new PageUtils(pageVo);
 	}

    
    @Override
	public List<SensitivewordsVO> selectListVO(QueryWrapper<SensitivewordsEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public SensitivewordsVO selectVO(QueryWrapper<SensitivewordsEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<SensitivewordsView> selectListView(QueryWrapper<SensitivewordsEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public SensitivewordsView selectView(QueryWrapper<SensitivewordsEntity> wrapper) {
        SensitivewordsEntity entity = baseMapper.selectOne(wrapper);
        if (null != entity) {
            return new SensitivewordsView(entity);
        } else {
            return null;
        }
	}


}
