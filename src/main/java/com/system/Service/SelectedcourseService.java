package com.system.service;

import com.system.entity.Selectedcourse;
import com.system.entity.Student;

import java.util.List;

public interface SelectedcourseService {
    public List<Student> selectStudentByCourseId(Integer courseId);

    public boolean updateSelective(Selectedcourse selectedcourse);
}
