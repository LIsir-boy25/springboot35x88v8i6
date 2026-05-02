package com.yb.dao;

import com.yb.entity.HuowuleixingEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.yb.entity.vo.HuowuleixingVO;
import com.yb.entity.view.HuowuleixingView;


/**
 * 货物类型
 * 
 * @author 
 * @email 
 * @date 2026-01-10 20:50:15
 */
public interface HuowuleixingDao extends BaseMapper<HuowuleixingEntity> {
	
	List<HuowuleixingVO> selectListVO(@Param("ew") QueryWrapper<HuowuleixingEntity> wrapper);
	
	HuowuleixingVO selectVO(@Param("ew") QueryWrapper<HuowuleixingEntity> wrapper);
	
	List<HuowuleixingView> selectListView(@Param("ew") QueryWrapper<HuowuleixingEntity> wrapper);

	List<HuowuleixingView> selectListView(Page page,@Param("ew") QueryWrapper<HuowuleixingEntity> wrapper);

	
	HuowuleixingView selectView(@Param("ew") QueryWrapper<HuowuleixingEntity> wrapper);
	

}
