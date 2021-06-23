package com.system.mapper;

import com.system.entity.Page;
import com.system.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer userid);

    Student selectByPrimaryKey(Integer userid);

    List<Student> selectByPage(Page page);

    int insert(Student record);

    int insertSelective(Student record);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    Integer getTotal();

    Integer getSearchTotal(String word);

    List<Student> searchByPage(@Param("word")String word,@Param("page")Page page);
}