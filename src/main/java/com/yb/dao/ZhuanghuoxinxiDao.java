package com.yb.dao;

import com.yb.entity.ZhuanghuoxinxiEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.yb.entity.vo.ZhuanghuoxinxiVO;
import com.yb.entity.view.ZhuanghuoxinxiView;


/**
 * 装货信息
 * 
 * @author 
 * @email 
 * @date 2026-01-10 20:50:17
 */
public interface ZhuanghuoxinxiDao extends BaseMapper<ZhuanghuoxinxiEntity> {
	
	List<ZhuanghuoxinxiVO> selectListVO(@Param("ew") QueryWrapper<ZhuanghuoxinxiEntity> wrapper);
	
	ZhuanghuoxinxiVO selectVO(@Param("ew") QueryWrapper<ZhuanghuoxinxiEntity> wrapper);
	
	List<ZhuanghuoxinxiView> selectListView(@Param("ew") QueryWrapper<ZhuanghuoxinxiEntity> wrapper);

	List<ZhuanghuoxinxiView> selectListView(Page page,@Param("ew") QueryWrapper<ZhuanghuoxinxiEntity> wrapper);

	
	ZhuanghuoxinxiView selectView(@Param("ew") QueryWrapper<ZhuanghuoxinxiEntity> wrapper);
	

}
