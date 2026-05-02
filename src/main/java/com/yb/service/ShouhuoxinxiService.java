package com.yb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yb.utils.PageUtils;
import com.yb.entity.ShouhuoxinxiEntity;
import java.util.List;
import java.util.Map;
import com.yb.entity.vo.ShouhuoxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.yb.entity.view.ShouhuoxinxiView;


/**
 * 收货信息
 *
 * @author 
 * @email 
 * @date 2026-01-10 20:50:17
 */
public interface ShouhuoxinxiService extends IService<ShouhuoxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShouhuoxinxiVO> selectListVO(QueryWrapper<ShouhuoxinxiEntity> wrapper);
   	
   	ShouhuoxinxiVO selectVO(@Param("ew") QueryWrapper<ShouhuoxinxiEntity> wrapper);
   	
   	List<ShouhuoxinxiView> selectListView(QueryWrapper<ShouhuoxinxiEntity> wrapper);
   	
   	ShouhuoxinxiView selectView(@Param("ew") QueryWrapper<ShouhuoxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<ShouhuoxinxiEntity> wrapper);

   	

}

