package com.baizhi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName t_student
 */
@TableName(value ="t_student")
@Data
public class Student implements Serializable {
    private Integer id;

    private String name;

    private Integer age;

    private String qq;

    private String phone;

    private Date bir;

    private String starts;

    private String attr;

    private String mark;

    private String clazzid;

    private String groupid;

    private String cityid;

    private static final long serialVersionUID = 1L;
}