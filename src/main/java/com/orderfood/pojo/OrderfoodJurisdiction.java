package com.orderfood.pojo;

import java.io.Serializable;

/**
 * 权限表实体类
 */
public class OrderfoodJurisdiction implements Serializable {
    private Integer jRoleid;//角色编号

    private Integer jClassifyid;//导航编号

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