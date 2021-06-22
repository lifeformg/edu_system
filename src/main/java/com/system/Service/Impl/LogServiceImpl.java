package com.system.service.impl;

import com.system.service.LogService;
import com.system.entity.Userlogin;
import com.system.mapper.UserloginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private UserloginMapper userloginMapper;

    public boolean login(String username,String password){
        Userlogin userlogin = new Userlogin();
        userlogin.setUsername(username);
        userlogin.setPassword(password);
        return userloginMapper.selectByLogin(userlogin)!=null;
    }
}
