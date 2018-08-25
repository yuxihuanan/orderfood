package com.orderfood.service.impl;

import com.orderfood.mapper.CommonMapper;
import com.orderfood.mapper.LoginMapper;
import com.orderfood.pojo.OrderfoodEmployee;
import com.orderfood.pojo.OrderfoodJurisdiction;
import com.orderfood.pojo.OrderfoodStaffRole;
import com.orderfood.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("login")
public class LoginServiceImpl implements LoginService {

   // @Autowired
   // private CommonMapper<OrderfoodEmployee> commonMapper;
    @Autowired
    private LoginMapper mapper;

    /**
     * 登录方法
     * @param employee
     * @return
     */
    @Override
    public OrderfoodEmployee AdminLogin(OrderfoodEmployee employee) {
        try {
            if (null != employee.getUserName() && null != employee.getPassword()) {
                return mapper.selectOne(employee);
            }
        }catch (Exception e){

        }
        return null;
    }

    /**
     * 权限
     * @param roleId
     * @return
     */
    public OrderfoodJurisdiction GetJurisdiction(Integer roleId) {
        return null;
    }
}
