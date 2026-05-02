package com.yb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yb.utils.PageUtils;
import com.yb.entity.XiehuoxinxiEntity;
import java.util.List;
import java.util.Map;
import com.yb.entity.vo.XiehuoxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.yb.entity.view.XiehuoxinxiView;


/**
 * 卸货信息
 *
 * @author 
 * @email 
 * @date 2026-01-10 20:50:17
 */
public interface XiehuoxinxiService extends IService<XiehuoxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XiehuoxinxiVO> selectListVO(QueryWrapper<XiehuoxinxiEntity> wrapper);
   	
   	XiehuoxinxiVO selectVO(@Param("ew") QueryWrapper<XiehuoxinxiEntity> wrapper);
   	
   	List<XiehuoxinxiView> selectListView(QueryWrapper<XiehuoxinxiEntity> wrapper);
   	
   	XiehuoxinxiView selectView(@Param("ew") QueryWrapper<XiehuoxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<XiehuoxinxiEntity> wrapper);

   	

}

