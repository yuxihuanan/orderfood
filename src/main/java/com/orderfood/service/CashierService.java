package com.orderfood.service;


import com.orderfood.pojo.*;

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

    /**
     * 结账修改订单
     * @param indentId
     * @return
     */
    public Integer updateDingDan(Integer indentId);

    /**
     * 获取订单
     * @return
     */
    public List<OrderfoodIndent> getDinDan();
    /**
     * 查看订单详情
     */
    public List<OrderfoodIndentDetails> getDinDanXiangQin(Integer id);
}
