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

    /**
     * 查询全部员工
     * @return
     */
    @Override
    public List<OrderfoodEmployee> getAllEm() {
        return employeeMapper.getAllEm();
    }

    /**
     * 根据员工id删除员工
     * @param employeeid
     * @return
     */
    @Override
    public int delEm(int employeeid) {
        return employeeMapper.delEm(employeeid);
    }

    /**
     * 添加员工
     * @param orderfoodEmployee
     * @return
     */
    @Override
    public int addEm(OrderfoodEmployee orderfoodEmployee) {
        return employeeMapper.addEm(orderfoodEmployee);
    }

    /**
     * 实现修改员工数据
     * @param orderfoodEmployee
     * @return
     */
    @Override
    public int updEm(OrderfoodEmployee orderfoodEmployee) {
        try {
            employeeMapper.updEm(orderfoodEmployee);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    /**
     * 根据id查询员工信息
     * @param employeeid
     * @return
     */
    @Override
    public int selEm(int employeeid) {
        return employeeMapper.selEm(employeeid);
    }
}
