package com.system.controller;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.system.entity.*;
import com.system.mapper.CollegeMapper;
import com.system.service.CollegeService;
import com.system.service.CourseService;
import com.system.service.SelectedcourseService;
import com.system.service.StudentService;
import com.system.util.SetModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
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

    @Autowired
    private SelectedcourseService selectedcourseService;

    @Autowired
    private SetModel setModel;

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/courses")
    public String courses(Model model, @RequestParam(defaultValue = "1",required = true,value = "page") Integer page, HttpSession session){
        PageHelper.startPage(page,Page.defaultPageSize);

        Teacher teacher =(Teacher)session.getAttribute("user");
        Integer teacherid = teacher.getUserid();

        List<Course> courses = courseService.selectByTeacherId(teacherid);
        //设置分页器
        Page topage = Page.pageElementByHelper(courses,prefix+"/courses?");
        setModel.setDataModel(model, courses,"courses");
        setModel.setPageModel(model,topage);
        setModel.setLinkModel(model,prefix);
        setModel.setCollegesModel(model);
        return "/teacher/coursesOfTeacher.jsp";
    }

    @RequestMapping(value = "/students")
    public String students(Model model,@RequestParam(defaultValue = "1",required = true,value = "page")Integer page,Integer courseid){
        PageHelper.startPage(page,Page.defaultPageSize);
        List<Selectedcourse> selectedcourses = selectedcourseService.selectStudentByCourseId(courseid);
        Page topage = Page.pageElementByHelper(selectedcourses,prefix+"/students?courseid="+courseid+"&");
        setModel.setDataModel(model,selectedcourses,"selectedcourses");
        setModel.setPageModel(model,topage);
        setModel.setLinkModel(model,prefix);
        return "/teacher/studentOfCourse.jsp";
    }

    @RequestMapping(value = "/markPage")
    public String markPage(Model model,Integer userid,@RequestParam(required = true) Integer courseid){
        model.addAttribute("courseid",courseid);
        model.addAttribute("student",studentService.selectById(userid));
        setModel.setLinkModel(model,prefix);
        return "/teacher/markPage.jsp";
    }

    @RequestMapping(value = "/mark")
    public String mark(Selectedcourse selectedcourse){
        selectedcourseService.updateSelective(selectedcourse);
        return "redirect:students?courseid="+selectedcourse.getCourseid();
    }

    //模糊搜索
    @RequestMapping(value = "/search")
    public String search(Model model, @RequestParam(defaultValue = "1",required = true,value = "page")Integer page,String word,HttpSession session){
        PageHelper.startPage(page,Page.defaultPageSize);

        Teacher teacher =(Teacher)session.getAttribute("user");
        Integer teacherid = teacher.getUserid();
        List<Course> courses = courseService.selectByTeacherIdSearch(teacherid,word);
        //设置分页器
        Page topage = Page.pageElementByHelper(courses,prefix+"/courses?");
        setModel.setDataModel(model, courses,"courses");
        setModel.setPageModel(model,topage);
        setModel.setLinkModel(model,prefix);
        setModel.setCollegesModel(model);
        return "/teacher/coursesOfTeacher.jsp";
    }


}
