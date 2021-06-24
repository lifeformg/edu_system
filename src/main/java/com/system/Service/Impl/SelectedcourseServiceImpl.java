package com.system.service.impl;

import com.system.entity.Student;
import com.system.mapper.SelectedcourseMapper;
import com.system.service.SelectedcourseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SelectedcourseServiceImpl implements SelectedcourseService {

    @Autowired
    private SelectedcourseMapper selectedcourseMapper;

    @Override
    public List<Student> selectStudentByCourseId(Integer courseId) {
        return selectedcourseMapper.selectStudentByCourseId(courseId);
    }
}
