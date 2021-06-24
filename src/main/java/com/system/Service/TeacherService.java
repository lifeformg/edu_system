package com.system.service;

import com.system.entity.Page;
import com.system.entity.Teacher;

import java.util.List;

public interface TeacherService {
    Integer getPageTotal(Integer pageSize);

    List<Teacher> selectByPage(Page page);

    boolean delete(Integer userid);

    boolean add(Teacher teacher);

    Teacher selectById(Integer userid);

    boolean update(Teacher teacher);

    Integer getSearchPageTotal(String word, Integer pageSize);

    List<Teacher> searchByPage(String word, Page topage);

    List<Teacher> selectAllTeacher();
}
