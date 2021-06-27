package com.system.service.impl;

import com.system.entity.Selectedcourse;
import com.system.entity.Student;
import com.system.mapper.SelectedcourseMapper;
import com.system.service.SelectedcourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelectedcourseServiceImpl implements SelectedcourseService {

    @Autowired
    private SelectedcourseMapper selectedcourseMapper;

    @Override
    public List<Selectedcourse> selectStudentByCourseId(Integer courseId) {
        return selectedcourseMapper.selectStudentByCourseId(courseId);
    }

    @Override
    public boolean updateSelective(Selectedcourse selectedcourse) {
        return 1==selectedcourseMapper.updateSelective(selectedcourse);
    }

    @Override
    public boolean select(Integer studentid,Integer courseid) {
        Selectedcourse selectedcourse = new Selectedcourse();
        selectedcourse.setStudentid(studentid);
        selectedcourse.setCourseid(courseid);
        return 1==selectedcourseMapper.insert(selectedcourse);
    }

    @Override
    public boolean unselect( Integer studentid,Integer courseid) {
        return 1==selectedcourseMapper.delete(courseid,studentid);
    }
}
