package com.orderfood.mapper;

import com.orderfood.pojo.OrderfoodIndentDetails;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;


/**
 * 继承自己的MyMapper
 */
@Repository
public interface IndentDetailsMapper extends CommonMapper<OrderfoodIndentDetails> {

    /**
     *根据tableId获得所有的在此桌的订单，并根据日期拿到最新的订单详情
     * @param tableId
     * @return
     */
    List<OrderfoodIndentDetails> getDetail(@Param("tableId") String tableId);

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
    int deleteDetaiils(@Param("detailsId") int detailsId);

    /**
     * 添加订单详情
     * @param orderfoodIndentDetails
     * @return
     */
    int addDetails(OrderfoodIndentDetails orderfoodIndentDetails);
}
