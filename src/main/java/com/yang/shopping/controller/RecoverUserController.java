package com.yang.shopping.controller;


import com.yang.shopping.domain.RecordUser;
import com.yang.shopping.service.RecordUserService;
import com.yang.shopping.utils.DelUserData;
import com.yang.shopping.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/admin/record")
public class RecoverUserController {
    @Autowired
    private RecordUserService recordUserService;
    @RequestMapping()
    public String main(){
        return "user-del";
    }
    /**
     * 查询【请填写功能名称】列表
     */
    @PostMapping("/list")
    @ResponseBody
    public DelUserData delList(RecordUser user)
    {
        return recordUserService.selectRecordUserList(user);
    }
    @GetMapping("/list")
    @ResponseBody
    public DelUserData delList(RecordUser user,int page,int limit) throws UnsupportedEncodingException {
        if (user.getUname()!=null){
            user.setUname(new String(user.getUname().getBytes("ISO-8859-1"), "utf-8"));

            return recordUserService.selectRecordUserList(user);
        }

        return recordUserService.selectUserListByPage(page,limit);
    }

    @RequestMapping("/del")
    @ResponseBody
    public Status recordDel(int[] uids){

        int success = recordUserService.deleteRecordUserByUids(uids);
        Status status = new Status();
        if (success!=0){
            status.setStatus(200);
            status.setMessage("删除成功!");
        }else {
            status.setStatus(404);
            status.setMessage("删除失败，请联系管理员!");
        }
        return status;
    }
    @RequestMapping("/recover")
    @ResponseBody
    public Status delRecover(Long uid) throws Exception {
        boolean flag = recordUserService.recoverUser(uid);
        Status status = new Status();
        if (flag==true){
            status.setStatus(200);
            status.setMessage("恢复成功!");
        }else {
            status.setStatus(404);
            status.setMessage("恢复失败，请联系管理员!");
        }
        return status;
    }
}
