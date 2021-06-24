package com.system.controller;

import com.system.entity.College;
import com.system.entity.Page;
import com.system.entity.Student;
import com.system.service.CollegeService;
import com.system.service.StudentService;
import com.system.util.DateFormer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        //设置分页器
        Page topage = Page.pageElement(page, studentService.getPageTotal(Page.defaultPageSize),prefix+"/students?");

        //设置学生列表
        List<Student> students = studentService.selectByPage(topage);
        setModel(model, topage, students);

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

        Page topage = Page.pageElement(page,studentService.getSearchPageTotal(word,Page.defaultPageSize),prefix+"/search?word="+word);

        List<Student> students = studentService.searchByPage(word,topage);
        setModel(model, topage, students);
        return "/students.jsp";
    }

    private void setModel(Model model, Page topage, List<Student> students) {
        model.addAttribute("students",students);
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
