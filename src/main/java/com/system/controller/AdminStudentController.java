package com.system.controller;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.system.entity.Page;
import com.system.entity.Student;
import com.system.mapper.StudentMapper;
import com.system.service.CollegeService;
import com.system.service.StudentService;
import com.system.util.DateFormer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping(value = "/admin/student")
@Controller
public class AdminStudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CollegeService collegeService;

    static String prefix="/admin/student";

    //返回学生信息
    @RequestMapping(value = "/students")
    public String students(Model model, Integer page){
        if(page == null || page<=0){
            page = 1;
        }

        Integer total = studentService.getPageTotal(Page.defaultPageSize);
        if(page>total)
            page = total;
        Page topage = new Page(page, total,Page.defaultPageSize);
        topage.setJumpLink(prefix+"/students?");
        List<Student> students = studentService.selectByPage(topage);
        model.addAttribute("students",students);
        model.addAttribute("page",topage);
        model.addAttribute("prefix",prefix);
        return "/students.jsp";
    }

    //删除学生
    @RequestMapping(value = "/delete")
    public String delete(@RequestParam Integer userid){
        studentService.delete(userid);
        return "redirect:students";
    }

    //添加页面
    @RequestMapping(value = "/studentAddPage")
    public String addPage(Model model){
        model.addAttribute("colleges",collegeService.selectAllCollege());
        model.addAttribute("prefix",prefix);
        return "/studentAddPage.jsp";
    }

    //添加学生
    @RequestMapping(value = "/add")
    public String add(Student student){
        studentService.add(student);
        return "redirect:students";
    }

    //修改页面
    @RequestMapping(value = "/studentUpdatePage")
    public String updatePage(Integer userid,Model model){
        model.addAttribute("colleges",collegeService.selectAllCollege());
        Student student = studentService.selectById(userid);
        model.addAttribute("student", student);
        student.setBirthyearFormed(DateFormer.getDateFormed(student.getBirthyear()));
        student.setGradeFormed(DateFormer.getDateFormed(student.getGrade()));
        model.addAttribute("prefix",prefix);
        return "/studentUpdatePage.jsp";
    }

    //修改学生
    @RequestMapping(value = "/update")
    public String update(Student student){
        studentService.update(student);
        return "redirect:students";
    }

    //模糊搜索
    @RequestMapping(value = "/search")
    public String search(Model model, Integer page,String word){
        if(page == null || page<=0){
            page = 1;
        }
        if(word == null)
            word = "";

        Integer total = studentService.getSearchPageTotal(word,Page.defaultPageSize);
        if(page>total)
            page = total;
        Page topage = new Page(page, total,Page.defaultPageSize);
        topage.setJumpLink(prefix+"/search?word="+word);
        List<Student> students = studentService.searchByPage(word,topage);
        model.addAttribute("students",students);
        model.addAttribute("page",topage);
        model.addAttribute("prefix",prefix);
        return "/students.jsp";
    }
}
