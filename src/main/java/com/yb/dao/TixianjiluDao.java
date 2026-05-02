package com.yb.dao;

import com.yb.entity.TixianjiluEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.yb.entity.vo.TixianjiluVO;
import com.yb.entity.view.TixianjiluView;


/**
 * 提现记录
 * 
 * @author 
 * @email 
 * @date 2026-01-10 20:50:18
 */
public interface TixianjiluDao extends BaseMapper<TixianjiluEntity> {
	
	List<TixianjiluVO> selectListVO(@Param("ew") QueryWrapper<TixianjiluEntity> wrapper);
	
	TixianjiluVO selectVO(@Param("ew") QueryWrapper<TixianjiluEntity> wrapper);
	
	List<TixianjiluView> selectListView(@Param("ew") QueryWrapper<TixianjiluEntity> wrapper);

	List<TixianjiluView> selectListView(Page page,@Param("ew") QueryWrapper<TixianjiluEntity> wrapper);

	
	TixianjiluView selectView(@Param("ew") QueryWrapper<TixianjiluEntity> wrapper);
	

}
