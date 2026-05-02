package com.yb.dao;

import com.yb.entity.DaodazhuanghuodiEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.yb.entity.vo.DaodazhuanghuodiVO;
import com.yb.entity.view.DaodazhuanghuodiView;


/**
 * 到达装货地
 * 
 * @author 
 * @email 
 * @date 2026-01-10 20:50:17
 */
public interface DaodazhuanghuodiDao extends BaseMapper<DaodazhuanghuodiEntity> {
	
	List<DaodazhuanghuodiVO> selectListVO(@Param("ew") QueryWrapper<DaodazhuanghuodiEntity> wrapper);
	
	DaodazhuanghuodiVO selectVO(@Param("ew") QueryWrapper<DaodazhuanghuodiEntity> wrapper);
	
	List<DaodazhuanghuodiView> selectListView(@Param("ew") QueryWrapper<DaodazhuanghuodiEntity> wrapper);

	List<DaodazhuanghuodiView> selectListView(Page page,@Param("ew") QueryWrapper<DaodazhuanghuodiEntity> wrapper);

	
	DaodazhuanghuodiView selectView(@Param("ew") QueryWrapper<DaodazhuanghuodiEntity> wrapper);
	

}
