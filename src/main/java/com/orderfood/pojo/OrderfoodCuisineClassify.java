package com.orderfood.pojo;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

/**
 * 菜品分类实体类
 */
public class OrderfoodCuisineClassify implements Serializable {
    private Integer classifyid;//分类编号

    private String classifyname;//分了名称

    @Transient
    private List<OrderfoodCuisine> cuss;//菜品集合

    private String suoxie;//缩写

    public OrderfoodCuisineClassify(Integer classifyid, String classifyname) {
        this.classifyid = classifyid;
        this.classifyname = classifyname;
    }

    public OrderfoodCuisineClassify() {
        super();
    }

    public Integer getClassifyid() {
        return classifyid;
    }

    public void setClassifyid(Integer classifyid) {
        this.classifyid = classifyid;
    }

    public String getClassifyname() {
        return classifyname;
    }

    public void setClassifyname(String classifyname) {
        this.classifyname = classifyname == null ? null : classifyname.trim();
    }

    public List<OrderfoodCuisine> getCuss() {
        return cuss;
    }

    public void setCuss(List<OrderfoodCuisine> cuss) {
        this.cuss = cuss;
    }

    public String getSuoxie() {
        return suoxie;
    }

    public void setSuoxie(String suoxie) {
        this.suoxie = suoxie;
    }
}