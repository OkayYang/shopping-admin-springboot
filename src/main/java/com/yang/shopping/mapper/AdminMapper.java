package com.yang.shopping.mapper;


import com.yang.shopping.domain.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 【请填写功能名称】Mapper接口
 *
 * @author yang
 * @date 2021-08-06
 */

@Mapper
public interface AdminMapper
{

    public List<Admin> selectAdminList(Admin admin);

    public List<Admin> selectAdminByLogin(Admin admin);
}