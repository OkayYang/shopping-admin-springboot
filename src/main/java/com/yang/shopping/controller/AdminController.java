package com.yang.shopping.controller;

import com.yang.shopping.domain.Admin;
import com.yang.shopping.domain.Welcome;
import com.yang.shopping.service.GoodService;
import com.yang.shopping.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class AdminController {
    @Autowired
    UserService userService;
    @Autowired
    GoodService goodService;
    @RequestMapping("admin/welcome")
    public String welcomeMain( ModelMap modelMap){
        Subject subject = SecurityUtils.getSubject();
        Admin admin = (Admin) subject.getPrincipal();
        modelMap.put("admin",admin);
        Welcome welcome = new Welcome();
        welcome.setUserNum(userService.countUser());
        welcome.setGoodNum(goodService.countGood());
        welcome.setTotalSale(goodService.totalSale());
        welcome.setTodaySale(goodService.todaySale());
        modelMap.put("data",welcome);
        return "welcome";
    }



    @RequestMapping("/admin/error")

    public String error(){
        return "error";
    }
    @RequestMapping("/admin/unicode")
    public String unicodeIcon(){
        return "unicode";
    }

}
