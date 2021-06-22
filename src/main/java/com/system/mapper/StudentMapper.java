package com.system.mapper;

import com.system.entity.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(Student record);

    int insertSelective(Student record);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}