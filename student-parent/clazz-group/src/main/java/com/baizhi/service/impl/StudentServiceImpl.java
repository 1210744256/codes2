package com.baizhi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baizhi.entity.Student;
import com.baizhi.service.StudentService;
import com.baizhi.mapper.StudentMapper;
import org.springframework.stereotype.Service;

/**
* @author 12107
* @description 针对表【t_student】的数据库操作Service实现
* @createDate 2023-10-18 19:09:26
*/
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
    implements StudentService{

}




