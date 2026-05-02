package com.yb.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import com.baomidou.mybatisplus.annotation.*;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;


/**
 * 司机
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2026-01-10 20:50:15
 */
@TableName("siji")
public class SijiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public SijiEntity() {
		
	}
	
	public SijiEntity(T t) {
		try {
			BeanUtils.copyProperties(t,this);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	/**
	 * 主键id
	 */
    @TableId
	private Long id;
	/**
	 * 司机账号
	 */
					
	private String sijizhanghao;
	
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
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
