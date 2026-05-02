package com.yb.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yb.utils.PageUtils;
import com.yb.utils.Query;


import com.yb.dao.QuxiaodingdanDao;
import com.yb.entity.QuxiaodingdanEntity;
import com.yb.service.QuxiaodingdanService;
import com.yb.entity.vo.QuxiaodingdanVO;
import com.yb.entity.view.QuxiaodingdanView;

@Service("quxiaodingdanService")
public class QuxiaodingdanServiceImpl extends ServiceImpl<QuxiaodingdanDao, QuxiaodingdanEntity> implements QuxiaodingdanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QuxiaodingdanEntity> page = baseMapper.selectPage(new Query<QuxiaodingdanEntity>(params).getPage(),new QueryWrapper<QuxiaodingdanEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<QuxiaodingdanEntity> wrapper) {
        Page<QuxiaodingdanEntity> page = baseMapper.selectPage(new Query<QuxiaodingdanEntity>(params).getPage(),wrapper);
        Page<QuxiaodingdanView> pageVo = (Page<QuxiaodingdanView>)page.convert(QuxiaodingdanView::new);
        return new PageUtils(pageVo);
 	}

    
    @Override
	public List<QuxiaodingdanVO> selectListVO(QueryWrapper<QuxiaodingdanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public QuxiaodingdanVO selectVO(QueryWrapper<QuxiaodingdanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<QuxiaodingdanView> selectListView(QueryWrapper<QuxiaodingdanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QuxiaodingdanView selectView(QueryWrapper<QuxiaodingdanEntity> wrapper) {
        QuxiaodingdanEntity entity = baseMapper.selectOne(wrapper);
        if (null != entity) {
            return new QuxiaodingdanView(entity);
        } else {
            return null;
        }
	}


}
