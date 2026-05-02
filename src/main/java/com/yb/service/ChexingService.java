package com.yb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yb.utils.PageUtils;
import com.yb.entity.ChexingEntity;
import java.util.List;
import java.util.Map;
import com.yb.entity.vo.ChexingVO;
import org.apache.ibatis.annotations.Param;
import com.yb.entity.view.ChexingView;


/**
 * 车型
 *
 * @author 
 * @email 
 * @date 2026-01-10 20:50:16
 */
public interface ChexingService extends IService<ChexingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChexingVO> selectListVO(QueryWrapper<ChexingEntity> wrapper);
   	
   	ChexingVO selectVO(@Param("ew") QueryWrapper<ChexingEntity> wrapper);
   	
   	List<ChexingView> selectListView(QueryWrapper<ChexingEntity> wrapper);
   	
   	ChexingView selectView(@Param("ew") QueryWrapper<ChexingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<ChexingEntity> wrapper);

   	

}

