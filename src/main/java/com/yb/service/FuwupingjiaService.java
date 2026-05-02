package com.yb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yb.utils.PageUtils;
import com.yb.entity.FuwupingjiaEntity;
import java.util.List;
import java.util.Map;
import com.yb.entity.vo.FuwupingjiaVO;
import org.apache.ibatis.annotations.Param;
import com.yb.entity.view.FuwupingjiaView;


/**
 * 服务评价
 *
 * @author 
 * @email 
 * @date 2026-01-10 20:50:17
 */
public interface FuwupingjiaService extends IService<FuwupingjiaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FuwupingjiaVO> selectListVO(QueryWrapper<FuwupingjiaEntity> wrapper);
   	
   	FuwupingjiaVO selectVO(@Param("ew") QueryWrapper<FuwupingjiaEntity> wrapper);
   	
   	List<FuwupingjiaView> selectListView(QueryWrapper<FuwupingjiaEntity> wrapper);
   	
   	FuwupingjiaView selectView(@Param("ew") QueryWrapper<FuwupingjiaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<FuwupingjiaEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,QueryWrapper<FuwupingjiaEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,QueryWrapper<FuwupingjiaEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,QueryWrapper<FuwupingjiaEntity> wrapper);



}

