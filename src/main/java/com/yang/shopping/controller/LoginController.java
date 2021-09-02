package com.yang.shopping.controller;


import com.yang.shopping.domain.Admin;
import com.yang.shopping.service.AdminService;
import com.yang.shopping.utils.Status;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/admin/login")
public class LoginController {
    @Autowired
    AdminService adminService;
    @RequestMapping()
    public String main(){
        return "login";
    }

    @RequestMapping("/exit")
    public String toLogin(HttpServletRequest request){
        request.getSession().invalidate();
        return "login";
    }
    @RequestMapping("/check")
    @ResponseBody
    public Status checkLogin(Admin admin, HttpServletRequest request){
        /*List<Admin> admins = adminService.selectAdminByLogin(admin);
        HttpSession session = request.getSession();
        Status status = new Status();
        if (admins.size()==1){
            status.setStatus(200);
            status.setMessage("登陆成功");
            System.out.println(admins.get(0));
            session.setAttribute("admin",admins.get(0));
        }else {
            status.setStatus(400);
            status.setMessage("账号或密码错误");
        }
        return status;*/
        UsernamePasswordToken token = new UsernamePasswordToken(admin.getName(),admin.getPassword());
        Subject subject = SecurityUtils.getSubject();
        Status status = new Status();
        try
        {
            subject.login(token);
            Session session=subject.getSession();
            session.setAttribute("subject", subject);
            status.setStatus(200);
            status.setMessage("登陆成功");
        }
        catch (AuthenticationException e)
        {
            status.setStatus(400);
            status.setMessage("账号或密码错误");
        }
        return status;
    }
}
