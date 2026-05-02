package com.yb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yb.utils.PageUtils;
import com.yb.entity.QuyuEntity;
import java.util.List;
import java.util.Map;
import com.yb.entity.vo.QuyuVO;
import org.apache.ibatis.annotations.Param;
import com.yb.entity.view.QuyuView;


/**
 * 区域
 *
 * @author 
 * @email 
 * @date 2026-01-10 20:50:16
 */
public interface QuyuService extends IService<QuyuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QuyuVO> selectListVO(QueryWrapper<QuyuEntity> wrapper);
   	
   	QuyuVO selectVO(@Param("ew") QueryWrapper<QuyuEntity> wrapper);
   	
   	List<QuyuView> selectListView(QueryWrapper<QuyuEntity> wrapper);
   	
   	QuyuView selectView(@Param("ew") QueryWrapper<QuyuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<QuyuEntity> wrapper);

   	

}

