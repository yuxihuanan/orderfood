package com.orderfood.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 桌位表实体类
 */
@Table(name = "orderfood_table")
public class OrderfoodTable implements Serializable {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tableId")
    private Integer tableid;//桌位编号
    /**
     * 用户名
     */
    @Column(name = "tableNumber")
    private Integer tablenumber;//桌位号
    /**
     * 用户名
     */
    @Column(name = "tableStatus")
    private Integer tablestatus;//状态

    public Integer getTablestatus() {
        return tablestatus;
    }

    public void setTablestatus(Integer tablestatus) {
        this.tablestatus = tablestatus;
    }

    public OrderfoodTable(Integer tableid, Integer tablenumber, Integer tablestatus) {
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
}