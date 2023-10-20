package com.baizhi.dto;

import com.baizhi.entity.*;
import lombok.Data;

import java.util.List;
@Data
public class StudentDto extends Student {
    private Clazz clazz;
    private Group group;
    private City city;
    private List<Tag> tags;
}
