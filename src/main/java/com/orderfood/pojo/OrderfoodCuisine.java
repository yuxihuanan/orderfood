package com.orderfood.pojo;

import javax.persistence.Transient;
import java.io.Serializable;

/**
 * 菜品表实体类
 */
public class OrderfoodCuisine implements Serializable {
    private Integer cuisineid;//菜品编号

    private String cuisinename;//菜名

    private Float price;//价格

    private String cuisineacronym;//首字母缩写

    private Integer cuisineidentify;//菜品标识

    private Integer cClassifyid;//所属菜品分类

    @Transient
    private Integer count=0;// 小程序所需

    @Transient
    private OrderfoodCuisineClassify classify; //菜品分类



    public OrderfoodCuisineClassify getClassify() {
        return classify;
    }

    public void setClassify(OrderfoodCuisineClassify classify) {
        this.classify = classify;
    }

    private String picture;//图片

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public OrderfoodCuisine(Integer cuisineid, String cuisinename, Float price, String cuisineacronym, Integer cuisineidentify, Integer cClassifyid,OrderfoodCuisineClassify classify) {
        this.cuisineid = cuisineid;
        this.cuisinename = cuisinename;
        this.price = price;
        this.cuisineacronym = cuisineacronym;
        this.cuisineidentify = cuisineidentify;
        this.cClassifyid = cClassifyid;
        this.classify = classify;
    }

    public OrderfoodCuisine() {
        super();
    }

    public Integer getCuisineid() {
        return cuisineid;
    }

    public void setCuisineid(Integer cuisineid) {
        this.cuisineid = cuisineid;
    }

    public String getCuisinename() {
        return cuisinename;
    }

    public void setCuisinename(String cuisinename) {
        this.cuisinename = cuisinename == null ? null : cuisinename.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getCuisineacronym() {
        return cuisineacronym;
    }

    public void setCuisineacronym(String cuisineacronym) {
        this.cuisineacronym = cuisineacronym == null ? null : cuisineacronym.trim();
    }

    public Integer getCuisineidentify() {
        return cuisineidentify;
    }

    public void setCuisineidentify(Integer cuisineidentify) {
        this.cuisineidentify = cuisineidentify;
    }

    public Integer getcClassifyid() {
        return cClassifyid;
    }

    public void setcClassifyid(Integer cClassifyid) {
        this.cClassifyid = cClassifyid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
