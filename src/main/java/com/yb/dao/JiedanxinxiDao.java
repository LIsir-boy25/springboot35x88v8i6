package com.yb.dao;

import com.yb.entity.JiedanxinxiEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.yb.entity.vo.JiedanxinxiVO;
import com.yb.entity.view.JiedanxinxiView;


/**
 * 接单信息
 * 
 * @author 
 * @email 
 * @date 2026-01-10 20:50:16
 */
public interface JiedanxinxiDao extends BaseMapper<JiedanxinxiEntity> {
	
	List<JiedanxinxiVO> selectListVO(@Param("ew") QueryWrapper<JiedanxinxiEntity> wrapper);
	
	JiedanxinxiVO selectVO(@Param("ew") QueryWrapper<JiedanxinxiEntity> wrapper);
	
	List<JiedanxinxiView> selectListView(@Param("ew") QueryWrapper<JiedanxinxiEntity> wrapper);

	List<JiedanxinxiView> selectListView(Page page,@Param("ew") QueryWrapper<JiedanxinxiEntity> wrapper);

	
	JiedanxinxiView selectView(@Param("ew") QueryWrapper<JiedanxinxiEntity> wrapper);
	

}
