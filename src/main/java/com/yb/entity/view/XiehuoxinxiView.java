package com.yb.entity.view;

import com.yb.entity.XiehuoxinxiEntity;

import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.yb.utils.EncryptUtil;
 

/**
 * 卸货信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2026-01-10 20:50:17
 */
@TableName("xiehuoxinxi")
public class XiehuoxinxiView  extends XiehuoxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XiehuoxinxiView(){
	}
 
 	public XiehuoxinxiView(XiehuoxinxiEntity xiehuoxinxiEntity){
 	try {
			BeanUtils.copyProperties(xiehuoxinxiEntity,this);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
