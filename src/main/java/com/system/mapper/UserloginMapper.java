package com.system.mapper;

import com.system.entity.Page;
import com.system.entity.Student;
import com.system.entity.Userlogin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserloginMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(Userlogin record);

    int insertSelective(Userlogin record);

    Userlogin selectByPrimaryKey(Integer userid);

    Userlogin selectByLogin(Userlogin userlogin);

    int updateByPrimaryKeySelective(Userlogin record);

    int updateByPrimaryKey(Userlogin record);

    Userlogin selectByUsername(String username);

    Integer getTotal();

    List<Userlogin> selectByPage(Page page);

    Integer getSearchTotal(String word);

    List<Userlogin> searchByPage(@Param("word")String word, @Param("page")Page page);
}