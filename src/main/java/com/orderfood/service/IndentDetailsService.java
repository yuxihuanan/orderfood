package com.orderfood.service;

import com.orderfood.pojo.OrderfoodIndentDetails;

import java.util.List;

public interface IndentDetailsService {

    /**
     * 通过相应的订单编号
     * @return
     */
    List<OrderfoodIndentDetails> getDetail(String tableId);

    /**
     * 根据所传入的OrderfoodIndentDetails对象对其进行更新
     * @param orderfoodIndentDetails
     * @return
     */
    int updateDetails(OrderfoodIndentDetails orderfoodIndentDetails);

    /**
     * 根据所传入的id删除订单详情表中的id
     * @param detailsId
     * @return
     */
    int deleteDetaiils(int detailsId);

    /**
     * 添加订单详情
     * @param orderfoodIndentDetails
     * @return
     */
    int addDetails(OrderfoodIndentDetails orderfoodIndentDetails);
}
