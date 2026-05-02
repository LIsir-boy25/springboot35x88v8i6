package com.yb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yb.utils.PageUtils;
import com.yb.entity.ZhuanghuoxinxiEntity;
import java.util.List;
import java.util.Map;
import com.yb.entity.vo.ZhuanghuoxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.yb.entity.view.ZhuanghuoxinxiView;


/**
 * 装货信息
 *
 * @author 
 * @email 
 * @date 2026-01-10 20:50:17
 */
public interface ZhuanghuoxinxiService extends IService<ZhuanghuoxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhuanghuoxinxiVO> selectListVO(QueryWrapper<ZhuanghuoxinxiEntity> wrapper);
   	
   	ZhuanghuoxinxiVO selectVO(@Param("ew") QueryWrapper<ZhuanghuoxinxiEntity> wrapper);
   	
   	List<ZhuanghuoxinxiView> selectListView(QueryWrapper<ZhuanghuoxinxiEntity> wrapper);
   	
   	ZhuanghuoxinxiView selectView(@Param("ew") QueryWrapper<ZhuanghuoxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<ZhuanghuoxinxiEntity> wrapper);

   	

}

