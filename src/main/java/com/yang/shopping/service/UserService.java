package com.yang.shopping.service;



import com.yang.shopping.domain.User;
import com.yang.shopping.utils.UserData;

import java.util.List;

public interface UserService
{
    /**
     * 查询【请填写功能名称】
     *
     * @param uid 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public User selectUserByUid(Long uid);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param user 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public UserData selectUserList(User user);
    public UserData selectUserListByPage(int page,int limit);

    /**
     * 新增【请填写功能名称】
     *
     * @param user 【请填写功能名称】
     * @return 结果
     */
    public int insertUser(User user);

    /**
     * 修改【请填写功能名称】
     *
     * @param user 【请填写功能名称】
     * @return 结果
     */
    public int updateUser(User user);


    /**
     * 删除【请填写功能名称】信息
     *
     * @param uid 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteUserByUid(Long uid);
    public int deleteUserByUids(int[] uids);

    int countUser();
}