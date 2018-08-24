package com.orderfood.service;

import com.orderfood.pojo.OrderfoodEmployee;

import java.util.List;

/**
 * 员工管理Service接口
 */
public interface EmployeeService {
    /**
     * 新增员工
     * @param employee
     * @return
     */
    public Integer InsertEmployee(OrderfoodEmployee employee);

    /**
     * 修改员工
     * @param employee
     * @return
     */
    public Integer UpdateEmployee(OrderfoodEmployee employee);

    /**
     * 删除员工
     * @param employeeId
     * @return
     */
    public Integer DeleteEmployee(Integer employeeId);

    /**
     * 查询员工
     * @param employee
     * @return
     */
    public List<OrderfoodEmployee> SelectEmployee(OrderfoodEmployee employee);
}
