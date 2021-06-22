package com.system.service.impl;

import com.system.entity.College;
import com.system.mapper.CollegeMapper;
import com.system.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeServiceImpl implements CollegeService {

    @Autowired
    private CollegeMapper collegeMapper;

    @Override
    public List<College> selectAllCollege() {
        return collegeMapper.selectAllCollege();
    }
}
