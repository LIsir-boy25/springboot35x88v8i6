package com.yb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yb.utils.PageUtils;
import com.yb.entity.DaodazhuanghuodiEntity;
import java.util.List;
import java.util.Map;
import com.yb.entity.vo.DaodazhuanghuodiVO;
import org.apache.ibatis.annotations.Param;
import com.yb.entity.view.DaodazhuanghuodiView;


/**
 * 到达装货地
 *
 * @author 
 * @email 
 * @date 2026-01-10 20:50:17
 */
public interface DaodazhuanghuodiService extends IService<DaodazhuanghuodiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DaodazhuanghuodiVO> selectListVO(QueryWrapper<DaodazhuanghuodiEntity> wrapper);
   	
   	DaodazhuanghuodiVO selectVO(@Param("ew") QueryWrapper<DaodazhuanghuodiEntity> wrapper);
   	
   	List<DaodazhuanghuodiView> selectListView(QueryWrapper<DaodazhuanghuodiEntity> wrapper);
   	
   	DaodazhuanghuodiView selectView(@Param("ew") QueryWrapper<DaodazhuanghuodiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<DaodazhuanghuodiEntity> wrapper);

   	

}

