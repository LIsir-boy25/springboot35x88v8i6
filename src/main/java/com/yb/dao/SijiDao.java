package com.yb.dao;

import com.yb.entity.SijiEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.yb.entity.vo.SijiVO;
import com.yb.entity.view.SijiView;


/**
 * 司机
 * 
 * @author 
 * @email 
 * @date 2026-01-10 20:50:15
 */
public interface SijiDao extends BaseMapper<SijiEntity> {
	
	List<SijiVO> selectListVO(@Param("ew") QueryWrapper<SijiEntity> wrapper);
	
	SijiVO selectVO(@Param("ew") QueryWrapper<SijiEntity> wrapper);
	
	List<SijiView> selectListView(@Param("ew") QueryWrapper<SijiEntity> wrapper);

	List<SijiView> selectListView(Page page,@Param("ew") QueryWrapper<SijiEntity> wrapper);

	
	SijiView selectView(@Param("ew") QueryWrapper<SijiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") QueryWrapper<SijiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") QueryWrapper<SijiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") QueryWrapper<SijiEntity> wrapper);



}
