package com.system.controller;

import com.system.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @Autowired
    private LogService logService;

    @RequestMapping(value = "login")
    public String  loginHandle(String username , String password, Model model){
        if(logService.login(username,password)) {
            model.addAttribute("username",username);
            return "students.jsp";
        }
        else
            return "redirect:loginPage";
    }

    @RequestMapping(value = "loginPage")
    public String loginPage(){
        return "loginPage.jsp";
    }
}
