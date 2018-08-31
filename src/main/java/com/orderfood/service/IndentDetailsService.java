package com.orderfood.service;

import com.orderfood.pojo.OrderfoodIndent;
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
     * @param orderfoodIndentDetails
     * @return
     */
    int deleteDetaiils(OrderfoodIndentDetails orderfoodIndentDetails);

    /**
     * 添加订单详情
     * @param orderfoodIndentDetails
     * @return
     */
    int addDetails(OrderfoodIndentDetails orderfoodIndentDetails);

    /**
     * 通过桌号，获得订单的信息
     * @return
     */
    OrderfoodIndent getDetailByTableId(String tableId);

    /**
     * 下单时生成一个订单
     * @param orderfoodIndent
     * @return
     */
    int addIndent(OrderfoodIndent orderfoodIndent);

    /**
     * 查询该订单号的订单编号
     * @param indentCode
     * @return
     */
    int getDetailsIdByIndentCode(String indentCode);

    /**
     * 当订单为空时删除该订单
     * @param indentid
     * @return
     */
    int deleteIndent(int indentid);
}
