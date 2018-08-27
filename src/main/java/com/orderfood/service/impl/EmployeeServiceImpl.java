package com.orderfood.service.impl;

import com.orderfood.mapper.EmployeeMapper;
import com.orderfood.pojo.OrderfoodEmployee;
import com.orderfood.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Integer InsertEmployee(OrderfoodEmployee employee) {
        return null;
    }

    @Override
    public Integer UpdateEmployee(OrderfoodEmployee employee) {
        return null;
    }

    @Override
    public Integer DeleteEmployee(Integer employeeId) {
        return null;
    }

    @Override
    public List<OrderfoodEmployee> SelectEmployee(OrderfoodEmployee employee) {
        return null;
    }
}
