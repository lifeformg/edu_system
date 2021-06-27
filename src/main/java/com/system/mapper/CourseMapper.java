package com.system.mapper;

import com.system.entity.Course;
import com.system.entity.Page;
import com.system.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {
    int deleteByPrimaryKey(Integer courseid);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer courseid);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

    Integer getTotal();

    List<Course> selectByPage(Page page);

    Integer getSearchTotal(String word);

    List<Course> searchByPage(@Param("word")String word, @Param("page")Page page);

    List<Course> selectByTeacherId(Integer teacherid);

    List<Course> selectByTeacherIdSearch(@Param("teacherid") Integer teacherid,@Param("word") String word);

    List<Course> selectByStudentIdAll(Integer studentid);

    List<Course> selectByStudentIdSelected(Integer studentid);

    List<Course> selectByStudentIdDone(Integer studentid);
}