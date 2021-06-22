package com.system.service;

import com.system.entity.Page;
import com.system.entity.Student;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import sun.text.normalizer.IntTrie;

import java.util.List;

public interface StudentService {
    Integer getPageTotal(Integer pageSize);

    List<Student> selectByPage(Page page);

    boolean delete(Integer userid);

    boolean add(Student student);
}
