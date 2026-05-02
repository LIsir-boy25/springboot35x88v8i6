package com.yb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yb.utils.PageUtils;
import com.yb.entity.YunlixinxiEntity;
import java.util.List;
import java.util.Map;
import com.yb.entity.vo.YunlixinxiVO;
import org.apache.ibatis.annotations.Param;
import com.yb.entity.view.YunlixinxiView;


/**
 * 运力信息
 *
 * @author 
 * @email 
 * @date 2026-01-10 20:50:16
 */
public interface YunlixinxiService extends IService<YunlixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YunlixinxiVO> selectListVO(QueryWrapper<YunlixinxiEntity> wrapper);
   	
   	YunlixinxiVO selectVO(@Param("ew") QueryWrapper<YunlixinxiEntity> wrapper);
   	
   	List<YunlixinxiView> selectListView(QueryWrapper<YunlixinxiEntity> wrapper);
   	
   	YunlixinxiView selectView(@Param("ew") QueryWrapper<YunlixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<YunlixinxiEntity> wrapper);

   	

}

