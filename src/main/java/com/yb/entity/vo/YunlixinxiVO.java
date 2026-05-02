package com.yb.entity.vo;

import com.yb.entity.YunlixinxiEntity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 运力信息
 * @author 
 * @email 
 * @date 2026-01-10 20:50:16
 */
public class YunlixinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 货物类型
	 */
	
	private String huowuleixing;
		
	/**
	 * 期望运价范围
	 */
	
	private String qiwangyunjiafanwei;
		
	/**
	 * 状态
	 */
	
	private String zhuangtai;
		
	/**
	 * 车辆图片
	 */
	
	private String cheliangtupian;
		
	/**
	 * 司机账号
	 */
	
	private String sijizhanghao;
		
	/**
	 * 司机姓名
	 */
	
	private String sijixingming;
		
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
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date clicktime;
		
	/**
	 * 评论数
	 */
	
	private Integer discussnum;
		
	/**
	 * 收藏数
	 */
	
	private Integer storeupnum;
				
	
	/**
	 * 设置：货物类型
	 */
	 
	public void setHuowuleixing(String huowuleixing) {
		this.huowuleixing = huowuleixing;
	}
	
	/**
	 * 获取：货物类型
	 */
	public String getHuowuleixing() {
		return huowuleixing;
	}
				
	
	/**
	 * 设置：期望运价范围
	 */
	 
	public void setQiwangyunjiafanwei(String qiwangyunjiafanwei) {
		this.qiwangyunjiafanwei = qiwangyunjiafanwei;
	}
	
	/**
	 * 获取：期望运价范围
	 */
	public String getQiwangyunjiafanwei() {
		return qiwangyunjiafanwei;
	}
				
	
	/**
	 * 设置：状态
	 */
	 
	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}
	
	/**
	 * 获取：状态
	 */
	public String getZhuangtai() {
		return zhuangtai;
	}
				
	
	/**
	 * 设置：车辆图片
	 */
	 
	public void setCheliangtupian(String cheliangtupian) {
		this.cheliangtupian = cheliangtupian;
	}
	
	/**
	 * 获取：车辆图片
	 */
	public String getCheliangtupian() {
		return cheliangtupian;
	}
				
	
	/**
	 * 设置：司机账号
	 */
	 
	public void setSijizhanghao(String sijizhanghao) {
		this.sijizhanghao = sijizhanghao;
	}
	
	/**
	 * 获取：司机账号
	 */
	public String getSijizhanghao() {
		return sijizhanghao;
	}
				
	
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
	 * 设置：最近点击时间
	 */
	 
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
				
	
	/**
	 * 设置：评论数
	 */
	 
	public void setDiscussnum(Integer discussnum) {
		this.discussnum = discussnum;
	}
	
	/**
	 * 获取：评论数
	 */
	public Integer getDiscussnum() {
		return discussnum;
	}
				
	
	/**
	 * 设置：收藏数
	 */
	 
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	
	/**
	 * 获取：收藏数
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}
			
}
