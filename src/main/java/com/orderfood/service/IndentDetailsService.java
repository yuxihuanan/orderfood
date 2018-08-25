package com.orderfood.service;

import com.orderfood.pojo.OrderfoodIndentDetails;

import java.util.List;

public interface IndentDetailsService {

    /**
     * 通过相应的订单编号
     * @return
     */
    List<OrderfoodIndentDetails> getDetail(String tableId);
}
