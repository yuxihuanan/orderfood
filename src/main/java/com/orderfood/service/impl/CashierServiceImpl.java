package com.orderfood.service.impl;

import com.orderfood.mapper.OrderFoodTableMapper;
import com.orderfood.pojo.OrderfoodIndentDetails;
import com.orderfood.pojo.OrderfoodMenu;
import com.orderfood.pojo.OrderfoodTable;
import com.orderfood.service.CashierService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("cashierService")
public class CashierServiceImpl implements CashierService {
    @Autowired
    private OrderFoodTableMapper orderFoodTableMapper;
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
    public List<OrderfoodMenu> getOrderfoodMenuAll() {
        return null;
    }

    @Override
    public Integer PlaceOrder(OrderfoodIndentDetails indentDetails) {
        return null;
    }

    @Override
    public Integer UpdateOrder(OrderfoodIndentDetails indentDetails) {
        return null;
    }
}
