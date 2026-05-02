package com.yb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yb.utils.PageUtils;
import com.yb.entity.SensitivewordsEntity;
import java.util.List;
import java.util.Map;
import com.yb.entity.vo.SensitivewordsVO;
import org.apache.ibatis.annotations.Param;
import com.yb.entity.view.SensitivewordsView;


/**
 * 敏感词
 *
 * @author 
 * @email 
 * @date 2026-01-10 20:50:18
 */
public interface SensitivewordsService extends IService<SensitivewordsEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<SensitivewordsVO> selectListVO(QueryWrapper<SensitivewordsEntity> wrapper);
   	
   	SensitivewordsVO selectVO(@Param("ew") QueryWrapper<SensitivewordsEntity> wrapper);
   	
   	List<SensitivewordsView> selectListView(QueryWrapper<SensitivewordsEntity> wrapper);
   	
   	SensitivewordsView selectView(@Param("ew") QueryWrapper<SensitivewordsEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<SensitivewordsEntity> wrapper);

   	

}

