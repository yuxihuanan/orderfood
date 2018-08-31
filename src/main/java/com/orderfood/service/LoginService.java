package com.orderfood.service;


import com.orderfood.pojo.OrderfoodEmployee;
import com.orderfood.pojo.OrderfoodJurisdiction;
import com.orderfood.pojo.OrderfoodMenu;
import com.orderfood.pojo.OrderfoodStaffRole;

import java.util.List;

/**
 * 导航、登录Service接口
 */
public interface LoginService {
    /**
     * 登录
     * @param employee
     * @return
     */
    public OrderfoodEmployee AdminLogin(OrderfoodEmployee employee);

    /**
     * 权限分配
     * @param roleId
     * @return
     */
    public List<OrderfoodJurisdiction> GetJurisdiction(Integer roleId);

    /**
     * 查询导航
     * @param menu
     * @return
     */
    public List<OrderfoodMenu> selectMenu(OrderfoodMenu menu);
}
