package com.orderfood.mapper;

import com.orderfood.pojo.OrderfoodEmployee;
import com.orderfood.pojo.OrderfoodStaffRole;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("employeeMapper")
public interface EmployeeMapper extends CommonMapper<OrderfoodEmployee> {
}
