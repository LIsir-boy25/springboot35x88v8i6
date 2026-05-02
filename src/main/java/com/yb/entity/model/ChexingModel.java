package com.yb.entity.model;

import com.yb.entity.ChexingEntity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 车型
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2026-01-10 20:50:16
 */
public class ChexingModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 每公里价格(元)
	 */
	
	private Double jiage;
				
	
	/**
	 * 设置：每公里价格(元)
	 */
	 
	public void setJiage(Double jiage) {
		this.jiage = jiage;
	}
	
	/**
	 * 获取：每公里价格(元)
	 */
	public Double getJiage() {
		return jiage;
	}
			
}
