package com.system.mapper;

import com.system.entity.Selectedcourse;
import com.system.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SelectedcourseMapper {
    int insert(Selectedcourse record);

    int insertSelective(Selectedcourse record);

    int updateSelective(Selectedcourse record);

    List<Selectedcourse> selectStudentByCourseId(Integer courseid);

    int delete(@Param("courseid") Integer courseid,@Param("studentid") Integer studentid);
}