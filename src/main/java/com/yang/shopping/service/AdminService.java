package com.yang.shopping.service;


import com.yang.shopping.domain.Admin;

import java.util.List;


/**
 * 【请填写功能名称】Service接口
 *
 * @author yang
 * @date 2021-08-06
 */
public interface AdminService {


    /**
     * 查询【请填写功能名称】列表
     *
     * @param admin 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Admin> selectAdminList(Admin admin);



    /**
     * 查询【请填写功能名称】
     *
     * @param admin 【请填写功能名称】登陆信息
     * @return 【请填写功能名称】
     */
    public List<Admin> selectAdminByLogin(Admin admin);
}