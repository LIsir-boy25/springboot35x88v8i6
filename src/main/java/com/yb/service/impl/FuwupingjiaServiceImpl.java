package com.yb.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yb.utils.PageUtils;
import com.yb.utils.Query;


import com.yb.dao.FuwupingjiaDao;
import com.yb.entity.FuwupingjiaEntity;
import com.yb.service.FuwupingjiaService;
import com.yb.entity.vo.FuwupingjiaVO;
import com.yb.entity.view.FuwupingjiaView;

@Service("fuwupingjiaService")
public class FuwupingjiaServiceImpl extends ServiceImpl<FuwupingjiaDao, FuwupingjiaEntity> implements FuwupingjiaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FuwupingjiaEntity> page = baseMapper.selectPage(new Query<FuwupingjiaEntity>(params).getPage(),new QueryWrapper<FuwupingjiaEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<FuwupingjiaEntity> wrapper) {
        Page<FuwupingjiaEntity> page = baseMapper.selectPage(new Query<FuwupingjiaEntity>(params).getPage(),wrapper);
        Page<FuwupingjiaView> pageVo = (Page<FuwupingjiaView>)page.convert(FuwupingjiaView::new);
        return new PageUtils(pageVo);
 	}

    
    @Override
	public List<FuwupingjiaVO> selectListVO(QueryWrapper<FuwupingjiaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public FuwupingjiaVO selectVO(QueryWrapper<FuwupingjiaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<FuwupingjiaView> selectListView(QueryWrapper<FuwupingjiaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FuwupingjiaView selectView(QueryWrapper<FuwupingjiaEntity> wrapper) {
        FuwupingjiaEntity entity = baseMapper.selectOne(wrapper);
        if (null != entity) {
            return new FuwupingjiaView(entity);
        } else {
            return null;
        }
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, QueryWrapper<FuwupingjiaEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, QueryWrapper<FuwupingjiaEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, QueryWrapper<FuwupingjiaEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
