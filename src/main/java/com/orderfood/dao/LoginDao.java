package com.orderfood.dao;


import com.orderfood.pojo.OrderfoodStaffRole;

import java.util.List;

/**
 * 导航、登录Dao接口
 */
public interface LoginDao {
    /**
     * 登录
     * @param staff
     * @return
     */
    public List<OrderfoodStaffRole> AdminLogin(OrderfoodStaffRole staff);
}
