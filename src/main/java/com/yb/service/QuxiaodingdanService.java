package com.yb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yb.utils.PageUtils;
import com.yb.entity.QuxiaodingdanEntity;
import java.util.List;
import java.util.Map;
import com.yb.entity.vo.QuxiaodingdanVO;
import org.apache.ibatis.annotations.Param;
import com.yb.entity.view.QuxiaodingdanView;


/**
 * 取消订单
 *
 * @author 
 * @email 
 * @date 2026-01-10 20:50:16
 */
public interface QuxiaodingdanService extends IService<QuxiaodingdanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QuxiaodingdanVO> selectListVO(QueryWrapper<QuxiaodingdanEntity> wrapper);
   	
   	QuxiaodingdanVO selectVO(@Param("ew") QueryWrapper<QuxiaodingdanEntity> wrapper);
   	
   	List<QuxiaodingdanView> selectListView(QueryWrapper<QuxiaodingdanEntity> wrapper);
   	
   	QuxiaodingdanView selectView(@Param("ew") QueryWrapper<QuxiaodingdanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<QuxiaodingdanEntity> wrapper);

   	

}

