package com.yang.shopping.controller;


import com.yang.shopping.domain.OrderRecord;
import com.yang.shopping.service.OrderRecordService;
import com.yang.shopping.utils.OrderRecordData;
import com.yang.shopping.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/admin/order")
public class OrderController {
    @Autowired
    private OrderRecordService orderRecordService;

    @RequestMapping()
    public String main(){
        return "order-list";
    }
    @PostMapping("/list")
    @ResponseBody
    public OrderRecordData list(OrderRecord orderRecord)
    {
        return orderRecordService.selectRecordList(orderRecord);
    }
    @GetMapping(value = "/list")
    @ResponseBody
    public OrderRecordData list(OrderRecord orderRecord,int page,int limit) throws UnsupportedEncodingException {
        if (orderRecord.getRid()!=null){
            return orderRecordService.selectRecordList(orderRecord);
        }
        return orderRecordService.selectRecordListByPage(page,limit);
    }
    @RequestMapping("/del")
    @ResponseBody
    public Status userDel(int[] rids){
        System.out.println(rids);
        int success = orderRecordService.deleteRecordByRids(rids);
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
}
