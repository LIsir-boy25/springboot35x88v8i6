package com.yb.dao;

import com.yb.entity.YunshudingdanEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.yb.entity.vo.YunshudingdanVO;
import com.yb.entity.view.YunshudingdanView;


/**
 * 运输订单
 * 
 * @author 
 * @email 
 * @date 2026-01-10 20:50:16
 */
public interface YunshudingdanDao extends BaseMapper<YunshudingdanEntity> {
	
	List<YunshudingdanVO> selectListVO(@Param("ew") QueryWrapper<YunshudingdanEntity> wrapper);
	
	YunshudingdanVO selectVO(@Param("ew") QueryWrapper<YunshudingdanEntity> wrapper);
	
	List<YunshudingdanView> selectListView(@Param("ew") QueryWrapper<YunshudingdanEntity> wrapper);

	List<YunshudingdanView> selectListView(Page page,@Param("ew") QueryWrapper<YunshudingdanEntity> wrapper);

	
	YunshudingdanView selectView(@Param("ew") QueryWrapper<YunshudingdanEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") QueryWrapper<YunshudingdanEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") QueryWrapper<YunshudingdanEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") QueryWrapper<YunshudingdanEntity> wrapper);



}
