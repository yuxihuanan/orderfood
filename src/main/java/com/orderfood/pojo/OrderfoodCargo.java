package com.orderfood.pojo;

import javax.persistence.Transient;
import java.io.Serializable;

/**
 * 库存表实体类
 */
public class OrderfoodCargo implements Serializable {
    private Integer cargoid;//库物编号

    private Integer cStockid;//原料id

    private Float cargoprice;//每个单位价格

    private Float cargoweight;//重量
    private Float weightCount;//总重量

    public Float getWeightCount() {
        return weightCount;
    }

    public void setWeightCount(Float weightCount) {
        this.weightCount = weightCount;
    }

    @Transient
    private OrderfoodStock stock;//原料表

    public OrderfoodStock getStock() {
        return stock;
    }

    public void setStock(OrderfoodStock stock) {
        this.stock = stock;
    }

    public OrderfoodCargo(Integer cargoid, Integer cStockid, Float cargoprice, Float cargoweight) {
        this.cargoid = cargoid;
        this.cStockid = cStockid;
        this.cargoprice = cargoprice;
        this.cargoweight = cargoweight;
    }

    public OrderfoodCargo() {
        super();
    }

    public Integer getCargoid() {
        return cargoid;
    }

    public void setCargoid(Integer cargoid) {
        this.cargoid = cargoid;
    }

    public Integer getcStockid() {
        return cStockid;
    }

    public void setcStockid(Integer cStockid) {
        this.cStockid = cStockid;
    }

    public Float getCargoprice() {
        return cargoprice;
    }

    public void setCargoprice(Float cargoprice) {
        this.cargoprice = cargoprice;
    }

    public Float getCargoweight() {
        return cargoweight;
    }

    public void setCargoweight(Float cargoweight) {
        this.cargoweight = cargoweight;
    }
}