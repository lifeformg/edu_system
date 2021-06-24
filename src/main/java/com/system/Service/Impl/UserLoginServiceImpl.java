package com.system.service.impl;

import com.system.entity.Page;
import com.system.entity.Student;
import com.system.service.UserloginService;
import com.system.entity.Userlogin;
import com.system.mapper.UserloginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserloginServiceImpl implements UserloginService {

    @Autowired
    private UserloginMapper userloginMapper;

    @Override
    public boolean login(String username,String password){
        Userlogin userlogin = new Userlogin();
        userlogin.setUsername(username);
        userlogin.setPassword(password);
        return userloginMapper.selectByLogin(userlogin)!=null;
    }

    @Override
    public boolean add(Userlogin userlogin) {
        return 1==userloginMapper.insertSelective(userlogin);
    }

    @Override
    public boolean delete(Integer userid) {
        return 1==userloginMapper.deleteByPrimaryKey(userid);
    }

    @Override
    public Userlogin selectByUsername(String username) {
        return userloginMapper.selectByUsername(username);
    }

    @Override
    public Userlogin selectById(Integer userid) {
        return userloginMapper.selectByPrimaryKey(userid);
    }

    @Override
    public boolean update(Userlogin userlogin) {
        return 1==userloginMapper.updateByPrimaryKeySelective(userlogin);
    }

    @Override
    public Integer getPageTotal(Integer pageSize) {
        Integer total = userloginMapper.getTotal();
        return (int)Math.ceil((double)total/pageSize);
    }

    @Override
    public List<Userlogin> selectByPage(Page page) {
        page.calPageIndex();
        return userloginMapper.selectByPage(page);
    }

    @Override
    public Integer getSearchPageTotal(String word, Integer pageSize) {
        Integer total = userloginMapper.getSearchTotal(word);
        return (int)Math.ceil((double)total/pageSize);
    }

    @Override
    public List<Userlogin> searchByPage(String word, Page page) {
        page.calPageIndex();
        return userloginMapper.searchByPage(word,page);
    }

    @Override
    public boolean reset(Integer userid) {
        String defaultPassword = "123";
        Userlogin userlogin = new Userlogin();
        userlogin.setUserid(userid);
        userlogin.setPassword(defaultPassword);
        return 1==userloginMapper.updateByPrimaryKeySelective(userlogin);
    }

    @Override
    public boolean changePassword(Integer userid, String password, String newPassword) {
        Userlogin userlogin = userloginMapper.selectByPrimaryKey(userid);
        if(!userlogin.getPassword().equals(password))
            return false;
        userlogin.setPassword(newPassword);
        return 1==userloginMapper.updateByPrimaryKeySelective(userlogin);
    }
}
