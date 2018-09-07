package com.orderfood.service;


import com.orderfood.pojo.OrderfoodStock;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 原料管理Service接口
 */
public interface StockService {
    /**
     * 新增原料
     * @param stock
     * @return
     */
    public Integer InsertStock(OrderfoodStock stock);

    /**
     * 修改原料
     * @param stock
     * @return
     */
    public Integer UpdateStock(OrderfoodStock stock);

    /**
     * 删除原料
     * @param stockId
     * @return
     */
    public Integer DeleteStock(Integer stockId);

    /**
     * 查询原料
     * @param stock
     * @return
     */
    public List<OrderfoodStock> SelectStock(OrderfoodStock stock);

    /**
     * 根据原料名称查询
     * @param stock
     * @return
     */
    public List<OrderfoodStock> SelectStockName(OrderfoodStock stock);

    /**
     * 删除
     * @param id
     * @return
     */
    public int del(int id);

    /**
     * 按原料名称模糊查询
     * @param stockName
     * @return
     */
    public List<OrderfoodStock> getInfo(@Param("stockName") String stockName);

    /**
     * 按id查询
     * @param id
     * @return
     */
    public OrderfoodStock getId(@Param("id") int id);

    /**
     * 批量删除
     */
    public int delesc(List<Object> obj);


    /**
     * 当前页的数据
     * @param Start
     * @param Size
     * @return
     */
    List<OrderfoodStock> stockPage(@Param(value = "Start") Integer Start, @Param(value = "Size") Integer Size);
    /**
     * 查询数据总条数
     * @return
     */
    Integer stockCont();
}
