package com.yang.shopping.service.Impl;


import com.yang.shopping.domain.Admin;
import com.yang.shopping.mapper.AdminMapper;
import com.yang.shopping.service.AdminService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    public AdminServiceImpl() {
    }

    public List<Admin> selectAdminList(Admin admin) {
        return this.adminMapper.selectAdminList(admin);
    }

    public List<Admin> selectAdminByLogin(Admin admin) {
        return this.adminMapper.selectAdminByLogin(admin);
    }
}
