package com.system.service.impl;

import com.system.entity.Page;
import com.system.entity.Student;
import com.system.entity.Userlogin;
import com.system.mapper.StudentMapper;
import com.system.service.StudentService;
import com.system.service.UserloginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private UserloginService userloginService;


    @Override
    public Integer getSearchPageTotal(String word, Integer pageSize) {
        Integer total = studentMapper.getSearchTotal(word);
        return (int)Math.ceil((double)total/pageSize);
    }

    @Override
    public List<Student> searchByPage(String word, Page page) {
        page.calPageIndex();
        return studentMapper.searchByPage(word,page);
    }

    @Override
    public Integer getPageTotal(Integer pageSize){
        Integer total = studentMapper.getTotal();
        return (int)Math.ceil((double)total/pageSize);
    }

    @Override
    public List<Student> selectByPage(Page page) {
        page.calPageIndex();
        return studentMapper.selectByPage(page);
    }

    @Override
    public boolean delete(Integer userid) {
        return 1==studentMapper.deleteByPrimaryKey(userid);
    }

    @Override
    public boolean add(Student student) {
        //这里应修改成一个事务
        Userlogin userlogin = new Userlogin();
        userlogin.setUsername(student.getUserid().toString());
        userlogin.setPassword("123");
        userlogin.setRole(2);
        userloginService.add(userlogin);
        return 1==studentMapper.insertSelective(student);
    }

    @Override
    public Student selectById(Integer userid) {
        return studentMapper.selectByPrimaryKey(userid);
    }

    @Override
    public boolean update(Student student) {
        return 1==studentMapper.updateByPrimaryKeySelective(student);
    }
}
