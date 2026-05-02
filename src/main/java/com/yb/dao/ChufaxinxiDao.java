package com.yb.dao;

import com.yb.entity.ChufaxinxiEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.yb.entity.vo.ChufaxinxiVO;
import com.yb.entity.view.ChufaxinxiView;


/**
 * 出发信息
 * 
 * @author 
 * @email 
 * @date 2026-01-10 20:50:16
 */
public interface ChufaxinxiDao extends BaseMapper<ChufaxinxiEntity> {
	
	List<ChufaxinxiVO> selectListVO(@Param("ew") QueryWrapper<ChufaxinxiEntity> wrapper);
	
	ChufaxinxiVO selectVO(@Param("ew") QueryWrapper<ChufaxinxiEntity> wrapper);
	
	List<ChufaxinxiView> selectListView(@Param("ew") QueryWrapper<ChufaxinxiEntity> wrapper);

	List<ChufaxinxiView> selectListView(Page page,@Param("ew") QueryWrapper<ChufaxinxiEntity> wrapper);

	
	ChufaxinxiView selectView(@Param("ew") QueryWrapper<ChufaxinxiEntity> wrapper);
	

}
