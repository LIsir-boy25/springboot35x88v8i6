package com.yb.dao;

import com.yb.entity.YichangchuliEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.yb.entity.vo.YichangchuliVO;
import com.yb.entity.view.YichangchuliView;


/**
 * 异常处理
 * 
 * @author 
 * @email 
 * @date 2026-01-10 20:50:17
 */
public interface YichangchuliDao extends BaseMapper<YichangchuliEntity> {
	
	List<YichangchuliVO> selectListVO(@Param("ew") QueryWrapper<YichangchuliEntity> wrapper);
	
	YichangchuliVO selectVO(@Param("ew") QueryWrapper<YichangchuliEntity> wrapper);
	
	List<YichangchuliView> selectListView(@Param("ew") QueryWrapper<YichangchuliEntity> wrapper);

	List<YichangchuliView> selectListView(Page page,@Param("ew") QueryWrapper<YichangchuliEntity> wrapper);

	
	YichangchuliView selectView(@Param("ew") QueryWrapper<YichangchuliEntity> wrapper);
	

}
