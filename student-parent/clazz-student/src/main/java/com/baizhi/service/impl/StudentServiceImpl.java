package com.baizhi.service.impl;

import com.baizhi.dto.StudentDto;
import com.baizhi.dto.StudentRequest;
import com.baizhi.entity.*;
import com.baizhi.feign.CityFeign;
import com.baizhi.feign.ClazzFeign;
import com.baizhi.feign.GroupFeign;
import com.baizhi.feign.TagFeign;
import com.baizhi.util.DateUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baizhi.service.StudentService;
import com.baizhi.mapper.StudentMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author 12107
 * @description 针对表【t_student】的数据库操作Service实现
 * @createDate 2023-10-18 19:09:46
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
        implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private CityFeign cityFeign;
    @Autowired
    private ClazzFeign clazzFeign;
    @Autowired
    private GroupFeign groupFeign;
    @Autowired
    private TagFeign tagFeign;

    @Override
    public List<StudentDto> queryAllStudent() {
        List<Clazz> clazzes = clazzFeign.list();
        List<City> cities = cityFeign.queryAll();
        List<Group> groups = groupFeign.queryAll();
        List<Tag> tags = tagFeign.queryAll();
        List<Student> students = studentMapper.selectList(null);
//        Map<Integer, List<Integer>> integerListMap = studentMapper.selectTagIds();
        List<StudentDto> studentDtos = new ArrayList<>();
        for (Student student : students) {
            StudentDto studentDto = new StudentDto();
            BeanUtils.copyProperties(student, studentDto);
            studentDtos.add(studentDto);
        }
        for (StudentDto studentDto : studentDtos) {
            Integer clazzId = Integer.valueOf(studentDto.getClazzid());
            Integer groupId = Integer.valueOf(studentDto.getGroupid());
            Integer cityId = Integer.valueOf(studentDto.getCityid());
            for (Clazz clazz : clazzes) {
                if (clazz.getId().equals(clazzId)) {
                    studentDto.setClazz(clazz);
                    break;
                }
            }
            for (Group group : groups) {
                if (group.getId().equals(groupId)) {
                    studentDto.setGroup(group);
                    break;
                }
            }
            for (City city : cities) {
                if (city.getId().equals(cityId)) {
                    studentDto.setCity(city);
                    break;
                }
            }
            System.out.println(studentDto.getId());
            Integer id = studentDto.getId();
//            获取tag对应的集合
            List<Integer> list = studentMapper.selectByTagId(id);
//            List<Integer> list = integerListMap.get(id);
            List<Tag> tagList = new ArrayList<>();
            for (Tag tag : tags) {
                if (list.contains(tag.getId())) {
                    tagList.add(tag);
                }
            }
            studentDto.setTags(tagList);
        }

        return studentDtos;
    }

    @Override
    public StudentDto saveStudent(StudentRequest studentRequest) {
        Student student=studentRequest;
        Date bir = student.getBir();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(bir);
        student.setAge(DateUtil.getYear(bir));
        student.setStarts(DateUtil.XingZuo
                (calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH + 1), calendar.get(Calendar.DATE)));
        student.setAttr(DateUtil.ShuXiang(calendar.get(Calendar.YEAR)));
        if (student.getMark() == null) student.setMark("该生活泼开朗");
        studentMapper.insert(student);
        List<Integer> tagIds1 = studentRequest.getTagIds();
        studentMapper.insertRelation(Arrays.asList(student.getId()),tagIds1);
        List<Clazz> clazzes = clazzFeign.list();
        List<City> cities = cityFeign.queryAll();
        List<Group> groups = groupFeign.queryAll();
        List<Tag> tags = tagFeign.queryAll();
        StudentDto studentDto = new StudentDto();
        BeanUtils.copyProperties(student,studentDto);
        Integer clazzId = Integer.valueOf(studentDto.getClazzid());
        Integer groupId = Integer.valueOf(studentDto.getGroupid());
        Integer cityId = Integer.valueOf(studentDto.getCityid());
        for (Clazz clazz : clazzes) {
            if (clazz.getId().equals(clazzId)) {
                studentDto.setClazz(clazz);
                break;
            }
        }
        for (Group group : groups) {
            if (group.getId().equals(groupId)) {
                studentDto.setGroup(group);
                break;
            }
        }
        for (City city : cities) {
            if (city.getId().equals(cityId)) {
                studentDto.setCity(city);
                break;
            }
        }
        Integer id = studentDto.getId();
//            获取tag对应的集合
        List<Integer> list = studentMapper.selectByTagId(id);
//            List<Integer> list = integerListMap.get(id);
        List<Tag> tagList = new ArrayList<>();
        for (Tag tag : tags) {
            if (list.contains(tag.getId())) {
                tagList.add(tag);
            }
        }
        return studentDto;
    }
}




