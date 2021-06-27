package com.system.mapper;

import com.system.entity.Page;
import com.system.entity.Student;
import com.system.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer userid);

    Student selectByPrimaryKey(Integer userid);

    int insert(Student record);

    int insertSelective(Student record);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    Integer getTotal();

    List<Student> selectByPage(Page page);

    Integer getSearchTotal(String word);

    List<Student> searchByPage(@Param("word")String word,@Param("page")Page page);

    Student selectByLoginId(Integer loginid);
}