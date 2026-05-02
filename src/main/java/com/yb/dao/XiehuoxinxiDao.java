package com.yb.dao;

import com.yb.entity.XiehuoxinxiEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.yb.entity.vo.XiehuoxinxiVO;
import com.yb.entity.view.XiehuoxinxiView;


/**
 * 卸货信息
 * 
 * @author 
 * @email 
 * @date 2026-01-10 20:50:17
 */
public interface XiehuoxinxiDao extends BaseMapper<XiehuoxinxiEntity> {
	
	List<XiehuoxinxiVO> selectListVO(@Param("ew") QueryWrapper<XiehuoxinxiEntity> wrapper);
	
	XiehuoxinxiVO selectVO(@Param("ew") QueryWrapper<XiehuoxinxiEntity> wrapper);
	
	List<XiehuoxinxiView> selectListView(@Param("ew") QueryWrapper<XiehuoxinxiEntity> wrapper);

	List<XiehuoxinxiView> selectListView(Page page,@Param("ew") QueryWrapper<XiehuoxinxiEntity> wrapper);

	
	XiehuoxinxiView selectView(@Param("ew") QueryWrapper<XiehuoxinxiEntity> wrapper);
	

}
