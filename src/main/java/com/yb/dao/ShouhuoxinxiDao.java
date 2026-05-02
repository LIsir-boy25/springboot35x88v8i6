package com.yb.dao;

import com.yb.entity.ShouhuoxinxiEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.yb.entity.vo.ShouhuoxinxiVO;
import com.yb.entity.view.ShouhuoxinxiView;


/**
 * 收货信息
 * 
 * @author 
 * @email 
 * @date 2026-01-10 20:50:17
 */
public interface ShouhuoxinxiDao extends BaseMapper<ShouhuoxinxiEntity> {
	
	List<ShouhuoxinxiVO> selectListVO(@Param("ew") QueryWrapper<ShouhuoxinxiEntity> wrapper);
	
	ShouhuoxinxiVO selectVO(@Param("ew") QueryWrapper<ShouhuoxinxiEntity> wrapper);
	
	List<ShouhuoxinxiView> selectListView(@Param("ew") QueryWrapper<ShouhuoxinxiEntity> wrapper);

	List<ShouhuoxinxiView> selectListView(Page page,@Param("ew") QueryWrapper<ShouhuoxinxiEntity> wrapper);

	
	ShouhuoxinxiView selectView(@Param("ew") QueryWrapper<ShouhuoxinxiEntity> wrapper);
	

}
