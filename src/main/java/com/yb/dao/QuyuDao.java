package com.yb.dao;

import com.yb.entity.QuyuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.yb.entity.vo.QuyuVO;
import com.yb.entity.view.QuyuView;


/**
 * 区域
 * 
 * @author 
 * @email 
 * @date 2026-01-10 20:50:16
 */
public interface QuyuDao extends BaseMapper<QuyuEntity> {
	
	List<QuyuVO> selectListVO(@Param("ew") QueryWrapper<QuyuEntity> wrapper);
	
	QuyuVO selectVO(@Param("ew") QueryWrapper<QuyuEntity> wrapper);
	
	List<QuyuView> selectListView(@Param("ew") QueryWrapper<QuyuEntity> wrapper);

	List<QuyuView> selectListView(Page page,@Param("ew") QueryWrapper<QuyuEntity> wrapper);

	
	QuyuView selectView(@Param("ew") QueryWrapper<QuyuEntity> wrapper);
	

}
