package com.orderfood.service.impl;

import com.orderfood.mapper.CuisineMapper;
import com.orderfood.mapper.OrderFoodTableMapper;
import com.orderfood.mapper.OrderfoodTableCuisineMapper;
import com.orderfood.pojo.NoOrder;
import com.orderfood.pojo.OrderfoodCuisine;
import com.orderfood.pojo.OrderfoodIndentDetails;
import com.orderfood.pojo.OrderfoodTable;
import com.orderfood.service.CashierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("cashierService")
public class CashierServiceImpl implements CashierService {
    @Autowired
    private OrderFoodTableMapper orderFoodTableMapper;
    @Autowired
    private CuisineMapper cuisineMapper;
    @Override
    /**
     * 查看所有桌号
     * @return
     */
    public List<OrderfoodTable> getAllTable() {
        return orderFoodTableMapper.selectAll();
    }

    /**
     * 选桌
     * @param
     * @return
     */
    public Integer Choosetable(OrderfoodTable orderfoodTable) {
        return orderFoodTableMapper.updateByPrimaryKey(orderfoodTable);
    }
    /**
     * 查看菜品
     * @return
     */
    @Override
    public List<OrderfoodCuisine> getOrderfoodCuisineAll() {
        return cuisineMapper.selectAll();
    }

    @Override
    public Integer PlaceOrder(OrderfoodIndentDetails indentDetails) {
        return null;
    }

    @Override
    public Integer UpdateOrder(OrderfoodIndentDetails indentDetails) {
        return null;
    }

    @Override
    public List<NoOrder> getNoOrder(List<Object> list) {
        return orderFoodTableMapper.getNoOrder(list);
    }
}
