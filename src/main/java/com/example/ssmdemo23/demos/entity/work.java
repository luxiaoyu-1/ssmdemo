package com.example.ssmdemo23.demos.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.util.Date;

import static com.baomidou.mybatisplus.annotation.IdType.AUTO;

/**
 * 工作实体类，对应数据库中的work表
 * 用于封装和操作与工作相关的数据记录
 */
@Data
@TableName("work")
public class work {
    @TableId(value = "id",type = AUTO)
    private int id;
    private String name;
    private String classes;
    private String num;
    private String macAdd;
    private Date createTime;
    private Date updateTime;

}