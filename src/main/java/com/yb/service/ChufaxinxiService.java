package com.yb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yb.utils.PageUtils;
import com.yb.entity.ChufaxinxiEntity;
import java.util.List;
import java.util.Map;
import com.yb.entity.vo.ChufaxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.yb.entity.view.ChufaxinxiView;


/**
 * 出发信息
 *
 * @author 
 * @email 
 * @date 2026-01-10 20:50:16
 */
public interface ChufaxinxiService extends IService<ChufaxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChufaxinxiVO> selectListVO(QueryWrapper<ChufaxinxiEntity> wrapper);
   	
   	ChufaxinxiVO selectVO(@Param("ew") QueryWrapper<ChufaxinxiEntity> wrapper);
   	
   	List<ChufaxinxiView> selectListView(QueryWrapper<ChufaxinxiEntity> wrapper);
   	
   	ChufaxinxiView selectView(@Param("ew") QueryWrapper<ChufaxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<ChufaxinxiEntity> wrapper);

   	

}

