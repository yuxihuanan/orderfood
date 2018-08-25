package com.orderfood.service.impl;

import com.orderfood.dao.LoginDao;
import com.orderfood.mapper.CommonMapper;
import com.orderfood.mapper.LoginMapper;
import com.orderfood.pojo.OrderfoodStaffRole;
import com.orderfood.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("login")
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;
    @Override
    public List<OrderfoodStaffRole> AdminLogin(OrderfoodStaffRole staff) {
        return loginMapper.selectAll();
    }
}
