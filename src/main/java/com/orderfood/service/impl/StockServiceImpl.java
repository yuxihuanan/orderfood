package com.orderfood.service.impl;

import com.orderfood.mapper.StockMapper;
import com.orderfood.pojo.OrderfoodStock;
import com.orderfood.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("stockService")
public class StockServiceImpl implements StockService {


    @Autowired
    private StockMapper stockMapper;

    @Override
    public Integer InsertStock(OrderfoodStock stock) {
        return stockMapper.selectCountByExample(stock);
    }

    @Override
    public Integer UpdateStock(OrderfoodStock stock) {
        return stockMapper.updateByPrimaryKey(stock);
    }

    @Override
    public Integer DeleteStock(Integer stockId) {
        return stockMapper.deleteByExample(stockId);
    }

    @Override
    public List<OrderfoodStock> SelectStock(OrderfoodStock stock) {
        return stockMapper.selectAll();
    }
}
