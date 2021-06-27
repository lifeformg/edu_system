package com.system.service;

import com.system.entity.Selectedcourse;
import com.system.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SelectedcourseService {
    public List<Selectedcourse> selectStudentByCourseId(Integer courseId);

    public boolean updateSelective(Selectedcourse selectedcourse);

    public boolean select(Integer studentid,Integer courseid);

    public boolean unselect(Integer studentid,Integer courseid);
}
