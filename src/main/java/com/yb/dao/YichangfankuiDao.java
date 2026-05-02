package com.yb.dao;

import com.yb.entity.YichangfankuiEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.yb.entity.vo.YichangfankuiVO;
import com.yb.entity.view.YichangfankuiView;


/**
 * 异常反馈
 * 
 * @author 
 * @email 
 * @date 2026-01-10 20:50:17
 */
public interface YichangfankuiDao extends BaseMapper<YichangfankuiEntity> {
	
	List<YichangfankuiVO> selectListVO(@Param("ew") QueryWrapper<YichangfankuiEntity> wrapper);
	
	YichangfankuiVO selectVO(@Param("ew") QueryWrapper<YichangfankuiEntity> wrapper);
	
	List<YichangfankuiView> selectListView(@Param("ew") QueryWrapper<YichangfankuiEntity> wrapper);

	List<YichangfankuiView> selectListView(Page page,@Param("ew") QueryWrapper<YichangfankuiEntity> wrapper);

	
	YichangfankuiView selectView(@Param("ew") QueryWrapper<YichangfankuiEntity> wrapper);
	

}
