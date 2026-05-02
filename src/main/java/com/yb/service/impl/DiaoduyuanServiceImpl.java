package com.yb.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yb.utils.PageUtils;
import com.yb.utils.Query;


import com.yb.dao.DiaoduyuanDao;
import com.yb.entity.DiaoduyuanEntity;
import com.yb.service.DiaoduyuanService;
import com.yb.entity.vo.DiaoduyuanVO;
import com.yb.entity.view.DiaoduyuanView;

@Service("diaoduyuanService")
public class DiaoduyuanServiceImpl extends ServiceImpl<DiaoduyuanDao, DiaoduyuanEntity> implements DiaoduyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiaoduyuanEntity> page = baseMapper.selectPage(new Query<DiaoduyuanEntity>(params).getPage(),new QueryWrapper<DiaoduyuanEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<DiaoduyuanEntity> wrapper) {
        Page<DiaoduyuanEntity> page = baseMapper.selectPage(new Query<DiaoduyuanEntity>(params).getPage(),wrapper);
        Page<DiaoduyuanView> pageVo = (Page<DiaoduyuanView>)page.convert(DiaoduyuanView::new);
        return new PageUtils(pageVo);
 	}

    
    @Override
	public List<DiaoduyuanVO> selectListVO(QueryWrapper<DiaoduyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiaoduyuanVO selectVO(QueryWrapper<DiaoduyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiaoduyuanView> selectListView(QueryWrapper<DiaoduyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiaoduyuanView selectView(QueryWrapper<DiaoduyuanEntity> wrapper) {
        DiaoduyuanEntity entity = baseMapper.selectOne(wrapper);
        if (null != entity) {
            return new DiaoduyuanView(entity);
        } else {
            return null;
        }
	}


}
