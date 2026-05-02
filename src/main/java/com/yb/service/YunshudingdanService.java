package com.yb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yb.utils.PageUtils;
import com.yb.entity.YunshudingdanEntity;
import java.util.List;
import java.util.Map;
import com.yb.entity.vo.YunshudingdanVO;
import org.apache.ibatis.annotations.Param;
import com.yb.entity.view.YunshudingdanView;


/**
 * 运输订单
 *
 * @author 
 * @email 
 * @date 2026-01-10 20:50:16
 */
public interface YunshudingdanService extends IService<YunshudingdanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YunshudingdanVO> selectListVO(QueryWrapper<YunshudingdanEntity> wrapper);
   	
   	YunshudingdanVO selectVO(@Param("ew") QueryWrapper<YunshudingdanEntity> wrapper);
   	
   	List<YunshudingdanView> selectListView(QueryWrapper<YunshudingdanEntity> wrapper);
   	
   	YunshudingdanView selectView(@Param("ew") QueryWrapper<YunshudingdanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<YunshudingdanEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,QueryWrapper<YunshudingdanEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,QueryWrapper<YunshudingdanEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,QueryWrapper<YunshudingdanEntity> wrapper);



}

