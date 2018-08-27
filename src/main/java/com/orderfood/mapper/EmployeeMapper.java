package com.orderfood.mapper;

import com.orderfood.pojo.OrderfoodEmployee;
import com.orderfood.pojo.OrderfoodStaffRole;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("employeeMapper")
public interface EmployeeMapper extends CommonMapper<OrderfoodEmployee> {
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
    void updEm(OrderfoodEmployee orderfoodEmployee);

    /**
     * 根据id查询员工信息
     * @param employeeid
     * @return
     */
    int selEm(int employeeid);
}
