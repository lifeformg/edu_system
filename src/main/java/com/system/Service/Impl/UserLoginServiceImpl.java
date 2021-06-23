package com.system.service.impl;

import com.system.service.UserloginService;
import com.system.entity.Userlogin;
import com.system.mapper.UserloginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
