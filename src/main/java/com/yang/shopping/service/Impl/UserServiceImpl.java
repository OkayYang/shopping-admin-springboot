package com.yang.shopping.service.Impl;

import com.yang.shopping.domain.User;
import com.yang.shopping.mapper.UserMapper;
import com.yang.shopping.service.UserService;
import com.yang.shopping.utils.UserData;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public UserServiceImpl() {
    }

    public User selectUserByUid(Long uid) {
        return this.userMapper.selectUserByUid(uid);
    }

    public UserData selectUserList(User user) {
        UserData userData = new UserData();
        userData.setData(this.userMapper.selectUserList(user));
        userData.setCount(this.userMapper.countUser());
        userData.setMsg("");
        userData.setCode(0);
        return userData;
    }

    public UserData selectUserListByPage(int page, int limit) {
        UserData userData = new UserData();
        userData.setData(this.userMapper.selectUserListByPage((page - 1) * limit, limit));
        userData.setCount(this.userMapper.countUser());
        userData.setMsg("");
        userData.setCode(0);
        return userData;
    }

    public int insertUser(User user) {
        user.setUdate(new Date());
        return this.userMapper.insertUser(user);
    }

    public int updateUser(User user) {
        return this.userMapper.updateUser(user);
    }

    public int deleteUserByUid(Long uid) {
        return this.userMapper.deleteUserByUid(uid);
    }

    public int deleteUserByUids(int[] uids) {
        return this.userMapper.deleteUserByUids(uids);
    }

    public int countUser() {
        return this.userMapper.countUser();
    }
}
