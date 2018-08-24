package com.orderfood.dao;

import com.orderfood.pojo.OrderfoodIndentDetails;
import com.orderfood.pojo.OrderfoodTable;

import java.util.List;

/**
 * 收银Dao接口
 */
public interface CashierDao {
    /**
     * 查看所有桌号
     * @return
     */
    public List<OrderfoodTable> getAllTable();

    /**
     * 选桌
     * @param tableId
     * @return
     */
    public Integer Choosetable(Integer tableId);

    /**
     * 下单
     * @param indentDetails
     * @return
     */
    public Integer PlaceOrder(OrderfoodIndentDetails indentDetails);

    /**
     * 修改订单
     * @param indentDetails
     * @return
     */
    public Integer UpdateOrder(OrderfoodIndentDetails indentDetails);
}
