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
     * 根据id修改关联员工角色为服务员
     * @param roleid
     * @return
     */
    int updEm(int roleid);

    /**
     * 删除角色时同时重置属于该角色的角色为服务员
     * @param roleid
     * @return
     */
    int delAndUpd(@Param(value = "roleid")int roleid);

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

    /**
     * 查询全部角色
     * @return
     */
    List<OrderfoodEmployeeRole> selAll();
}
