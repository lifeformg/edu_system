package com.system.controller;

import com.github.pagehelper.PageHelper;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.system.entity.*;
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
import java.util.List;

@Controller
@RequestMapping(value = "/student/course")
public class StudentCourseController {
    static String prefix = "/student/course";

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

    @RequestMapping(value = "/allCourses")
    public String allCourses(Model model, @RequestParam(defaultValue = "1",required = true,value = "page") Integer page, HttpSession session){
        PageHelper.startPage(page,Page.defaultPageSize);

        Student student =(Student)session.getAttribute("user");
        Integer studentid = student.getUserid();

        List<Course> courses = courseService.selectByStudentIdAll(studentid);

        Page topage = Page.pageElementByHelper(courses,prefix+"/allCourses?");
        setModel.setDataModel(model, courses,"courses");
        setModel.setPageModel(model,topage);
        setModel.setLinkModel(model,prefix);
        setModel.setCollegesModel(model);
        return "/student/allCourses.jsp";
    }

    @RequestMapping(value = "/selectedCourses")
    public String selectedCourses(Model model,@RequestParam(defaultValue = "1",required = true,value = "page") Integer page,HttpSession session){
        PageHelper.startPage(page,Page.defaultPageSize);

        Student student =(Student)session.getAttribute("user");
        Integer studentid = student.getUserid();

        List<Course> courses = courseService.selectByStudentIdSelected(studentid);

        Page topage = Page.pageElementByHelper(courses,prefix+"/selectedCourses?");
        setModel.setDataModel(model, courses,"courses");
        setModel.setPageModel(model,topage);
        setModel.setLinkModel(model,prefix);
        setModel.setCollegesModel(model);
        return "/student/selectedCourses.jsp";
    }

    @RequestMapping(value = "/doneCourses")
    public String doneCourses(Model model,@RequestParam(defaultValue = "1",required = true,value = "page") Integer page,HttpSession session){
        PageHelper.startPage(page,Page.defaultPageSize);

        Student student =(Student)session.getAttribute("user");
        Integer studentid = student.getUserid();

        List<Course> courses = courseService.selectByStudentIdDone(studentid);

        Page topage = Page.pageElementByHelper(courses,prefix+"/doneCourses?");
        setModel.setDataModel(model, courses,"courses");
        setModel.setPageModel(model,topage);
        setModel.setLinkModel(model,prefix);
        setModel.setCollegesModel(model);
        return "/student/doneCourses.jsp";
    }

    @RequestMapping(value = "/select")
    public String select(Integer courseid,HttpSession session){

        Student student =(Student)session.getAttribute("user");
        Integer studentid = student.getUserid();

        selectedcourseService.select(studentid,courseid);

        return "redirect:"+prefix+"/selectedCourses";
    }

    @RequestMapping(value = "/unselect")
    public String unselect(Integer courseid,HttpSession session){

        Student student =(Student)session.getAttribute("user");
        Integer studentid = student.getUserid();

        selectedcourseService.unselect(studentid,courseid);

        return "redirect:"+prefix+"/selectedCourses";
    }

}
