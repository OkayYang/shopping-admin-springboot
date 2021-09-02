package com.yang.shopping.mapper;

import com.yang.shopping.domain.RecordUser;
import com.yang.shopping.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 【请填写功能名称】Mapper接口
 *
 * @author yang
 * @date 2021-08-26
 */

@Mapper
public interface RecordUserMapper
{
    /**
     * 查询【请填写功能名称】
     *
     * @param uid 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public User selectRecordUserByUid(Long uid);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param recordUser 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<RecordUser> selectRecordUserList(RecordUser recordUser);
    public List<RecordUser> selectUserListByPage(@Param("page")int page, @Param("limit")int limit);

    /**
     * 新增【请填写功能名称】
     *
     * @param recordUser 【请填写功能名称】
     * @return 结果
     */
    public int insertRecordUser(RecordUser recordUser);

    /**
     * 修改【请填写功能名称】
     *
     * @param recordUser 【请填写功能名称】
     * @return 结果
     */
    public int updateRecordUser(RecordUser recordUser);

    /**
     * 删除【请填写功能名称】
     *
     * @param uid 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteRecordUserByUid(Long uid);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param uids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRecordUserByUids(int[] uids);

    public int countRecordUser();
}