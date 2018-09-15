package com.orderfood.service;


import com.orderfood.pojo.NoOrder;
import com.orderfood.pojo.OrderfoodCuisine;
import com.orderfood.pojo.OrderfoodIndentDetails;
import com.orderfood.pojo.OrderfoodTable;

import java.util.List;

/**
 * 收银Service接口
 */
public interface CashierService {
    /**
     * 查看所有桌号
     * @return
     */
    public List<OrderfoodTable> getAllTable();

    /**
     * 选桌
     * @param OrderfoodTable
     * @return
     */
    public Integer Choosetable(OrderfoodTable OrderfoodTable);

    /**
     * 查看菜品
     * @return
     */
    public List<OrderfoodCuisine> getOrderfoodCuisineAll();

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

    /**
     * 查看是否有原料做菜
     * @param list
     * @return
     */
    public List<NoOrder> getNoOrder(List<Object> list);
}
