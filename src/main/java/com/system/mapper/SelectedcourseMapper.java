package com.system.mapper;

import com.system.entity.Selectedcourse;

public interface SelectedcourseMapper {
    int insert(Selectedcourse record);

    int insertSelective(Selectedcourse record);
}