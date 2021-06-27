package com.system.controller;

import com.system.entity.*;
import com.system.service.CollegeService;
import com.system.service.StudentService;
import com.system.service.UserloginService;
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

@RequestMapping(value = "/admin/userlogin")
@Controller
public class AdminUserloginController {

    @Autowired
    private UserloginService userloginService;

    static String prefix="/admin/userlogin";

    //返回非管理员用户列表
    @RequestMapping(value = "/userlogins")
    public String students(Model model, Integer page){
        Page topage = Page.pageElement(page,userloginService.getPageTotal(Page.defaultPageSize),prefix+"/userlogins?");
        List<Userlogin> userlogins = userloginService.selectByPage(topage);
        setModel(model, topage, userlogins);
        return "/admin/userlogins.jsp";
    }

    //重置非管理用户密码
    @RequestMapping(value = "/reset")
    public String reset(Integer userid){
        userloginService.reset(userid);
        return "redirect:userlogins";
    }

    //模糊搜索
    @RequestMapping(value = "/search")
    public String search(Model model, Integer page,String word){

        Page topage = Page.pageElement(page,userloginService.getSearchPageTotal(word,Page.defaultPageSize),prefix+"/search?word="+word);

        List<Userlogin> userlogins = userloginService.searchByPage(word,topage);
        setModel(model, topage, userlogins);
        return "/admin/userlogins.jsp";
    }



    private void setModel(Model model, Page topage, List<Userlogin> userlogins) {
        model.addAttribute("userlogins",userlogins);
        model.addAttribute("page",topage);
        model.addAttribute("prefix",prefix);
    }
}
