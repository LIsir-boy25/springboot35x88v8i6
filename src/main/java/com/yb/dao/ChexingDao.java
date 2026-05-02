package com.yb.dao;

import com.yb.entity.ChexingEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.yb.entity.vo.ChexingVO;
import com.yb.entity.view.ChexingView;


/**
 * 车型
 * 
 * @author 
 * @email 
 * @date 2026-01-10 20:50:16
 */
public interface ChexingDao extends BaseMapper<ChexingEntity> {
	
	List<ChexingVO> selectListVO(@Param("ew") QueryWrapper<ChexingEntity> wrapper);
	
	ChexingVO selectVO(@Param("ew") QueryWrapper<ChexingEntity> wrapper);
	
	List<ChexingView> selectListView(@Param("ew") QueryWrapper<ChexingEntity> wrapper);

	List<ChexingView> selectListView(Page page,@Param("ew") QueryWrapper<ChexingEntity> wrapper);

	
	ChexingView selectView(@Param("ew") QueryWrapper<ChexingEntity> wrapper);
	

}
