package com.system.util;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.system.entity.College;
import com.system.entity.Page;
import com.system.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SetModel {
    @Autowired
    private CollegeService collegeService;

    public <E> void setDataModel(Model model,List<E> list, String paraName) {
        model.addAttribute(paraName,list);
    }

    public void setPageModel(Model model,Page page){
        model.addAttribute("page",page);
    }

    public void setLinkModel(Model model,String prefix){
        model.addAttribute("prefix",prefix);
    }

    public void setCollegesModel(Model model) {
        List<College> collegeList = collegeService.selectAllCollege();
        Map<Integer, College> colleges = new HashMap<>();
        for (College college:collegeList
        ) {
            colleges.put(college.getCollegeid(),college);
        }
        model.addAttribute("colleges",colleges);
    }
}
