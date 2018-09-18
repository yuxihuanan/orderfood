package com.orderfood.mapper;

import com.orderfood.pojo.NoOrder;
import com.orderfood.pojo.OrderfoodIndent;
import com.orderfood.pojo.OrderfoodIndentDetails;
import com.orderfood.pojo.OrderfoodTable;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("orderFoodTableMapper")
public interface OrderFoodTableMapper extends CommonMapper<OrderfoodTable> {
    List<NoOrder> getNoOrder(@Param("list") List<Object> list);
    Integer updateDingDan(@Param("indentId") Integer indentId);
    List<OrderfoodIndent> getDindan();
    List<OrderfoodIndentDetails> getDinDanXiangQin(@Param("id") Integer id);
}
