package com.orderfood.service.impl;

import com.orderfood.mapper.EmployeeRodeMapper;
import com.orderfood.pojo.OrderfoodEmployeeRole;
import com.orderfood.service.EmployeeRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("employeeRoleService")
public class EmployeeRoleServiceImpl implements EmployeeRoleService {

    @Autowired
    private EmployeeRodeMapper employeeRodeMapper;

    @Override
    public List<OrderfoodEmployeeRole> getAllRo() {
        return employeeRodeMapper.getAllRo();
    }

    @Override
    public int delRo(int roleid) {
        return employeeRodeMapper.delRo(roleid);
    }

    @Override
    public int addRo(OrderfoodEmployeeRole orderfoodEmployeeRole) {
        return employeeRodeMapper.addRo(orderfoodEmployeeRole);
    }

    @Override
    public int updRo(OrderfoodEmployeeRole orderfoodEmployeeRole) {
        return employeeRodeMapper.updRo(orderfoodEmployeeRole);
    }


    @Override
    public OrderfoodEmployeeRole selRo(Integer roleid) {
        return employeeRodeMapper.selRo(roleid);
    }
}
