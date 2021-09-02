package com.yang.shopping;

import com.yang.shopping.domain.Admin;
import com.yang.shopping.domain.User;
import com.yang.shopping.service.AdminService;
import com.yang.shopping.service.UserService;
import com.yang.shopping.utils.SpringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShoppingApplicationTests {

    @Test
    void contextLoads() {
    }
    @Test
    void listBeans(){

    }
    @Test
    void loginTest(){
        AdminService adminService = (AdminService) SpringUtils.getBean("adminServiceImpl");
        Admin admin = new Admin();
        admin.setName("admin");
        admin.setPassword("1");
        System.out.println(adminService.selectAdminByLogin(admin));
    }
    @Test
    void userList(){
        UserService userService = (UserService) SpringUtils.getBean("userServiceImpl");
        System.out.println(userService.selectUserList(new User()));
    }

}
