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
        return employeeMapper.insertUseGeneratedKeys(employee);
    }

    @Override
    public Integer UpdateEmployee(OrderfoodEmployee employee) {
        return employeeMapper.updateByPrimaryKey(employee);
    }

    @Override
    public Integer DeleteEmployee(Integer employeeId) {
        return employeeMapper.deleteByPrimaryKey(employeeId);
    }

    @Override
    public List<OrderfoodEmployee> SelectEmployee(OrderfoodEmployee employee) {
        return employeeMapper.selectAll();
    }
}
