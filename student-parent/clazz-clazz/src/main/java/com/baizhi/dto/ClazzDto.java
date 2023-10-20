package com.baizhi.dto;

import com.baizhi.entity.Clazz;
import com.baizhi.entity.Tag;
import lombok.Data;

@Data
public class ClazzDto extends Clazz {
    private Tag tag;
}
