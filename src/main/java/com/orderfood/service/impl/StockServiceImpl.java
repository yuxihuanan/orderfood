package com.orderfood.service.impl;

import com.orderfood.dao.StockDao;
import com.orderfood.pojo.OrderfoodStock;
import com.orderfood.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("stockService")
public class StockServiceImpl implements StockService {

    @Autowired
    private StockDao stockDao;


    @Override
    public Integer InsertStock(OrderfoodStock stock) {
        return stockDao.InsertStock(stock);
    }

    @Override
    public Integer UpdateStock(OrderfoodStock stock) {
        return stockDao.UpdateStock(stock);
    }

    @Override
    public Integer DeleteStock(Integer stockId) {
        return stockDao.DeleteStock(stockId);
    }

    @Override
    public List<OrderfoodStock> SelectStock(OrderfoodStock stock) {
        return stockDao.SelectStock(stock);
    }
}
