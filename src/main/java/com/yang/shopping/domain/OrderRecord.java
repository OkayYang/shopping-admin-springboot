package com.yang.shopping.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class OrderRecord {
    private Long rid;
    private String uname;
    private String gname;
    private int num;
    private double price;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:sss",timezone = "GMT+8")
    private Date dateTime;

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "OrderRecord{" +
                "rid=" + rid +
                ", uname='" + uname + '\'' +
                ", gname='" + gname + '\'' +
                ", num=" + num +
                ", price=" + price +
                ", dateTime=" + dateTime +
                '}';
    }
}
