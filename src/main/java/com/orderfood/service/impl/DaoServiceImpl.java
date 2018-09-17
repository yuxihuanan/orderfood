package com.orderfood.service.impl;

import com.orderfood.mapper.OrderfooddaoMapper;
import com.orderfood.pojo.OrderfoodEmployeeRole;
import com.orderfood.pojo.OrderfoodJurisdiction;
import com.orderfood.pojo.OrderfoodMenu;
import com.orderfood.service.DaoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("daoServiceImpl")
public class DaoServiceImpl implements DaoService {

    @Autowired
    private OrderfooddaoMapper orderfooddaoMapper;
    @Override
    public List<OrderfoodEmployeeRole> getAll() {
        return orderfooddaoMapper.getAll();
    }

    @Override
    public List<OrderfoodMenu> getMen(Integer id) {
        return orderfooddaoMapper.getMen(id);
    }
    @Override
    public List<OrderfoodMenu> getNot(Integer id) {
        return orderfooddaoMapper.getNot(id);
    }
    @Override
    public int del(Integer menuid) {
        return orderfooddaoMapper.del(menuid);
    }

    @Override
    public int insJurisdiction(OrderfoodJurisdiction orderfoodJurisdiction) {
        return orderfooddaoMapper.insJurisdiction(orderfoodJurisdiction);
    }

}
