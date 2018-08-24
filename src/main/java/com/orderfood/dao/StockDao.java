package com.orderfood.dao;

import com.orderfood.pojo.OrderfoodStock;

import java.util.List;

/**
 * 原料管理Dao接口
 */
public interface StockDao {
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
}
