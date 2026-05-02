package com.yb.dao;

import com.yb.entity.YichangshangbaoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.yb.entity.vo.YichangshangbaoVO;
import com.yb.entity.view.YichangshangbaoView;


/**
 * 异常上报
 * 
 * @author 
 * @email 
 * @date 2026-01-10 20:50:17
 */
public interface YichangshangbaoDao extends BaseMapper<YichangshangbaoEntity> {
	
	List<YichangshangbaoVO> selectListVO(@Param("ew") QueryWrapper<YichangshangbaoEntity> wrapper);
	
	YichangshangbaoVO selectVO(@Param("ew") QueryWrapper<YichangshangbaoEntity> wrapper);
	
	List<YichangshangbaoView> selectListView(@Param("ew") QueryWrapper<YichangshangbaoEntity> wrapper);

	List<YichangshangbaoView> selectListView(Page page,@Param("ew") QueryWrapper<YichangshangbaoEntity> wrapper);

	
	YichangshangbaoView selectView(@Param("ew") QueryWrapper<YichangshangbaoEntity> wrapper);
	

}
