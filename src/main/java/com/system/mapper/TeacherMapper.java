package com.system.mapper;

import com.system.entity.Page;
import com.system.entity.Student;
import com.system.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

    List<Teacher> selectAllTeacher();

    Integer getTotal();

    List<Teacher> selectByPage(Page page);

    Integer getSearchTotal(String word);

    List<Teacher> searchByPage(@Param("word")String word, @Param("page")Page page);
}