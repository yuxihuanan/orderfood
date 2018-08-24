package com.orderfood.pojo;

import java.io.Serializable;

public class OrderfoodRecipe implements Serializable {
    private Integer rRecipeid;

    private String recipecontent;

    private Integer rStockid;

    private Float recipeweight;

    private Integer rCuisineid;

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