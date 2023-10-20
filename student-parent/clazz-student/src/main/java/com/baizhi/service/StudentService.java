package com.baizhi.service;

import com.baizhi.dto.StudentDto;
import com.baizhi.dto.StudentRequest;
import com.baizhi.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;
import jdk.internal.dynalink.linker.LinkerServices;

import java.util.List;

/**
* @author 12107
* @description 针对表【t_student】的数据库操作Service
* @createDate 2023-10-18 19:09:46
*/
public interface StudentService extends IService<Student> {
        public List<StudentDto> queryAllStudent();
        public StudentDto saveStudent(StudentRequest studentRequest);
}
