package com.orderfood.pojo;

import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * 订单详情
 */
@Table(name = "orderfood_indent_details")
public class OrderfoodIndentDetails implements Serializable {

    private Integer detailsid;//订单详情编号

    private Integer dCuisineid;//菜品编号

    @Transient
    private OrderfoodIndent indent; //订单

    @Transient
    private orderfoodCuisine cuisine;//菜品编号所对应的菜品信息

    private Integer detailscount;//菜品数量

    private Integer dIndentid;//订单编号

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

   public orderfoodCuisine getCuisine() {
        return cuisine;
    }

    public void setCuisine(orderfoodCuisine cuisine) {
        this.cuisine = cuisine;
    }

    public OrderfoodIndent getIndent() {
        return indent;
    }

    public void setIndent(OrderfoodIndent indent) {
        this.indent = indent;
    }
}