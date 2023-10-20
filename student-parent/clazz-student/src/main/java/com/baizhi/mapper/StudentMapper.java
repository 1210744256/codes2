package com.baizhi.mapper;

import com.baizhi.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
* @author 12107
* @description 针对表【t_student】的数据库操作Mapper
* @createDate 2023-10-18 19:09:46
* @Entity com.baizhi.entity.Student
*/
public interface StudentMapper extends BaseMapper<Student> {
        @MapKey("sid")
        List<Map<Integer,List<Integer>>> selectTagIds();
        List<Integer> selectByTagId(Integer id);
        void insertRelation(@Param("sids")List<Integer> sids,@Param("tids") List<Integer>tids );
}




