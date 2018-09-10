package com.orderfood.service.impl;

import com.orderfood.mapper.StockMapper;
import com.orderfood.pojo.OrderfoodStock;
import com.orderfood.service.StockService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service("stockService")
public class StockServiceImpl implements StockService {


    @Autowired
    private StockMapper stockMapper;

    @Override
    public Integer InsertStock(OrderfoodStock stock) {
        System.out.println(stock.getStockunit());
        return stockMapper.InsertStock(stock);
    }

    @Override
    public Integer UpdateStock(OrderfoodStock stock) {
        return stockMapper.UpdateStock(stock);
    }

    @Override
    public Integer DeleteStock(Integer stockId) {
        return stockMapper.deleteByExample(stockId);
    }

    @Override
    public List<OrderfoodStock> SelectStock(OrderfoodStock stock) {
        return stockMapper.selectAll();
    }

    @Override
    public List<OrderfoodStock> SelectStockName(OrderfoodStock stock) {
        return stockMapper.selectByExample(stock);
    }

    @Override
    public int del(int id) {
        return stockMapper.del(id);
    }

    @Override
    public List<OrderfoodStock> getInfo(@Param("stockName") String stockName) {
        return stockMapper.getInfo(stockName);
    }

    @Override
    public OrderfoodStock getId(@Param("id") int id) {
        return stockMapper.getId(id);
    }

    @Override
    @Transactional
    public int delesc(List<Object> obj) throws RuntimeException {

        try {
            Example example=new Example(OrderfoodStock.class);
            example.createCriteria().andIn("stockid",obj);
            stockMapper.deleteByExample(example);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    @Override
    public List<OrderfoodStock> stockPage(String stockName,Integer Start, Integer Size) {
        return stockMapper.stockPage(stockName,Start,Size);
    }

    @Override
    public Integer stockCont(String stockName) {
        return stockMapper.stockCont(stockName);
    }

}
