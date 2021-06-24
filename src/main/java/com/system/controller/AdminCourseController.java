package com.system.controller;

import com.system.entity.College;
import com.system.entity.Page;
import com.system.entity.Course;
import com.system.service.CollegeService;
import com.system.service.CourseService;
import com.system.service.TeacherService;
import com.system.util.DateFormer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "/admin/course")
@Controller
public class AdminCourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CollegeService collegeService;

    @Autowired
    private TeacherService teacherService;

    static String prefix="/admin/course";

    //返回学生信息
    @RequestMapping(value = "/courses")
    public String courses(Model model, Integer page){
        Page topage = Page.pageElement(page,courseService.getPageTotal(Page.defaultPageSize),prefix+"/courses?");
        List<Course> courses = courseService.selectByPage(topage);
        setModel(model, topage, courses);
        return "/courses.jsp";
    }

    //删除学生
    @RequestMapping(value = "/delete")
    public String delete(@RequestParam Integer courseid){
        courseService.delete(courseid);
        return "redirect:courses";
    }

    //添加页面
    @RequestMapping(value = "/courseAddPage")
    public String addPage(Model model){
        model.addAttribute("colleges",collegeService.selectAllCollege());
        model.addAttribute("prefix",prefix);
        model.addAttribute("teachers",teacherService.selectAllTeacher());
        return "/courseAddPage.jsp";
    }

    //添加学生
    @RequestMapping(value = "/add")
    public String add(Course course){
        courseService.add(course);
        return "redirect:courses";
    }

    //修改页面
    @RequestMapping(value = "/courseUpdatePage")
    public String updatePage(Integer courseid,Model model){
        model.addAttribute("colleges",collegeService.selectAllCollege());
        Course course = courseService.selectById(courseid);
        model.addAttribute("course", course);
        model.addAttribute("prefix",prefix);
        model.addAttribute("teachers",teacherService.selectAllTeacher());
        return "/courseUpdatePage.jsp";
    }

    //修改学生
    @RequestMapping(value = "/update")
    public String update(Course course){
        courseService.update(course);
        return "redirect:courses";
    }

    //模糊搜索
    @RequestMapping(value = "/search")
    public String search(Model model, Integer page,String word){
        Page topage = Page.pageElement(page,courseService.getSearchPageTotal(word,Page.defaultPageSize),prefix+"/search?word="+word);
        List<Course> courses = courseService.searchByPage(word,topage);
        setModel(model, topage, courses);
        return "/courses.jsp";
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
