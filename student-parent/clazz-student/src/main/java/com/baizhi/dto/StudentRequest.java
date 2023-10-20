package com.baizhi.dto;

import com.baizhi.entity.Student;
import com.baizhi.entity.Tag;
import lombok.Data;

import java.util.List;
@Data
public class StudentRequest extends Student {
    private List<Integer> tagIds;
}
