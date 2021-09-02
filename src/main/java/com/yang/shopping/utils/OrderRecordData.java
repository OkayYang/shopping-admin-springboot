package com.yang.shopping.utils;

import com.yang.shopping.domain.OrderRecord;

import java.util.List;

public class OrderRecordData {
    private int code;
    private String msg;
    private int count;
    private List<OrderRecord> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<OrderRecord> getData() {
        return data;
    }

    public void setData(List<OrderRecord> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "OrderRecordData{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }
}
