package com.yb.dao;

import com.yb.entity.YunlixinxiEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.yb.entity.vo.YunlixinxiVO;
import com.yb.entity.view.YunlixinxiView;


/**
 * 运力信息
 * 
 * @author 
 * @email 
 * @date 2026-01-10 20:50:16
 */
public interface YunlixinxiDao extends BaseMapper<YunlixinxiEntity> {
	
	List<YunlixinxiVO> selectListVO(@Param("ew") QueryWrapper<YunlixinxiEntity> wrapper);
	
	YunlixinxiVO selectVO(@Param("ew") QueryWrapper<YunlixinxiEntity> wrapper);
	
	List<YunlixinxiView> selectListView(@Param("ew") QueryWrapper<YunlixinxiEntity> wrapper);

	List<YunlixinxiView> selectListView(Page page,@Param("ew") QueryWrapper<YunlixinxiEntity> wrapper);

	
	YunlixinxiView selectView(@Param("ew") QueryWrapper<YunlixinxiEntity> wrapper);
	

}
