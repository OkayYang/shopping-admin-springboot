package com.yang.shopping.controller;

import com.yang.shopping.domain.Good;
import com.yang.shopping.service.GoodService;
import com.yang.shopping.utils.GoodData;
import com.yang.shopping.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@Controller
@RequestMapping("/admin/good")
public class GoodController {
    @Autowired
    private GoodService goodService;

    @GetMapping()
    public String main(){
        return "good-list";
    }

    @PostMapping("/list")
    @ResponseBody
    public GoodData list(Good good)
    {
        return goodService.selectGoodsList(good);
    }
    @GetMapping(value = "/list")
    @ResponseBody
    public GoodData list(Good good,int page,int limit) throws UnsupportedEncodingException {
        if (good.getGname()!=null){
            good.setGname(new String(good.getGname().getBytes("ISO-8859-1"), "utf-8"));
            return goodService.selectGoodsList(good);
        }

        return goodService.selectGoodsByPage(page,limit);
    }
    @PostMapping("/edit")
    @ResponseBody
    public Status goodEdit(@RequestBody Good good){
        int success = goodService.updateGoods(good);
        Status status = new Status();
        if (success==1){
            status.setStatus(200);
            status.setMessage("修改成功!");
        }else {
            status.setStatus(404);
            status.setMessage("修改失败，请联系管理员!");
        }
        return status;
    }
    @RequestMapping("/del")
    @ResponseBody
    public Status goodDel(int[] ids){

        int success = goodService.deleteGoodsByIds(ids);
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

    @PostMapping("/add")
    @ResponseBody
    public Status goodAdd(@RequestBody Good good){
        int success = goodService.insertGoods(good);
        Status status = new Status();
        if (success==1){
            status.setStatus(200);
            status.setMessage("添加成功!");
        }else {
            status.setStatus(404);
            status.setMessage("添加失败失败，请联系管理员!");
        }
        return status;
    }
    @RequestMapping("/add-good")
    public String addHome(){
        return "good-add";
    }
}
