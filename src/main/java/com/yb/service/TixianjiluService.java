package com.yb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yb.utils.PageUtils;
import com.yb.entity.TixianjiluEntity;
import java.util.List;
import java.util.Map;
import com.yb.entity.vo.TixianjiluVO;
import org.apache.ibatis.annotations.Param;
import com.yb.entity.view.TixianjiluView;


/**
 * 提现记录
 *
 * @author 
 * @email 
 * @date 2026-01-10 20:50:18
 */
public interface TixianjiluService extends IService<TixianjiluEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TixianjiluVO> selectListVO(QueryWrapper<TixianjiluEntity> wrapper);
   	
   	TixianjiluVO selectVO(@Param("ew") QueryWrapper<TixianjiluEntity> wrapper);
   	
   	List<TixianjiluView> selectListView(QueryWrapper<TixianjiluEntity> wrapper);
   	
   	TixianjiluView selectView(@Param("ew") QueryWrapper<TixianjiluEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<TixianjiluEntity> wrapper);

   	

}

