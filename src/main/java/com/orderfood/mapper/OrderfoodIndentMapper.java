package com.orderfood.mapper;

import com.orderfood.pojo.OrderfoodIndent;
import com.orderfood.pojo.OrderfoodIndentDetails;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 订单查询删除
 */

@Repository
public interface OrderfoodIndentMapper extends CommonMapper<OrderfoodIndent> {
    /**
     *查询全部信息表 三表连查 订单 选桌 服务员
     */
    List<OrderfoodIndent> getAll();

    /**
     * 根据所传入的订单id删除所选订单信息
     * @param indentId
     * @return
     */
    Integer delIndent(@Param("indentId")Integer indentId);

    /**
     * 根据订单号查询订单信息
     * @param indentId
     * @return
     */
    List<OrderfoodIndent>getInfo(@Param("indentId") Integer indentId);

    /**
     * 根据订单号查询订单详情
     * @param d_intdentId
     * @return
     */
    List<OrderfoodIndentDetails> getDetails(@Param("id")Integer d_intdentId);

    int delesc(List<Object> obj);

    /**
     * 当前页的数据
     * @param Start
     * @param Size
     * @return
     */
    List<OrderfoodIndentDetails> indentPage(@Param(value = "Start") Integer Start, @Param(value = "Size") Integer Size);

    /**
     * 查询数据总条数
     * @return
     */
    Integer indentCount();

}
