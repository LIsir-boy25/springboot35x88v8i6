package com.yb.dao;

import com.yb.entity.DiaoduyuanEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.yb.entity.vo.DiaoduyuanVO;
import com.yb.entity.view.DiaoduyuanView;


/**
 * 调度员
 * 
 * @author 
 * @email 
 * @date 2026-01-10 20:50:15
 */
public interface DiaoduyuanDao extends BaseMapper<DiaoduyuanEntity> {
	
	List<DiaoduyuanVO> selectListVO(@Param("ew") QueryWrapper<DiaoduyuanEntity> wrapper);
	
	DiaoduyuanVO selectVO(@Param("ew") QueryWrapper<DiaoduyuanEntity> wrapper);
	
	List<DiaoduyuanView> selectListView(@Param("ew") QueryWrapper<DiaoduyuanEntity> wrapper);

	List<DiaoduyuanView> selectListView(Page page,@Param("ew") QueryWrapper<DiaoduyuanEntity> wrapper);

	
	DiaoduyuanView selectView(@Param("ew") QueryWrapper<DiaoduyuanEntity> wrapper);
	

}
