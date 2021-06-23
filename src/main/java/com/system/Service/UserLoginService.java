package com.system.service;

import com.system.entity.Userlogin;

public interface UserloginService {
    public boolean login(String username , String password);

    public boolean add(Userlogin userlogin);
}
