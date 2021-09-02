package com.yang.shopping.domain;

public class Welcome {
    private int userNum;
    private int goodNum;
    private Double totalSale;
    private Double todaySale;

    public int getUserNum() {
        return userNum;
    }

    public void setUserNum(int userNum) {
        this.userNum = userNum;
    }

    public int getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(int goodNum) {
        this.goodNum = goodNum;
    }

    public Double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(Double totalSale) {
        this.totalSale = totalSale;
    }

    public Double getTodaySale() {
        return todaySale;
    }

    public void setTodaySale(Double todaySale) {
        this.todaySale = todaySale;
    }

    @Override
    public String toString() {
        return "Welcome{" +
                "userNum=" + userNum +
                ", goodNum=" + goodNum +
                ", totalSale=" + totalSale +
                ", todaySale=" + todaySale +
                '}';
    }
}
