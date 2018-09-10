package com.orderfood.service;

import com.orderfood.pojo.OrderfoodCuisineClassify;
import com.orderfood.pojo.OrderfoodIndent;
import com.orderfood.pojo.OrderfoodIndentDetails;
import com.orderfood.pojo.OrderfoodTable;

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
     * 通过订单编号，获得订单的信息
     * @return
     */
    OrderfoodIndent getDetailByTableId(String indentId);

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

    /**
     * 拿到所有的菜品
     * @return
     */
    List<OrderfoodCuisineClassify> getAllClassify(Integer classifyId);

    /**
     * 通过用户手机号获得其所有的订单
     * @param phone
     * @return
     */
    List<OrderfoodIndent> getAllIndentsByPhone(String phone);

    /**
     * 通过手机号查询用户编号
     * @param phone
     * @return
     */
    Integer getUserIdByPhone(String phone);

    /**
     * 得到所有的桌子
     * @return
     */
    List<OrderfoodTable> getAllTables();

    /**
     * 更新桌子的状态
     * @return
     */
    int updateTableStatu(OrderfoodTable orderfoodTable);
}
