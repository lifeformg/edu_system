package com.system.service.impl;

import com.system.entity.Page;
import com.system.entity.Teacher;
import com.system.entity.Userlogin;
import com.system.mapper.TeacherMapper;
import com.system.service.TeacherService;
import com.system.service.UserloginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private UserloginService userloginService;


    @Override
    public Integer getSearchPageTotal(String word, Integer pageSize) {
        Integer total = teacherMapper.getSearchTotal(word);
        return (int)Math.ceil((double)total/pageSize);
    }

    @Override
    public List<Teacher> searchByPage(String word, Page page) {
        page.calPageIndex();
        return teacherMapper.searchByPage(word,page);
    }

    @Override
    public Integer getPageTotal(Integer pageSize){
        Integer total = teacherMapper.getTotal();
        return (int)Math.ceil((double)total/pageSize);
    }

    @Override
    public List<Teacher> selectByPage(Page page) {
        page.calPageIndex();
        return teacherMapper.selectByPage(page);
    }

    @Override
    public boolean delete(Integer userid) {
        //这里应该修改一个事务
        Userlogin userlogin = userloginService.selectByUsername(userid.toString());
        return 1==teacherMapper.deleteByPrimaryKey(userid) && userloginService.delete(userlogin.getUserid());
    }

    @Override
    public boolean add(Teacher teacher) {
        if(teacherMapper.selectByPrimaryKey(teacher.getUserid())!=null)
            return false;
        //这里应修改成一个事务
        Userlogin userlogin = new Userlogin();
        userlogin.setUsername(teacher.getUserid().toString());
        userlogin.setPassword("123");
        userlogin.setRole(1);
        userloginService.add(userlogin);
        return 1==teacherMapper.insertSelective(teacher);
    }

    @Override
    public Teacher selectById(Integer userid) {
        return teacherMapper.selectByPrimaryKey(userid);
    }

    @Override
    public boolean update(Teacher teacher) {
        return 1==teacherMapper.updateByPrimaryKeySelective(teacher);
    }

    @Override
    public List<Teacher> selectAllTeacher() {
        return teacherMapper.selectAllTeacher();
    }

    @Override
    public Teacher selectByLoginId(Integer loginid) {
        return teacherMapper.selectByLoginId(loginid);
    }
}
