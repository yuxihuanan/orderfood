package com.orderfood.dao;

import com.orderfood.pojo.OrderfoodEmployeeRole;

import java.util.List;

/**
 * 角色管理Dao接口
 */
public interface EmployeeRoleDao {
    /**
     * 新增角色
     * @param role
     * @return
     */
    public Integer InsertEmployeeRole(OrderfoodEmployeeRole role);

    /**
     * 修改角色
     * @param role
     * @return
     */
    public Integer UpdateEmployeeRole(OrderfoodEmployeeRole role);

    /**
     * 删除角色
     * @param roleId
     * @return
     */
    public Integer DeleteEmployeeRole(Integer roleId);

    /**
     * 查询角色
     * @param role
     * @return
     */
    public List<OrderfoodEmployeeRole> SelectEmployeeRole(OrderfoodEmployeeRole role);
}
