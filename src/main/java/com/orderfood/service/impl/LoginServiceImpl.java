package com.orderfood.service.impl;

import com.orderfood.mapper.LoginMapper;
import com.orderfood.pojo.OrderfoodEmployee;
import com.orderfood.pojo.OrderfoodJurisdiction;
import com.orderfood.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;
    /**
     * 登录
     * @param employee
     * @return
     */
    public OrderfoodEmployee AdminLogin(OrderfoodEmployee employee) {
        try {
            if(null!=employee.getUsername() && null!=employee.getPassword()){
                return loginMapper.selectOne(employee);
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
    public List<OrderfoodJurisdiction> GetJurisdiction(Integer roleId) {
            return loginMapper.GetJurisdiction(roleId);
    }
}
