package com.orderfood.pojo;

import java.io.Serializable;

/**
 * 员工角色表实体类
 */
public class OrderfoodStaffRole implements Serializable {
    private Integer roleid;//角色编号

    private Integer employeeid;//员工编号

    public OrderfoodStaffRole(Integer roleid, Integer employeeid) {
        this.roleid = roleid;
        this.employeeid = employeeid;
    }

    public OrderfoodStaffRole() {
        super();
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Integer employeeid) {
        this.employeeid = employeeid;
    }
}