package com.orderfood.pojo;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * 权限表实体类
 */
@Table(name = "orderfood_jurisdiction")
public class OrderfoodJurisdiction implements Serializable {
    @Column(name = "j_roleId")
    private Integer jRoleid;//角色编号
    @Column(name = "j_classifyId")
    private Integer jClassifyid;//导航编号
    @Transient  //表示此数据不在数据库表里建立属性
    private OrderfoodMenu classify;//导航对象
    @Transient  //表示此数据不在数据库表里建立属性
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