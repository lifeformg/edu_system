package com.system.mapper;

import com.system.entity.College;

import java.util.List;

public interface CollegeMapper {
    int deleteByPrimaryKey(Integer collegeid);

    int insert(College record);

    int insertSelective(College record);

    College selectByPrimaryKey(Integer collegeid);

    int updateByPrimaryKeySelective(College record);

    int updateByPrimaryKey(College record);

    List<College> selectAllCollege();
}