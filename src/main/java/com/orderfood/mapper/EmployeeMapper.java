package com.orderfood.mapper;

import com.orderfood.pojo.OrderfoodEmployee;
import com.orderfood.pojo.OrderfoodStaffRole;
import org.springframework.stereotype.Repository;

@Repository("loginMapper")
public interface EmployeeMapper extends CommonMapper<OrderfoodEmployee> {
}
