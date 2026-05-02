package com.yb.entity.vo;

import com.yb.entity.ChexingEntity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 车型
 * @author 
 * @email 
 * @date 2026-01-10 20:50:16
 */
public class ChexingVO  implements Serializable {
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
