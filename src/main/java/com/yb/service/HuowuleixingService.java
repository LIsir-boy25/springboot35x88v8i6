package com.yb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yb.utils.PageUtils;
import com.yb.entity.HuowuleixingEntity;
import java.util.List;
import java.util.Map;
import com.yb.entity.vo.HuowuleixingVO;
import org.apache.ibatis.annotations.Param;
import com.yb.entity.view.HuowuleixingView;


/**
 * 货物类型
 *
 * @author 
 * @email 
 * @date 2026-01-10 20:50:15
 */
public interface HuowuleixingService extends IService<HuowuleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuowuleixingVO> selectListVO(QueryWrapper<HuowuleixingEntity> wrapper);
   	
   	HuowuleixingVO selectVO(@Param("ew") QueryWrapper<HuowuleixingEntity> wrapper);
   	
   	List<HuowuleixingView> selectListView(QueryWrapper<HuowuleixingEntity> wrapper);
   	
   	HuowuleixingView selectView(@Param("ew") QueryWrapper<HuowuleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<HuowuleixingEntity> wrapper);

   	

}

