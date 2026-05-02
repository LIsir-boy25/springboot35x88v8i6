package com.yb.dao;

import com.yb.entity.FuwupingjiaEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.yb.entity.vo.FuwupingjiaVO;
import com.yb.entity.view.FuwupingjiaView;


/**
 * 服务评价
 * 
 * @author 
 * @email 
 * @date 2026-01-10 20:50:17
 */
public interface FuwupingjiaDao extends BaseMapper<FuwupingjiaEntity> {
	
	List<FuwupingjiaVO> selectListVO(@Param("ew") QueryWrapper<FuwupingjiaEntity> wrapper);
	
	FuwupingjiaVO selectVO(@Param("ew") QueryWrapper<FuwupingjiaEntity> wrapper);
	
	List<FuwupingjiaView> selectListView(@Param("ew") QueryWrapper<FuwupingjiaEntity> wrapper);

	List<FuwupingjiaView> selectListView(Page page,@Param("ew") QueryWrapper<FuwupingjiaEntity> wrapper);

	
	FuwupingjiaView selectView(@Param("ew") QueryWrapper<FuwupingjiaEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") QueryWrapper<FuwupingjiaEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") QueryWrapper<FuwupingjiaEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") QueryWrapper<FuwupingjiaEntity> wrapper);



}
