package com.system.service.impl;

import com.system.entity.Page;
import com.system.entity.Course;
import com.system.entity.Userlogin;
import com.system.mapper.CourseMapper;
import com.system.service.CourseService;
import com.system.service.UserloginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private UserloginService userloginService;


    @Override
    public Integer getSearchPageTotal(String word, Integer pageSize) {
        Integer total = courseMapper.getSearchTotal(word);
        return (int)Math.ceil((double)total/pageSize);
    }

    @Override
    public List<Course> searchByPage(String word, Page page) {
        page.calPageIndex();
        return courseMapper.searchByPage(word,page);
    }

    @Override
    public Integer getPageTotal(Integer pageSize){
        Integer total = courseMapper.getTotal();
        return (int)Math.ceil((double)total/pageSize);
    }

    @Override
    public List<Course> selectByPage(Page page) {
        page.calPageIndex();
        return courseMapper.selectByPage(page);
    }

    @Override
    public boolean delete(Integer userid) {
        return 1==courseMapper.deleteByPrimaryKey(userid);
    }

    @Override
    public boolean add(Course course) {
        if(courseMapper.selectByPrimaryKey(course.getCourseid())!=null)
            return false;
        return 1==courseMapper.insertSelective(course);
    }

    @Override
    public Course selectById(Integer userid) {
        return courseMapper.selectByPrimaryKey(userid);
    }

    @Override
    public boolean update(Course course) {
        return 1==courseMapper.updateByPrimaryKeySelective(course);
    }

    @Override
    public List<Course> selectByTeacherId(Integer teacherid) {
        return courseMapper.selectByTeacherId(teacherid);
    }

    @Override
    public List<Course> selectByTeacherIdSearch(Integer teacherid, String word) {
        return courseMapper.selectByTeacherIdSearch(teacherid,word);
    }

    @Override
    public List<Course> selectByStudentIdAll(Integer studentid) {
        return courseMapper.selectByStudentIdAll(studentid);
    }

    @Override
    public List<Course> selectByStudentIdSelected(Integer studentid) {
        return courseMapper.selectByStudentIdSelected(studentid);
    }

    @Override
    public List<Course> selectByStudentIdDone(Integer studentid) {
        return courseMapper.selectByStudentIdDone(studentid);
    }
}
