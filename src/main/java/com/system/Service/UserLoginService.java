package com.system.service;

import com.system.entity.Course;
import com.system.entity.Page;
import com.system.entity.Student;
import com.system.entity.Userlogin;

import java.util.List;

public interface UserloginService {

    public boolean add(Userlogin userlogin);

    public boolean delete(Integer userid);

    Userlogin selectById(Integer userid);

    boolean update(Userlogin userlogin);

    public boolean login(String username , String password);

    Userlogin selectByUsername(String username);

    Integer getPageTotal(Integer pageSize);

    List<Userlogin> selectByPage(Page page);

    Integer getSearchPageTotal(String word, Integer pageSize);

    List<Userlogin> searchByPage(String word, Page topage);

    boolean reset(Integer userid);

    boolean changePassword(Integer userid, String password, String newPassword);
}
