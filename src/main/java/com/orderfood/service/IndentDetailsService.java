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
     * 通过菜品id为条件让配方表与库存表进行映射，进行删减
     * @param r_cuisineId
     * @return
     */
    int updateStockByRecipeid(Integer r_cuisineId);
}
