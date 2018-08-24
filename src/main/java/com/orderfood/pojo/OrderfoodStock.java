package com.orderfood.pojo;

import java.io.Serializable;

/**
 * 原料表实体类
 */
public class OrderfoodStock implements Serializable {
    private Integer stockid;//原料编号

    private String stockname;//原料名

    private Float stockweight;//单位数

    private String stockunit;//单位kg/L

    public OrderfoodStock(Integer stockid, String stockname, Float stockweight, String stockunit) {
        this.stockid = stockid;
        this.stockname = stockname;
        this.stockweight = stockweight;
        this.stockunit = stockunit;
    }

    public OrderfoodStock() {
        super();
    }

    public Integer getStockid() {
        return stockid;
    }

    public void setStockid(Integer stockid) {
        this.stockid = stockid;
    }

    public String getStockname() {
        return stockname;
    }

    public void setStockname(String stockname) {
        this.stockname = stockname == null ? null : stockname.trim();
    }

    public Float getStockweight() {
        return stockweight;
    }

    public void setStockweight(Float stockweight) {
        this.stockweight = stockweight;
    }

    public String getStockunit() {
        return stockunit;
    }

    public void setStockunit(String stockunit) {
        this.stockunit = stockunit == null ? null : stockunit.trim();
    }
}