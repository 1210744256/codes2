package com.baizhi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName t_clazz
 */
@TableName(value ="t_clazz")
@Data
public class Clazz implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private String path;

    private String tagid;

    private static final long serialVersionUID = 1L;
}