package com.orderfood.pojo;

import java.io.Serializable;

/**
 * 菜品分类实体类
 */
public class OrderfoodCuisineClassify implements Serializable {
    private Integer classifyid;//分类编号

    private String classifyname;//分了名称

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
}