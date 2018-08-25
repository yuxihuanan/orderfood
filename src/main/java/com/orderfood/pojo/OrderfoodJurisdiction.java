package com.orderfood.pojo;

import java.io.Serializable;

/**
 * 权限表实体类
 */
public class OrderfoodJurisdiction implements Serializable {
    private Integer jRoleid;//角色编号

    private Integer jClassifyid;//导航编号

    private OrderfoodMenu classify;//导航对象

    private OrderfoodEmployeeRole role;//角色对象

    public OrderfoodMenu getClassify() {
        return classify;
    }

    public void setClassify(OrderfoodMenu classify) {
        this.classify = classify;
    }

    public OrderfoodEmployeeRole getRole() {
        return role;
    }

    public void setRole(OrderfoodEmployeeRole role) {
        this.role = role;
    }

    public OrderfoodJurisdiction(Integer jRoleid, Integer jClassifyid) {
        this.jRoleid = jRoleid;
        this.jClassifyid = jClassifyid;
    }

    public OrderfoodJurisdiction() {
        super();
    }

    public Integer getjRoleid() {
        return jRoleid;
    }

    public void setjRoleid(Integer jRoleid) {
        this.jRoleid = jRoleid;
    }

    public Integer getjClassifyid() {
        return jClassifyid;
    }

    public void setjClassifyid(Integer jClassifyid) {
        this.jClassifyid = jClassifyid;
    }
}