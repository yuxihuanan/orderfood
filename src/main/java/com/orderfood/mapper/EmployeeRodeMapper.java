package com.orderfood.mapper;

import com.orderfood.pojo.OrderfoodEmployee;
import com.orderfood.pojo.OrderfoodEmployeeRole;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface EmployeeRodeMapper extends CommonMapper<OrderfoodEmployee> {
    /**
     * 查询全部角色
     * @return
     */
    List<OrderfoodEmployeeRole> getAllRo();

    /**
     * 根据id删除角色
     * @param roleid
     * @return
     */
    int delRo(int roleid);

    /**
     * 添加角色
     * @param orderfoodEmployeeRole
     * @return
     */
    int addRo(OrderfoodEmployeeRole orderfoodEmployeeRole);

    /**
     * 修改角色
     * @param orderfoodEmployeeRole
     */
    void updRo(OrderfoodEmployeeRole orderfoodEmployeeRole);
}
