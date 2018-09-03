package com.orderfood.service;

import com.orderfood.pojo.OrderfoodIndent;
import com.orderfood.pojo.OrderfoodIndentDetails;
import org.springframework.stereotype.Service;

import java.util.List;
/*
* 查询全部订单
* */
public interface IndentService {
    /**
     *查询全部信息表 三表连查 订单 选桌 服务员
     */
    List<OrderfoodIndent> getAll();

    /**
     * 根据所传入的订单id删除所选订单信息
     * @param indentId
     * @return
     */
    Integer delIndent(Integer indentId);

    /**
     * 根据订单号查询订单信息
     * @param intdentId
     * @return
     */
    List<OrderfoodIndent>getInfo(Integer intdentId);

    /**
     * 根据订单号查询订单详情
     * @param d_indentId
     * @return
     */
    List<OrderfoodIndentDetails> getDetails(Integer d_indentId);

    int delesc(List<Object> obj);
}
