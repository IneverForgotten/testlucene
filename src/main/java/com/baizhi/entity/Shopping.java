package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shopping {
    private String id;
    private String name;
    private double price;
    private String src;
    private String status;
    private String address;

private String descripe;
    @DateTimeFormat(pattern="yyyy-MM-DD")//页面写入数据库时格式化
    @JSONField(format="yyyy-MM-dd")
    private Date addTime;

}
