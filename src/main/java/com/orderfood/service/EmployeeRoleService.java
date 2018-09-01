package com.orderfood.service;


import com.orderfood.pojo.OrderfoodEmployeeRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRoleService {
    /**
     * 查询角色信息
     * @return
     */
    List<OrderfoodEmployeeRole> getAllRo();

    /**
     * 根据id删除角色信息
     * @param roleid
     * @return
     */
    int delRo(int roleid);

    /**
     * 添加角色信息
     * @param orderfoodEmployeeRole
     * @return
     */
    int addRo(OrderfoodEmployeeRole orderfoodEmployeeRole);

    /**
     * 修改角色信息
     * @param orderfoodEmployeeRole
     */
    int updRo(OrderfoodEmployeeRole orderfoodEmployeeRole);

    /**
     * 根据id查询角色信息
     * @param roleid
     * @return
     */
    OrderfoodEmployeeRole selRo(Integer roleid);
}
