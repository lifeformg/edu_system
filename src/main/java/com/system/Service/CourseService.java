package com.system.service;

import com.system.entity.Page;
import com.system.entity.Course;

import java.util.List;

public interface CourseService {

    boolean delete(Integer userid);

    boolean add(Course course);

    Course selectById(Integer userid);

    boolean update(Course course);

    Integer getPageTotal(Integer pageSize);

    List<Course> selectByPage(Page page);

    Integer getSearchPageTotal(String word, Integer pageSize);

    List<Course> searchByPage(String word, Page topage);

    List<Course> selectByTeacherId(Integer teacherid);
}
