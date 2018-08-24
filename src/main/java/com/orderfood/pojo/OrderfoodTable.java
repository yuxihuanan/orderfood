package com.orderfood.pojo;

import java.io.Serializable;

/**
 * 桌位表实体类
 */
public class OrderfoodTable implements Serializable {
    private Integer tableid;//桌位编号

    private Integer tablenumber;//桌位号

    private String tablestatus;//状态

    public OrderfoodTable(Integer tableid, Integer tablenumber, String tablestatus) {
        this.tableid = tableid;
        this.tablenumber = tablenumber;
        this.tablestatus = tablestatus;
    }

    public OrderfoodTable() {
        super();
    }

    public Integer getTableid() {
        return tableid;
    }

    public void setTableid(Integer tableid) {
        this.tableid = tableid;
    }

    public Integer getTablenumber() {
        return tablenumber;
    }

    public void setTablenumber(Integer tablenumber) {
        this.tablenumber = tablenumber;
    }

    public String getTablestatus() {
        return tablestatus;
    }

    public void setTablestatus(String tablestatus) {
        this.tablestatus = tablestatus == null ? null : tablestatus.trim();
    }
}