package com.orderfood.mapper;
import com.orderfood.pojo.OrderfoodEmployeeRole;
import com.orderfood.pojo.OrderfoodJurisdiction;
import com.orderfood.pojo.OrderfoodMenu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderfooddaoMapper extends CommonMapper<OrderfoodEmployeeRole> {
    List<OrderfoodEmployeeRole> getAll();//查询所有管理员
    List<OrderfoodMenu> getMen(Integer id);//根据id查询管理员权限
    List<OrderfoodMenu> getNot(Integer id);//根据id查询非管理员权限
    //删除权限
    int del(@Param(value = "j_roleId") Integer j_roleId,@Param(value = "j_classifyId")Integer j_classifyId);
    int insJurisdiction(OrderfoodJurisdiction orderfoodJurisdiction);//添加权限

}
