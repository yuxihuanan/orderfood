package com.orderfood.mapper;

import com.orderfood.pojo.OrderfoodEmployee;
import com.orderfood.pojo.OrderfoodStaffRole;
import org.apache.ibatis.annotations.Param;
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
    OrderfoodEmployee selEm(int employeeid);

    /**
     * 根据姓名条件查
     * @param employeename
     * @return
     */
    List<OrderfoodEmployee> selTwo(@Param("employeename") String employeename);

    /**
     * 批量删除
     * @param objects
     * @return
     */
    int delesc(List<Object> objects);
}
