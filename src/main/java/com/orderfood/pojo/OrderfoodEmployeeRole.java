package com.orderfood.pojo;

import java.io.Serializable;

/**
 * 角色表实体类
 */
public class OrderfoodEmployeeRole implements Serializable {
    private Integer roleid;//角色编号

    private String rolename;//角色名称

    public OrderfoodEmployeeRole(Integer roleid, String rolename) {
        this.roleid = roleid;
        this.rolename = rolename;
    }

    public OrderfoodEmployeeRole() {
        super();
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }
}