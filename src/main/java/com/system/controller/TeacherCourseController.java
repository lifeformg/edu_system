package com.system.controller;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.system.entity.College;
import com.system.entity.Course;
import com.system.entity.Page;
import com.system.entity.Student;
import com.system.mapper.CollegeMapper;
import com.system.service.CollegeService;
import com.system.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/teacher/course")
public class TeacherCourseController {
    static String prefix = "/teacher/course";

    @Autowired
    private CourseService courseService;

    @Autowired
    private CollegeService collegeService;

    @RequestMapping(value = "/courses")
    public String courses(Model model,@RequestParam(defaultValue = "1",required = true,value = "page") Integer page){
        PageHelper.startPage(page,Page.defaultPageSize);

        Integer __debug_sesion_userid = 1001;
        List<Course> courses = courseService.selectByTeacherId(__debug_sesion_userid);
        PageInfo<Course> pageInfo = new PageInfo<>(courses);

        //设置分页器
        Page topage = Page.pageElement(pageInfo.getPageNum(), pageInfo.getPages(),prefix+"/courses?");

        setModel(model, topage, courses);

        return "/coursesOfTeacher.jsp";
    }

    private void setModel(Model model, Page topage, List<Course> courses) {
        model.addAttribute("courses",courses);
        model.addAttribute("page",topage);
        model.addAttribute("prefix",prefix);

        List<College> collegeList = collegeService.selectAllCollege();
        Map<Integer, College> colleges = new HashMap<>();
        for (College college:collegeList
        ) {
            colleges.put(college.getCollegeid(),college);
        }
        model.addAttribute("colleges",colleges);
    }
}
