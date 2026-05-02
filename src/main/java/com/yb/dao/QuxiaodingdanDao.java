package com.yb.dao;

import com.yb.entity.QuxiaodingdanEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.yb.entity.vo.QuxiaodingdanVO;
import com.yb.entity.view.QuxiaodingdanView;


/**
 * 取消订单
 * 
 * @author 
 * @email 
 * @date 2026-01-10 20:50:16
 */
public interface QuxiaodingdanDao extends BaseMapper<QuxiaodingdanEntity> {
	
	List<QuxiaodingdanVO> selectListVO(@Param("ew") QueryWrapper<QuxiaodingdanEntity> wrapper);
	
	QuxiaodingdanVO selectVO(@Param("ew") QueryWrapper<QuxiaodingdanEntity> wrapper);
	
	List<QuxiaodingdanView> selectListView(@Param("ew") QueryWrapper<QuxiaodingdanEntity> wrapper);

	List<QuxiaodingdanView> selectListView(Page page,@Param("ew") QueryWrapper<QuxiaodingdanEntity> wrapper);

	
	QuxiaodingdanView selectView(@Param("ew") QueryWrapper<QuxiaodingdanEntity> wrapper);
	

}
