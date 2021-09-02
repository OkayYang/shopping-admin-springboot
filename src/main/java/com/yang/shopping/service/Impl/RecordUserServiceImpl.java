package com.yang.shopping.service.Impl;

import com.yang.shopping.domain.RecordUser;
import com.yang.shopping.domain.User;
import com.yang.shopping.mapper.RecordUserMapper;
import com.yang.shopping.mapper.UserMapper;
import com.yang.shopping.service.RecordUserService;
import com.yang.shopping.utils.DelUserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecordUserServiceImpl implements RecordUserService {
    @Autowired
    private RecordUserMapper recordUserMapper;
    @Autowired
    private UserMapper userMapper;

    public RecordUserServiceImpl() {
    }

    public User selectRecordUserByUid(Long uid) {
        return this.recordUserMapper.selectRecordUserByUid(uid);
    }

    public DelUserData selectRecordUserList(RecordUser recordUser) {
        DelUserData userData = new DelUserData();
        userData.setData(this.recordUserMapper.selectRecordUserList(recordUser));
        userData.setCount(this.recordUserMapper.countRecordUser());
        userData.setMsg("");
        userData.setCode(0);
        return userData;
    }

    public DelUserData selectUserListByPage(int page, int limit) {
        DelUserData userData = new DelUserData();
        userData.setData(this.recordUserMapper.selectUserListByPage((page - 1) * limit, limit));
        userData.setCount(this.recordUserMapper.countRecordUser());
        userData.setMsg("");
        userData.setCode(0);
        return userData;
    }

    public int insertRecordUser(RecordUser recordUser) {
        return this.recordUserMapper.insertRecordUser(recordUser);
    }

    public int updateRecordUser(RecordUser recordUser) {
        return this.recordUserMapper.updateRecordUser(recordUser);
    }

    public int deleteRecordUserByUids(int[] uids) {
        return this.recordUserMapper.deleteRecordUserByUids(uids);
    }

    public int deleteRecordUserByUid(Long uid) {
        return this.recordUserMapper.deleteRecordUserByUid(uid);
    }

    @Transactional
    public boolean recoverUser(Long uid) {
        User user = null;
        user = this.recordUserMapper.selectRecordUserByUid(uid);
        this.userMapper.insertUser(user);
        this.recordUserMapper.deleteRecordUserByUid(uid);
        return true;
    }

    public int countRecordUser() {
        return this.recordUserMapper.countRecordUser();
    }
}
