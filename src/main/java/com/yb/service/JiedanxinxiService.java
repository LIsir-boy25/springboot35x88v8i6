package com.yb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yb.utils.PageUtils;
import com.yb.entity.JiedanxinxiEntity;
import java.util.List;
import java.util.Map;
import com.yb.entity.vo.JiedanxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.yb.entity.view.JiedanxinxiView;


/**
 * 接单信息
 *
 * @author 
 * @email 
 * @date 2026-01-10 20:50:16
 */
public interface JiedanxinxiService extends IService<JiedanxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiedanxinxiVO> selectListVO(QueryWrapper<JiedanxinxiEntity> wrapper);
   	
   	JiedanxinxiVO selectVO(@Param("ew") QueryWrapper<JiedanxinxiEntity> wrapper);
   	
   	List<JiedanxinxiView> selectListView(QueryWrapper<JiedanxinxiEntity> wrapper);
   	
   	JiedanxinxiView selectView(@Param("ew") QueryWrapper<JiedanxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<JiedanxinxiEntity> wrapper);

   	

}

