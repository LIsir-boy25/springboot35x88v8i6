package com.yb.entity.vo;

import com.yb.entity.ZhuanghuoxinxiEntity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 装货信息
 * @author 
 * @email 
 * @date 2026-01-10 20:50:17
 */
public class ZhuanghuoxinxiVO  implements Serializable {
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
	 * 装货图片
	 */
	
	private String zhuanghuotupian;
		
	/**
	 * 装货时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date zhuanghuoshijian;
		
	/**
	 * 运输状态
	 */
	
	private String yunshuzhuangtai;
		
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
	 * 车厢尺寸
	 */
	
	private String chexiangchicun;
		
	/**
	 * 手机号
	 */
	
	private String shoujihao;
				
	
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
	 * 设置：装货图片
	 */
	 
	public void setZhuanghuotupian(String zhuanghuotupian) {
		this.zhuanghuotupian = zhuanghuotupian;
	}
	
	/**
	 * 获取：装货图片
	 */
	public String getZhuanghuotupian() {
		return zhuanghuotupian;
	}
				
	
	/**
	 * 设置：装货时间
	 */
	 
	public void setZhuanghuoshijian(Date zhuanghuoshijian) {
		this.zhuanghuoshijian = zhuanghuoshijian;
	}
	
	/**
	 * 获取：装货时间
	 */
	public Date getZhuanghuoshijian() {
		return zhuanghuoshijian;
	}
				
	
	/**
	 * 设置：运输状态
	 */
	 
	public void setYunshuzhuangtai(String yunshuzhuangtai) {
		this.yunshuzhuangtai = yunshuzhuangtai;
	}
	
	/**
	 * 获取：运输状态
	 */
	public String getYunshuzhuangtai() {
		return yunshuzhuangtai;
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
			
}
