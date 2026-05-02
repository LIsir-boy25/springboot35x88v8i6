package com.yb.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yb.utils.PageUtils;
import com.yb.utils.Query;


import com.yb.dao.QuyuDao;
import com.yb.entity.QuyuEntity;
import com.yb.service.QuyuService;
import com.yb.entity.vo.QuyuVO;
import com.yb.entity.view.QuyuView;

@Service("quyuService")
public class QuyuServiceImpl extends ServiceImpl<QuyuDao, QuyuEntity> implements QuyuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QuyuEntity> page = baseMapper.selectPage(new Query<QuyuEntity>(params).getPage(),new QueryWrapper<QuyuEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<QuyuEntity> wrapper) {
        Page<QuyuEntity> page = baseMapper.selectPage(new Query<QuyuEntity>(params).getPage(),wrapper);
        Page<QuyuView> pageVo = (Page<QuyuView>)page.convert(QuyuView::new);
        return new PageUtils(pageVo);
 	}

    
    @Override
	public List<QuyuVO> selectListVO(QueryWrapper<QuyuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public QuyuVO selectVO(QueryWrapper<QuyuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<QuyuView> selectListView(QueryWrapper<QuyuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QuyuView selectView(QueryWrapper<QuyuEntity> wrapper) {
        QuyuEntity entity = baseMapper.selectOne(wrapper);
        if (null != entity) {
            return new QuyuView(entity);
        } else {
            return null;
        }
	}


}
