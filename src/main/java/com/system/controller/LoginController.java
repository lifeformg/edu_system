package com.system.controller;

import com.system.entity.Student;
import com.system.entity.Teacher;
import com.system.entity.Userlogin;
import com.system.service.StudentService;
import com.system.service.TeacherService;
import com.system.service.UserloginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserloginService userloginService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/loginPage")
    public String loginPage(){
        return "/loginfo/loginPage.jsp";
    }

    @RequestMapping(value = "/login")
    public String  loginHandle(String username , String password, Model model, HttpSession session){
        if(userloginService.login(username,password)) {
            Userlogin userlogin = userloginService.selectByUsername(username);
            session.setAttribute("userlogin",userlogin);

            model.addAttribute("username",username);

            if(userlogin.getRole()==1) {
                session.setAttribute("user", teacherService.selectByLoginId(userlogin.getUserid()));
                return "redirect:/teacher/course/courses";
            }
            else if(userlogin.getRole()==2) {
                session.setAttribute("user", studentService.selectByLoginId(userlogin.getUserid()));
                return "redirect:/student/course/allCourses";
            }
            else
                return "redirect:/admin/course/courses";
        }
        else
            return "redirect:loginPage";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session){
        return "redirect:login";
    }

    //修改密码页面
    @RequestMapping(value = "/changePasswordPage")
    public String changePasswordPage(){
        return "/loginfo/changePasswordPage.jsp";
    }

    //修改密码
    @RequestMapping(value = "/changePassword")
    public String changePassword(Integer userid ,String password,String newPassword){
        userloginService.changePassword(userid,password,newPassword);
        return "redirect:changePasswordPage";
    }
}
