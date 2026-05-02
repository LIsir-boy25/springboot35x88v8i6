package com.yb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yb.utils.PageUtils;
import com.yb.entity.DiscussyunlixinxiEntity;
import java.util.List;
import java.util.Map;
import com.yb.entity.vo.DiscussyunlixinxiVO;
import org.apache.ibatis.annotations.Param;
import com.yb.entity.view.DiscussyunlixinxiView;


/**
 * 运力信息评论
 *
 * @author 
 * @email 
 * @date 2026-01-10 20:50:19
 */
public interface DiscussyunlixinxiService extends IService<DiscussyunlixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussyunlixinxiVO> selectListVO(QueryWrapper<DiscussyunlixinxiEntity> wrapper);
   	
   	DiscussyunlixinxiVO selectVO(@Param("ew") QueryWrapper<DiscussyunlixinxiEntity> wrapper);
   	
   	List<DiscussyunlixinxiView> selectListView(QueryWrapper<DiscussyunlixinxiEntity> wrapper);
   	
   	DiscussyunlixinxiView selectView(@Param("ew") QueryWrapper<DiscussyunlixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<DiscussyunlixinxiEntity> wrapper);

   	

}

