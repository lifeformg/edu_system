package com.system.mapper;

import com.system.entity.Teacher;

public interface TeacherMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
}