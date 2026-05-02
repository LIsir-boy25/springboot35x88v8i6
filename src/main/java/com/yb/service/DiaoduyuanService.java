package com.yb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yb.utils.PageUtils;
import com.yb.entity.DiaoduyuanEntity;
import java.util.List;
import java.util.Map;
import com.yb.entity.vo.DiaoduyuanVO;
import org.apache.ibatis.annotations.Param;
import com.yb.entity.view.DiaoduyuanView;


/**
 * 调度员
 *
 * @author 
 * @email 
 * @date 2026-01-10 20:50:15
 */
public interface DiaoduyuanService extends IService<DiaoduyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiaoduyuanVO> selectListVO(QueryWrapper<DiaoduyuanEntity> wrapper);
   	
   	DiaoduyuanVO selectVO(@Param("ew") QueryWrapper<DiaoduyuanEntity> wrapper);
   	
   	List<DiaoduyuanView> selectListView(QueryWrapper<DiaoduyuanEntity> wrapper);
   	
   	DiaoduyuanView selectView(@Param("ew") QueryWrapper<DiaoduyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<DiaoduyuanEntity> wrapper);

   	

}

