package com.orderfood.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

/**
 * 收支流水表实体类123
 */
public class OrderfoodRunningData implements Serializable {
    private Integer dataid;//收支编号

    private Float dataprice;//流水钱

    private String datastatement;//声明 收/支
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String createdate;//创建时间
    @Transient  //表示此数据不在数据库表里建立属性
    private String startDate;//开始时间
    @Transient  //表示此数据不在数据库表里建立属性
    private String stopDate;//结束时间
    private String datacomment;//收支明细

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStopDate() {
        return stopDate;
    }

    public void setStopDate(String stopDate) {
        this.stopDate = stopDate;
    }

    public OrderfoodRunningData(Integer dataid, Float dataprice, String datastatement, String createdate, String datacomment) {
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

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public String getDatacomment() {
        return datacomment;
    }

    public void setDatacomment(String datacomment) {
        this.datacomment = datacomment == null ? null : datacomment.trim();
    }
}