package com.yb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yb.utils.PageUtils;
import com.yb.entity.YichangchuliEntity;
import java.util.List;
import java.util.Map;
import com.yb.entity.vo.YichangchuliVO;
import org.apache.ibatis.annotations.Param;
import com.yb.entity.view.YichangchuliView;


/**
 * 异常处理
 *
 * @author 
 * @email 
 * @date 2026-01-10 20:50:17
 */
public interface YichangchuliService extends IService<YichangchuliEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YichangchuliVO> selectListVO(QueryWrapper<YichangchuliEntity> wrapper);
   	
   	YichangchuliVO selectVO(@Param("ew") QueryWrapper<YichangchuliEntity> wrapper);
   	
   	List<YichangchuliView> selectListView(QueryWrapper<YichangchuliEntity> wrapper);
   	
   	YichangchuliView selectView(@Param("ew") QueryWrapper<YichangchuliEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<YichangchuliEntity> wrapper);

   	

}

