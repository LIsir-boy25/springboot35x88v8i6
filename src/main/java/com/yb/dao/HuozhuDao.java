package com.yb.dao;

import com.yb.entity.HuozhuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.yb.entity.vo.HuozhuVO;
import com.yb.entity.view.HuozhuView;


/**
 * 货主
 * 
 * @author 
 * @email 
 * @date 2026-01-10 20:50:15
 */
public interface HuozhuDao extends BaseMapper<HuozhuEntity> {
	
	List<HuozhuVO> selectListVO(@Param("ew") QueryWrapper<HuozhuEntity> wrapper);
	
	HuozhuVO selectVO(@Param("ew") QueryWrapper<HuozhuEntity> wrapper);
	
	List<HuozhuView> selectListView(@Param("ew") QueryWrapper<HuozhuEntity> wrapper);

	List<HuozhuView> selectListView(Page page,@Param("ew") QueryWrapper<HuozhuEntity> wrapper);

	
	HuozhuView selectView(@Param("ew") QueryWrapper<HuozhuEntity> wrapper);
	

}
