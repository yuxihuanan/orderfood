package com.orderfood.pojo;

import java.io.Serializable;

/**
 * 订单详情
 */
public class OrderfoodIndentDetails implements Serializable {
    private Integer detailsid;//订单详情编号

    private Integer dCuisineid;//菜品编号

    private Integer detailscount;//菜品数量

    private Integer dIndentid;//订单编号

    public OrderfoodIndentDetails(Integer detailsid, Integer dCuisineid, Integer detailscount, Integer dIndentid) {
        this.detailsid = detailsid;
        this.dCuisineid = dCuisineid;
        this.detailscount = detailscount;
        this.dIndentid = dIndentid;
    }

    public OrderfoodIndentDetails() {
        super();
    }

    public Integer getDetailsid() {
        return detailsid;
    }

    public void setDetailsid(Integer detailsid) {
        this.detailsid = detailsid;
    }

    public Integer getdCuisineid() {
        return dCuisineid;
    }

    public void setdCuisineid(Integer dCuisineid) {
        this.dCuisineid = dCuisineid;
    }

    public Integer getDetailscount() {
        return detailscount;
    }

    public void setDetailscount(Integer detailscount) {
        this.detailscount = detailscount;
    }

    public Integer getdIndentid() {
        return dIndentid;
    }

    public void setdIndentid(Integer dIndentid) {
        this.dIndentid = dIndentid;
    }
}