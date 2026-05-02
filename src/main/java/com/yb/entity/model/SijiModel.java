package com.yb.entity.model;

import com.yb.entity.SijiEntity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 司机
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2026-01-10 20:50:15
 */
public class SijiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 司机姓名
	 */
	
	private String sijixingming;
		
	/**
	 * 密码
	 */
	
	private String mima;
		
	/**
	 * 性别
	 */
	
	private String xingbie;
		
	/**
	 * 驾驶证
	 */
	
	private String jiashizheng;
		
	/**
	 * 行驶证
	 */
	
	private String xingshizheng;
		
	/**
	 * 车牌
	 */
	
	private String chepai;
		
	/**
	 * 车型
	 */
	
	private String chexing;
		
	/**
	 * 载重
	 */
	
	private String zaizhong;
		
	/**
	 * 车厢尺寸
	 */
	
	private String chexiangchicun;
		
	/**
	 * 手机号
	 */
	
	private String shoujihao;
		
	/**
	 * 头像
	 */
	
	private String touxiang;
		
	/**
	 * 余额
	 */
	
	private Double yue;
		
	/**
	 * 是否审核
	 */
	
	private String sfsh;
		
	/**
	 * 审核回复
	 */
	
	private String shhf;
		
	/**
	 * 密保问题
	 */
	
	private String pquestion;
		
	/**
	 * 密保答案
	 */
	
	private String panswer;
		
	/**
	 * 状态
	 */
	
	private Integer status;
				
	
	/**
	 * 设置：司机姓名
	 */
	 
	public void setSijixingming(String sijixingming) {
		this.sijixingming = sijixingming;
	}
	
	/**
	 * 获取：司机姓名
	 */
	public String getSijixingming() {
		return sijixingming;
	}
				
	
	/**
	 * 设置：密码
	 */
	 
	public void setMima(String mima) {
		this.mima = mima;
	}
	
	/**
	 * 获取：密码
	 */
	public String getMima() {
		return mima;
	}
				
	
	/**
	 * 设置：性别
	 */
	 
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	
	/**
	 * 获取：性别
	 */
	public String getXingbie() {
		return xingbie;
	}
				
	
	/**
	 * 设置：驾驶证
	 */
	 
	public void setJiashizheng(String jiashizheng) {
		this.jiashizheng = jiashizheng;
	}
	
	/**
	 * 获取：驾驶证
	 */
	public String getJiashizheng() {
		return jiashizheng;
	}
				
	
	/**
	 * 设置：行驶证
	 */
	 
	public void setXingshizheng(String xingshizheng) {
		this.xingshizheng = xingshizheng;
	}
	
	/**
	 * 获取：行驶证
	 */
	public String getXingshizheng() {
		return xingshizheng;
	}
				
	
	/**
	 * 设置：车牌
	 */
	 
	public void setChepai(String chepai) {
		this.chepai = chepai;
	}
	
	/**
	 * 获取：车牌
	 */
	public String getChepai() {
		return chepai;
	}
				
	
	/**
	 * 设置：车型
	 */
	 
	public void setChexing(String chexing) {
		this.chexing = chexing;
	}
	
	/**
	 * 获取：车型
	 */
	public String getChexing() {
		return chexing;
	}
				
	
	/**
	 * 设置：载重
	 */
	 
	public void setZaizhong(String zaizhong) {
		this.zaizhong = zaizhong;
	}
	
	/**
	 * 获取：载重
	 */
	public String getZaizhong() {
		return zaizhong;
	}
				
	
	/**
	 * 设置：车厢尺寸
	 */
	 
	public void setChexiangchicun(String chexiangchicun) {
		this.chexiangchicun = chexiangchicun;
	}
	
	/**
	 * 获取：车厢尺寸
	 */
	public String getChexiangchicun() {
		return chexiangchicun;
	}
				
	
	/**
	 * 设置：手机号
	 */
	 
	public void setShoujihao(String shoujihao) {
		this.shoujihao = shoujihao;
	}
	
	/**
	 * 获取：手机号
	 */
	public String getShoujihao() {
		return shoujihao;
	}
				
	
	/**
	 * 设置：头像
	 */
	 
	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}
	
	/**
	 * 获取：头像
	 */
	public String getTouxiang() {
		return touxiang;
	}
				
	
	/**
	 * 设置：余额
	 */
	 
	public void setYue(Double yue) {
		this.yue = yue;
	}
	
	/**
	 * 获取：余额
	 */
	public Double getYue() {
		return yue;
	}
				
	
	/**
	 * 设置：是否审核
	 */
	 
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
				
	
	/**
	 * 设置：审核回复
	 */
	 
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}
				
	
	/**
	 * 设置：密保问题
	 */
	 
	public void setPquestion(String pquestion) {
		this.pquestion = pquestion;
	}
	
	/**
	 * 获取：密保问题
	 */
	public String getPquestion() {
		return pquestion;
	}
				
	
	/**
	 * 设置：密保答案
	 */
	 
	public void setPanswer(String panswer) {
		this.panswer = panswer;
	}
	
	/**
	 * 获取：密保答案
	 */
	public String getPanswer() {
		return panswer;
	}
				
	
	/**
	 * 设置：状态
	 */
	 
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	/**
	 * 获取：状态
	 */
	public Integer getStatus() {
		return status;
	}
			
}
