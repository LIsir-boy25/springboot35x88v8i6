package com.yb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yb.utils.PageUtils;
import com.yb.entity.YichangfankuiEntity;
import java.util.List;
import java.util.Map;
import com.yb.entity.vo.YichangfankuiVO;
import org.apache.ibatis.annotations.Param;
import com.yb.entity.view.YichangfankuiView;


/**
 * 异常反馈
 *
 * @author 
 * @email 
 * @date 2026-01-10 20:50:17
 */
public interface YichangfankuiService extends IService<YichangfankuiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YichangfankuiVO> selectListVO(QueryWrapper<YichangfankuiEntity> wrapper);
   	
   	YichangfankuiVO selectVO(@Param("ew") QueryWrapper<YichangfankuiEntity> wrapper);
   	
   	List<YichangfankuiView> selectListView(QueryWrapper<YichangfankuiEntity> wrapper);
   	
   	YichangfankuiView selectView(@Param("ew") QueryWrapper<YichangfankuiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<YichangfankuiEntity> wrapper);

   	

}

