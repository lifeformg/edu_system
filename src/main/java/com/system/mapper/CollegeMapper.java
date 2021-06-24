package com.system.mapper;

import com.system.entity.College;
import com.system.entity.Course;
import com.system.entity.Page;
import com.system.entity.Student;
import org.apache.ibatis.annotations.Param;

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