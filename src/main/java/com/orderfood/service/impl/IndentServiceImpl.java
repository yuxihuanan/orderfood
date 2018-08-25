package com.orderfood.service.impl;

import com.orderfood.mapper.OrderfoodIndentMapper;
import com.orderfood.pojo.OrderfoodIndent;
import com.orderfood.service.IndentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndentServiceImpl implements IndentService {

    @Autowired
    private OrderfoodIndentMapper orderfoodIndentMapper;

    public List<OrderfoodIndent> getAll(){
        return orderfoodIndentMapper.selectAll();
    }
}
