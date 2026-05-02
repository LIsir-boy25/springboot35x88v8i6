package com.yb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yb.utils.PageUtils;
import com.yb.entity.HuozhuEntity;
import java.util.List;
import java.util.Map;
import com.yb.entity.vo.HuozhuVO;
import org.apache.ibatis.annotations.Param;
import com.yb.entity.view.HuozhuView;


/**
 * 货主
 *
 * @author 
 * @email 
 * @date 2026-01-10 20:50:15
 */
public interface HuozhuService extends IService<HuozhuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuozhuVO> selectListVO(QueryWrapper<HuozhuEntity> wrapper);
   	
   	HuozhuVO selectVO(@Param("ew") QueryWrapper<HuozhuEntity> wrapper);
   	
   	List<HuozhuView> selectListView(QueryWrapper<HuozhuEntity> wrapper);
   	
   	HuozhuView selectView(@Param("ew") QueryWrapper<HuozhuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<HuozhuEntity> wrapper);

   	

}

