package com.orderfood.service.impl;

import com.orderfood.pojo.OrderfoodEmployeeRole;
import com.orderfood.service.EmployeeRoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeRoleServiceImpl implements EmployeeRoleService {
    @Autowired
    private EmployeeRoleService employeeRoleService;
    @Override
    public Integer InsertEmployeeRole(OrderfoodEmployeeRole role) {
        return employeeRoleService.InsertEmployeeRole(role);
    }

    @Override
    public Integer UpdateEmployeeRole(OrderfoodEmployeeRole role) {
        return employeeRoleService.UpdateEmployeeRole(role);
    }

    @Override
    public Integer DeleteEmployeeRole(Integer roleId) {
        return employeeRoleService.DeleteEmployeeRole(roleId);
    }

    @Override
    public List<OrderfoodEmployeeRole> SelectEmployeeRole(OrderfoodEmployeeRole role) {
        return employeeRoleService.SelectEmployeeRole(role);
    }
}
