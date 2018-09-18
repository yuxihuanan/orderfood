package com.orderfood.service.impl;

import com.orderfood.mapper.CuisineMapper;
import com.orderfood.mapper.OrderFoodTableMapper;
import com.orderfood.mapper.OrderfoodTableCuisineMapper;
import com.orderfood.pojo.*;
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

    @Override
    public Integer updateDingDan(Integer indentId) {
        return orderFoodTableMapper.updateDingDan(indentId);
    }

    @Override
    public List<OrderfoodIndent> getDinDan() {
        return orderFoodTableMapper.getDindan();
    }

    @Override
    public List<OrderfoodIndentDetails> getDinDanXiangQin(Integer id) {
        return orderFoodTableMapper.getDinDanXiangQin(id);
    }
}
