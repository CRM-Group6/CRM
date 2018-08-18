package com.crm.deeplearning.representation;

/**
 * Created by JackKo
 * 2018/8/17 10:40
 **/
public class SaleAmountData {
    private String date; // date

    private double saleMoney; // close price


    public SaleAmountData() {}

    public SaleAmountData(String date, double saleMoney) {
        this.date = date;
        this.saleMoney = saleMoney;

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getSaleMoney() {
        return saleMoney;
    }

    public void setSaleMoney(double saleMoney) {
        this.saleMoney = saleMoney;
    }
}