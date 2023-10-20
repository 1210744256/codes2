package com.baizhi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName t_group
 */
@TableName(value ="t_group")
@Data
public class Group implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private Date createdate;

    private String clazzid;

    private static final long serialVersionUID = 1L;
}