package com.orderfood.service.impl;

import com.orderfood.pojo.OrderfoodEmployeeRole;
import com.orderfood.service.EmployeeRoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeRoleServiceImpl implements EmployeeRoleService {
    @Autowired
    private EmployeeRoleService employeeRoleService;

    @Override
    public List<OrderfoodEmployeeRole> getAllRo() {
        return employeeRoleService.getAllRo();
    }

    @Override
    public int delRo(int roleid) {
        return employeeRoleService.delRo(roleid);
    }

    @Override
    public int addRo(OrderfoodEmployeeRole orderfoodEmployeeRole) {
        return employeeRoleService.addRo(orderfoodEmployeeRole);
    }

    @Override
    public int updRo(OrderfoodEmployeeRole orderfoodEmployeeRole) {
        try {
            employeeRoleService.updRo(orderfoodEmployeeRole);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }
}
