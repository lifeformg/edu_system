package com.system.controller;

import com.system.entity.College;
import com.system.entity.Page;
import com.system.entity.Teacher;
import com.system.service.CollegeService;
import com.system.service.TeacherService;
import com.system.util.DateFormer;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "/admin/teacher")
@Controller
public class AdminTeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private CollegeService collegeService;

    static String prefix = "/admin/teacher";

    //返回学生信息
    @RequestMapping(value = "/teachers")
    public String teachers(Model model, Integer page){
        Page topage = Page.pageElement(page,teacherService.getPageTotal(Page.defaultPageSize),prefix+"/teachers?");
        List<Teacher> teachers = teacherService.selectByPage(topage);
        setModel(model, topage, teachers);
        return "/teachers.jsp";
    }

    //删除学生
    @RequestMapping(value = "/delete")
    public String delete(@RequestParam Integer userid){
        teacherService.delete(userid);
        return "redirect:teachers";
    }

    //添加页面
    @RequestMapping(value = "/teacherAddPage")
    public String addPage(Model model){
        model.addAttribute("colleges",collegeService.selectAllCollege());
        model.addAttribute("prefix",prefix);
        return "/teacherAddPage.jsp";
    }

    //添加学生
    @RequestMapping(value = "/add")
    public String add(Teacher teacher){
        teacherService.add(teacher);
        return "redirect:teachers";
    }

    //修改页面
    @RequestMapping(value = "/teacherUpdatePage")
    public String updatePage(Integer userid,Model model){
        model.addAttribute("colleges",collegeService.selectAllCollege());
        Teacher teacher = teacherService.selectById(userid);
        model.addAttribute("teacher", teacher);
        teacher.setBirthyearFormed(DateFormer.getDateFormed(teacher.getBirthyear()));
        teacher.setGradeFormed(DateFormer.getDateFormed(teacher.getGrade()));
        model.addAttribute("prefix",prefix);
        return "/teacherUpdatePage.jsp";
    }

    //修改学生
    @RequestMapping(value = "/update")
    public String update(Teacher teacher){
        teacherService.update(teacher);
        return "redirect:teachers";
    }

    //模糊搜索
    @RequestMapping(value = "/search")
    public String search(Model model, Integer page,String word){
        Page topage = Page.pageElement(page,teacherService.getSearchPageTotal(word,Page.defaultPageSize),prefix+"/search?word="+word);
        List<Teacher> teachers = teacherService.searchByPage(word,topage);
        setModel(model, topage, teachers);
        return "/teachers.jsp";
    }

    private void setModel(Model model, Page topage, List<Teacher> students) {
        model.addAttribute("teachers",students);
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
