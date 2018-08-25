package com.orderfood.mapper;

import com.orderfood.pojo.OrderfoodStock;
import org.springframework.stereotype.Repository;

@Repository("stockMapper")
public interface StockMapper extends CommonMapper<OrderfoodStock> {
}
