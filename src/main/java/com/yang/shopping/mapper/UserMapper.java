package com.yang.shopping.mapper;


import com.yang.shopping.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author yang
 * @date 2021-08-12
 */

@Mapper
public interface UserMapper
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
    public List<User> selectUserList(User user);
    public List<User> selectUserListByPage(@Param("page")int page, @Param("limit")int limit);

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
     * 删除【请填写功能名称】
     *
     * @param uid 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteUserByUid(Long uid);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param uids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserByUids(int[] uids);

    int countUser();
}