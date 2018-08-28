package com.orderfood.service;

import com.orderfood.pojo.OrderfoodEmployee;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 员工管理Service接口
 */
@Repository
public interface EmployeeService {
    /**
     * 查询全部的员工信息
     * @return
     */
    List<OrderfoodEmployee> getAllEm();

    /**
     * 根据员工编号删除员工
     * @param employeeid
     * @return
     */
    int delEm(int employeeid);

    /**
     * 添加员工
     * @param orderfoodEmployee
     * @return
     */
    int addEm(OrderfoodEmployee orderfoodEmployee);

    /**
     * 修改员工信息
     * @param orderfoodEmployee
     */
    int updEm(OrderfoodEmployee orderfoodEmployee);

    /**
     * 根据id查询员工信息
     * @param employeeid
     * @return
     */
    int selEm(int employeeid);
}
