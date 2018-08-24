package com.orderfood.service;


import com.orderfood.pojo.OrderfoodStaffRole;

import java.util.List;

/**
 * 导航、登录Service接口
 */
public interface LoginService {
    /**
     * 登录
     * @param staff
     * @return
     */
    public List<OrderfoodStaffRole> AdminLogin(OrderfoodStaffRole staff);
}
