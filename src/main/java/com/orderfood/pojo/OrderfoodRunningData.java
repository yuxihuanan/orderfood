package com.orderfood.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 收支流水表实体类123
 */
public class OrderfoodRunningData implements Serializable {
    private Integer dataid;//收支编号

    private Float dataprice;//流水钱

    private String datastatement;//声明 收/支

    private Date createdate;//创建时间

    private String datacomment;//收支明细

    public OrderfoodRunningData(Integer dataid, Float dataprice, String datastatement, Date createdate, String datacomment) {
        this.dataid = dataid;
        this.dataprice = dataprice;
        this.datastatement = datastatement;
        this.createdate = createdate;
        this.datacomment = datacomment;
    }

    public OrderfoodRunningData() {
        super();
    }

    public Integer getDataid() {
        return dataid;
    }

    public void setDataid(Integer dataid) {
        this.dataid = dataid;
    }

    public Float getDataprice() {
        return dataprice;
    }

    public void setDataprice(Float dataprice) {
        this.dataprice = dataprice;
    }

    public String getDatastatement() {
        return datastatement;
    }

    public void setDatastatement(String datastatement) {
        this.datastatement = datastatement == null ? null : datastatement.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getDatacomment() {
        return datacomment;
    }

    public void setDatacomment(String datacomment) {
        this.datacomment = datacomment == null ? null : datacomment.trim();
    }
}