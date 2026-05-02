package com.yb.dao;

import com.yb.entity.SensitivewordsEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.yb.entity.vo.SensitivewordsVO;
import com.yb.entity.view.SensitivewordsView;


/**
 * 敏感词
 * 
 * @author 
 * @email 
 * @date 2026-01-10 20:50:18
 */
public interface SensitivewordsDao extends BaseMapper<SensitivewordsEntity> {
	
	List<SensitivewordsVO> selectListVO(@Param("ew") QueryWrapper<SensitivewordsEntity> wrapper);
	
	SensitivewordsVO selectVO(@Param("ew") QueryWrapper<SensitivewordsEntity> wrapper);
	
	List<SensitivewordsView> selectListView(@Param("ew") QueryWrapper<SensitivewordsEntity> wrapper);

	List<SensitivewordsView> selectListView(Page page,@Param("ew") QueryWrapper<SensitivewordsEntity> wrapper);

	
	SensitivewordsView selectView(@Param("ew") QueryWrapper<SensitivewordsEntity> wrapper);
	

}
