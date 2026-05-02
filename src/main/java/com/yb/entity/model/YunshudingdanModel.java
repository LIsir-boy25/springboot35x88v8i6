package com.yb.entity.model;

import com.yb.entity.YunshudingdanEntity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 运输订单
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2026-01-10 20:50:16
 */
public class YunshudingdanModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 区域
	 */
	
	private String quyu;
		
	/**
	 * 货物类型
	 */
	
	private String huowuleixing;
		
	/**
	 * 重量(kg)
	 */
	
	private String zhongliang;
		
	/**
	 * 体积(m³)
	 */
	
	private String tiji;
		
	/**
	 * 货物图片
	 */
	
	private String huowutupian;
		
	/**
	 * 装货地址
	 */
	
	private String zhuanghuodizhi;
		
	/**
	 * 送货地址
	 */
	
	private String songhuodizhi;
		
	/**
	 * 期望装货时间
	 */
	
	private String qiwangzhuanghuoshijian;
		
	/**
	 * 是否需要回单
	 */
	
	private String shifouxuyaohuidan;
		
	/**
	 * 里程
	 */
	
	private Double licheng;
		
	/**
	 * 车型
	 */
	
	private String chexing;
		
	/**
	 * 每公里价格(元)
	 */
	
	private Double jiage;
		
	/**
	 * 运费
	 */
	
	private Double yue;
		
	/**
	 * 订单状态
	 */
	
	private String dingdanzhuangtai;
		
	/**
	 * 发布时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date fabushijian;
		
	/**
	 * 货主账号
	 */
	
	private String huozhuzhanghao;
		
	/**
	 * 货主姓名
	 */
	
	private String huozhuxingming;
		
	/**
	 * 联系方式
	 */
	
	private String lianxifangshi;
		
	/**
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date clicktime;
		
	/**
	 * 收藏数
	 */
	
	private Integer storeupnum;
				
	
	/**
	 * 设置：区域
	 */
	 
	public void setQuyu(String quyu) {
		this.quyu = quyu;
	}
	
	/**
	 * 获取：区域
	 */
	public String getQuyu() {
		return quyu;
	}
				
	
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
	 * 设置：重量(kg)
	 */
	 
	public void setZhongliang(String zhongliang) {
		this.zhongliang = zhongliang;
	}
	
	/**
	 * 获取：重量(kg)
	 */
	public String getZhongliang() {
		return zhongliang;
	}
				
	
	/**
	 * 设置：体积(m³)
	 */
	 
	public void setTiji(String tiji) {
		this.tiji = tiji;
	}
	
	/**
	 * 获取：体积(m³)
	 */
	public String getTiji() {
		return tiji;
	}
				
	
	/**
	 * 设置：货物图片
	 */
	 
	public void setHuowutupian(String huowutupian) {
		this.huowutupian = huowutupian;
	}
	
	/**
	 * 获取：货物图片
	 */
	public String getHuowutupian() {
		return huowutupian;
	}
				
	
	/**
	 * 设置：装货地址
	 */
	 
	public void setZhuanghuodizhi(String zhuanghuodizhi) {
		this.zhuanghuodizhi = zhuanghuodizhi;
	}
	
	/**
	 * 获取：装货地址
	 */
	public String getZhuanghuodizhi() {
		return zhuanghuodizhi;
	}
				
	
	/**
	 * 设置：送货地址
	 */
	 
	public void setSonghuodizhi(String songhuodizhi) {
		this.songhuodizhi = songhuodizhi;
	}
	
	/**
	 * 获取：送货地址
	 */
	public String getSonghuodizhi() {
		return songhuodizhi;
	}
				
	
	/**
	 * 设置：期望装货时间
	 */
	 
	public void setQiwangzhuanghuoshijian(String qiwangzhuanghuoshijian) {
		this.qiwangzhuanghuoshijian = qiwangzhuanghuoshijian;
	}
	
	/**
	 * 获取：期望装货时间
	 */
	public String getQiwangzhuanghuoshijian() {
		return qiwangzhuanghuoshijian;
	}
				
	
	/**
	 * 设置：是否需要回单
	 */
	 
	public void setShifouxuyaohuidan(String shifouxuyaohuidan) {
		this.shifouxuyaohuidan = shifouxuyaohuidan;
	}
	
	/**
	 * 获取：是否需要回单
	 */
	public String getShifouxuyaohuidan() {
		return shifouxuyaohuidan;
	}
				
	
	/**
	 * 设置：里程
	 */
	 
	public void setLicheng(Double licheng) {
		this.licheng = licheng;
	}
	
	/**
	 * 获取：里程
	 */
	public Double getLicheng() {
		return licheng;
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
				
	
	/**
	 * 设置：运费
	 */
	 
	public void setYue(Double yue) {
		this.yue = yue;
	}
	
	/**
	 * 获取：运费
	 */
	public Double getYue() {
		return yue;
	}
				
	
	/**
	 * 设置：订单状态
	 */
	 
	public void setDingdanzhuangtai(String dingdanzhuangtai) {
		this.dingdanzhuangtai = dingdanzhuangtai;
	}
	
	/**
	 * 获取：订单状态
	 */
	public String getDingdanzhuangtai() {
		return dingdanzhuangtai;
	}
				
	
	/**
	 * 设置：发布时间
	 */
	 
	public void setFabushijian(Date fabushijian) {
		this.fabushijian = fabushijian;
	}
	
	/**
	 * 获取：发布时间
	 */
	public Date getFabushijian() {
		return fabushijian;
	}
				
	
	/**
	 * 设置：货主账号
	 */
	 
	public void setHuozhuzhanghao(String huozhuzhanghao) {
		this.huozhuzhanghao = huozhuzhanghao;
	}
	
	/**
	 * 获取：货主账号
	 */
	public String getHuozhuzhanghao() {
		return huozhuzhanghao;
	}
				
	
	/**
	 * 设置：货主姓名
	 */
	 
	public void setHuozhuxingming(String huozhuxingming) {
		this.huozhuxingming = huozhuxingming;
	}
	
	/**
	 * 获取：货主姓名
	 */
	public String getHuozhuxingming() {
		return huozhuxingming;
	}
				
	
	/**
	 * 设置：联系方式
	 */
	 
	public void setLianxifangshi(String lianxifangshi) {
		this.lianxifangshi = lianxifangshi;
	}
	
	/**
	 * 获取：联系方式
	 */
	public String getLianxifangshi() {
		return lianxifangshi;
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
