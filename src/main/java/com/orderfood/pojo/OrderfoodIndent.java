package com.orderfood.pojo;

import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 订单表实体类
 */
public class OrderfoodIndent implements Serializable {
    private Integer indentid;//订单编号

    private String indentcode;//订单号

    private Integer iTableid;//所属桌号

    private String createdate;//创建时间

    private String indentcomment;//订单备注

    private Float totalmoney;//订单总金额

    private Integer statu;

    public Integer getStatu() {
        return statu;
    }

    public void setStatu(Integer statu) {
        this.statu = statu;
    }

    @Transient
    private List<OrderfoodIndentDetails> details; //订单详情

    @Transient
    private OrderfoodTable orderfoodTable;//桌台详请

    @Transient
    private OrderfoodEmployee orderfoodEmployee; //员工详请

    @Transient
    private OrderfoodUser orderfoodUser; //用户信息

    private Float netmoney;//实付总金额

    private Integer iEmployeeid;//服务员 员工id

    private Integer userId=0; //客户编号

    public OrderfoodIndent(Integer indentid, String indentcode, Integer iTableid, String createdate, String indentcomment, Float totalmoney, Float netmoney, Integer iEmployeeid) {
        this.indentid = indentid;
        this.indentcode = indentcode;
        this.iTableid = iTableid;
        this.createdate = createdate;
        this.indentcomment = indentcomment;
        this.totalmoney = totalmoney;
        this.netmoney = netmoney;
        this.iEmployeeid = iEmployeeid;
    }

    public OrderfoodIndent() {
        super();
    }

    public Integer getIndentid() {
        return indentid;
    }

    public void setIndentid(Integer indentid) {
        this.indentid = indentid;
    }

    public String getIndentcode() {
        return indentcode;
    }

    public void setIndentcode(String indentcode) {
        this.indentcode = indentcode == null ? null : indentcode.trim();
    }

    public Integer getiTableid() {
        return iTableid;
    }

    public void setiTableid(Integer iTableid) {
        this.iTableid = iTableid;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public String getIndentcomment() {
        return indentcomment;
    }

    public void setIndentcomment(String indentcomment) {
        this.indentcomment = indentcomment == null ? null : indentcomment.trim();
    }

    public Float getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(Float totalmoney) {
        this.totalmoney = totalmoney;
    }

    public Float getNetmoney() {
        return netmoney;
    }

    public void setNetmoney(Float netmoney) {
        this.netmoney = netmoney;
    }

    public Integer getiEmployeeid() {
        return iEmployeeid;
    }

    public void setiEmployeeid(Integer iEmployeeid) {
        this.iEmployeeid = iEmployeeid;
    }

    public List<OrderfoodIndentDetails> getDetails() {
        return details;
    }

    public void setDetails(List<OrderfoodIndentDetails> details) {
        this.details = details;
    }

    public OrderfoodTable getOrderfoodTable() {
        return orderfoodTable;
    }

    public void setOrderfoodTable(OrderfoodTable orderfoodTable) {
        this.orderfoodTable = orderfoodTable;
    }

    public OrderfoodEmployee getOrderfoodEmployee() {
        return orderfoodEmployee;
    }

    public void setOrderfoodEmployee(OrderfoodEmployee orderfoodEmployee) {
        this.orderfoodEmployee = orderfoodEmployee;
    }

    public OrderfoodUser getOrderfoodUser() {
        return orderfoodUser;
    }

    public void setOrderfoodUser(OrderfoodUser orderfoodUser) {
        this.orderfoodUser = orderfoodUser;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}