package com.yb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yb.utils.PageUtils;
import com.yb.entity.SijiEntity;
import java.util.List;
import java.util.Map;
import com.yb.entity.vo.SijiVO;
import org.apache.ibatis.annotations.Param;
import com.yb.entity.view.SijiView;


/**
 * 司机
 *
 * @author 
 * @email 
 * @date 2026-01-10 20:50:15
 */
public interface SijiService extends IService<SijiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<SijiVO> selectListVO(QueryWrapper<SijiEntity> wrapper);
   	
   	SijiVO selectVO(@Param("ew") QueryWrapper<SijiEntity> wrapper);
   	
   	List<SijiView> selectListView(QueryWrapper<SijiEntity> wrapper);
   	
   	SijiView selectView(@Param("ew") QueryWrapper<SijiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<SijiEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,QueryWrapper<SijiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,QueryWrapper<SijiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,QueryWrapper<SijiEntity> wrapper);



}

