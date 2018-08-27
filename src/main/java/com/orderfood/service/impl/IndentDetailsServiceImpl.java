package com.orderfood.service.impl;

import com.orderfood.mapper.IndentDetailsMapper;
import com.orderfood.pojo.OrderfoodIndentDetails;
import com.orderfood.service.IndentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndentDetailsServiceImpl implements IndentDetailsService {

    @Autowired
    private IndentDetailsMapper indentDetailsMapper;

    /**
     * 根据tableId获得所有的在此桌的订单，并根据日期拿到最新的订单
     * @param tableId
     * @return
     */
    @Override
    public List<OrderfoodIndentDetails> getDetail(String tableId) {
        return indentDetailsMapper.getDetail(tableId);
    }

    /**
     * 根据所传入的OrderfoodIndentDetails对象对其进行更新
     * @param orderfoodIndentDetails
     * @return
     */
    @Override
    public int updateDetails(OrderfoodIndentDetails orderfoodIndentDetails) {
        return indentDetailsMapper.updateDetails(orderfoodIndentDetails);
    }

    /**
     * 根据所传入的id删除订单详情表中的id
     * @param detailsId
     * @return
     */
    @Override
    public int deleteDetaiils(int detailsId) {
        return indentDetailsMapper.deleteDetaiils(detailsId);
    }

    /**
     * 添加订单详情
     * @param orderfoodIndentDetails
     * @return
     */
    @Override
    public int addDetails(OrderfoodIndentDetails orderfoodIndentDetails) {
        return indentDetailsMapper.addDetails(orderfoodIndentDetails);
    }
}
