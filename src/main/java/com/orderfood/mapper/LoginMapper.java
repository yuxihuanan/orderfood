package com.orderfood.mapper;

import com.orderfood.pojo.OrderfoodEmployee;
import com.orderfood.pojo.OrderfoodStaffRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("loginMapper")
public interface LoginMapper extends CommonMapper<OrderfoodEmployee> {
    /**
     * 登录方法
     * @param employee
     * @return
     */
    @Select("")
    public List<OrderfoodEmployee> AdminLogin(OrderfoodEmployee employee);
}
