package com.yb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yb.utils.PageUtils;
import com.yb.entity.YichangshangbaoEntity;
import java.util.List;
import java.util.Map;
import com.yb.entity.vo.YichangshangbaoVO;
import org.apache.ibatis.annotations.Param;
import com.yb.entity.view.YichangshangbaoView;


/**
 * 异常上报
 *
 * @author 
 * @email 
 * @date 2026-01-10 20:50:17
 */
public interface YichangshangbaoService extends IService<YichangshangbaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YichangshangbaoVO> selectListVO(QueryWrapper<YichangshangbaoEntity> wrapper);
   	
   	YichangshangbaoVO selectVO(@Param("ew") QueryWrapper<YichangshangbaoEntity> wrapper);
   	
   	List<YichangshangbaoView> selectListView(QueryWrapper<YichangshangbaoEntity> wrapper);
   	
   	YichangshangbaoView selectView(@Param("ew") QueryWrapper<YichangshangbaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<YichangshangbaoEntity> wrapper);

   	

}

