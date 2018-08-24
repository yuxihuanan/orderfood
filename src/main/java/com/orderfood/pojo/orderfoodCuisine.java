package com.orderfood.pojo;

import java.io.Serializable;

/**
 * 菜品表实体类
 */
public class orderfoodCuisine implements Serializable {
    private Integer cuisineid;//

    private String cuisinename;//

    private Float price;//

    private String cuisineacronym;//

    private Integer cuisineidentify;//

    private Integer cClassifyid;//

    public orderfoodCuisine(Integer cuisineid, String cuisinename, Float price, String cuisineacronym, Integer cuisineidentify, Integer cClassifyid) {
        this.cuisineid = cuisineid;
        this.cuisinename = cuisinename;
        this.price = price;
        this.cuisineacronym = cuisineacronym;
        this.cuisineidentify = cuisineidentify;
        this.cClassifyid = cClassifyid;
    }

    public orderfoodCuisine() {
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
}