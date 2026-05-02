package com.yb.dao;

import com.yb.entity.DiscussyunlixinxiEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.yb.entity.vo.DiscussyunlixinxiVO;
import com.yb.entity.view.DiscussyunlixinxiView;


/**
 * 运力信息评论
 * 
 * @author 
 * @email 
 * @date 2026-01-10 20:50:19
 */
public interface DiscussyunlixinxiDao extends BaseMapper<DiscussyunlixinxiEntity> {
	
	List<DiscussyunlixinxiVO> selectListVO(@Param("ew") QueryWrapper<DiscussyunlixinxiEntity> wrapper);
	
	DiscussyunlixinxiVO selectVO(@Param("ew") QueryWrapper<DiscussyunlixinxiEntity> wrapper);
	
	List<DiscussyunlixinxiView> selectListView(@Param("ew") QueryWrapper<DiscussyunlixinxiEntity> wrapper);

	List<DiscussyunlixinxiView> selectListView(Page page,@Param("ew") QueryWrapper<DiscussyunlixinxiEntity> wrapper);

	
	DiscussyunlixinxiView selectView(@Param("ew") QueryWrapper<DiscussyunlixinxiEntity> wrapper);
	

}
