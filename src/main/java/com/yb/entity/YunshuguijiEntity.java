package com.yb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.util.Date;

@Data
@TableName("yunshuguiji")
public class YunshuguijiEntity {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Date addtime;
    private String dingdanbianhao;
    private String sijizhanghao;
    private Double jingdu;
    private Double weidu;
    private String dizhi;
    private Date shijian;
}