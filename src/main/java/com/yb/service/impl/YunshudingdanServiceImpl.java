package com.yb.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yb.utils.PageUtils;
import com.yb.utils.Query;


import com.yb.dao.YunshudingdanDao;
import com.yb.entity.YunshudingdanEntity;
import com.yb.service.YunshudingdanService;
import com.yb.entity.vo.YunshudingdanVO;
import com.yb.entity.view.YunshudingdanView;

@Service("yunshudingdanService")
public class YunshudingdanServiceImpl extends ServiceImpl<YunshudingdanDao, YunshudingdanEntity> implements YunshudingdanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YunshudingdanEntity> page = baseMapper.selectPage(new Query<YunshudingdanEntity>(params).getPage(),new QueryWrapper<YunshudingdanEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<YunshudingdanEntity> wrapper) {
        Page<YunshudingdanEntity> page = baseMapper.selectPage(new Query<YunshudingdanEntity>(params).getPage(),wrapper);
        Page<YunshudingdanView> pageVo = (Page<YunshudingdanView>)page.convert(YunshudingdanView::new);
        return new PageUtils(pageVo);
 	}

    
    @Override
	public List<YunshudingdanVO> selectListVO(QueryWrapper<YunshudingdanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YunshudingdanVO selectVO(QueryWrapper<YunshudingdanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YunshudingdanView> selectListView(QueryWrapper<YunshudingdanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YunshudingdanView selectView(QueryWrapper<YunshudingdanEntity> wrapper) {
        YunshudingdanEntity entity = baseMapper.selectOne(wrapper);
        if (null != entity) {
            return new YunshudingdanView(entity);
        } else {
            return null;
        }
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, QueryWrapper<YunshudingdanEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, QueryWrapper<YunshudingdanEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, QueryWrapper<YunshudingdanEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
