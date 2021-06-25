package com.system.mapper;

import com.system.entity.Selectedcourse;
import com.system.entity.Student;

import java.util.List;

public interface SelectedcourseMapper {
    int insert(Selectedcourse record);

    int insertSelective(Selectedcourse record);

    int updateSelective(Selectedcourse record);

    List<Student> selectStudentByCourseId(Integer courseid);
}