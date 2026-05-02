package com.yb.entity.view;

import com.yb.entity.FuwupingjiaEntity;

import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.yb.utils.EncryptUtil;
 

/**
 * 服务评价
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2026-01-10 20:50:17
 */
@TableName("fuwupingjia")
public class FuwupingjiaView  extends FuwupingjiaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public FuwupingjiaView(){
	}
 
 	public FuwupingjiaView(FuwupingjiaEntity fuwupingjiaEntity){
 	try {
			BeanUtils.copyProperties(fuwupingjiaEntity,this);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
