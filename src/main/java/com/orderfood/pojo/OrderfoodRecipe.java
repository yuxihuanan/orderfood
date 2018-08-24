package com.orderfood.pojo;

import java.io.Serializable;

/**
 * 配方表实体类
 */
public class OrderfoodRecipe implements Serializable {
    private Integer rRecipeid;//配方编号

    private String recipecontent;//配方声明

    private Integer rStockid;//原料id

    private Float recipeweight;//配料剂量

    private Integer rCuisineid;//菜品id

    public OrderfoodRecipe(Integer rRecipeid, String recipecontent, Integer rStockid, Float recipeweight, Integer rCuisineid) {
        this.rRecipeid = rRecipeid;
        this.recipecontent = recipecontent;
        this.rStockid = rStockid;
        this.recipeweight = recipeweight;
        this.rCuisineid = rCuisineid;
    }

    public OrderfoodRecipe() {
        super();
    }

    public Integer getrRecipeid() {
        return rRecipeid;
    }

    public void setrRecipeid(Integer rRecipeid) {
        this.rRecipeid = rRecipeid;
    }

    public String getRecipecontent() {
        return recipecontent;
    }

    public void setRecipecontent(String recipecontent) {
        this.recipecontent = recipecontent == null ? null : recipecontent.trim();
    }

    public Integer getrStockid() {
        return rStockid;
    }

    public void setrStockid(Integer rStockid) {
        this.rStockid = rStockid;
    }

    public Float getRecipeweight() {
        return recipeweight;
    }

    public void setRecipeweight(Float recipeweight) {
        this.recipeweight = recipeweight;
    }

    public Integer getrCuisineid() {
        return rCuisineid;
    }

    public void setrCuisineid(Integer rCuisineid) {
        this.rCuisineid = rCuisineid;
    }
}