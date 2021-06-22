package com.system.mapper;

import com.system.entity.Userlogin;

public interface UserloginMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(Userlogin record);

    int insertSelective(Userlogin record);

    Userlogin selectByPrimaryKey(Integer userid);

    Userlogin selectByLogin(Userlogin userlogin);

    int updateByPrimaryKeySelective(Userlogin record);

    int updateByPrimaryKey(Userlogin record);
}