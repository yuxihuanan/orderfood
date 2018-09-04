package com.orderfood.service.impl;


import com.orderfood.mapper.EmployeeRodeMapper;
import com.orderfood.pojo.OrderfoodCuisineClassify;
import com.orderfood.service.CuisineClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.orderfood.mapper.CuisinrifyMapper;

import javax.annotation.Resource;
import java.util.List;

@Service("cuisineClassifyService")
public class CuisineClassifyServiceImpl implements CuisineClassifyService {

    @Autowired
    private CuisinrifyMapper cuisineClassifyMapper;

    @Override
    public Integer InsertCuisineClassify(OrderfoodCuisineClassify classify) {
        return null;
    }

    @Override
    public Integer UpdateCuisineClassify(OrderfoodCuisineClassify classify) {
        return null;
    }

    @Override
    public Integer DeleteCuisineClassify(Integer classifyId) {
        return  null;
    }

    @Override
    public List<OrderfoodCuisineClassify> SelectCuisineClassify(OrderfoodCuisineClassify classify) {
        return cuisineClassifyMapper.selectAll();
    }

    @Override
    public List<OrderfoodCuisineClassify> SelectCuisineClassifyById(String classifyName) {
        System.out.println(classifyName);
        return cuisineClassifyMapper.SelectCuisineClassifyById(classifyName);
    }

    @Override
    public Integer delss(Integer classifyid) {
        return cuisineClassifyMapper.delss(classifyid);
    }

    @Override
    public Integer add(OrderfoodCuisineClassify orderfoodCuisineClassify) {
        return cuisineClassifyMapper.add(orderfoodCuisineClassify);
    }

    @Override
    public List<OrderfoodCuisineClassify> getAlls() {
        return cuisineClassifyMapper.getAlls();
    }

    @Override
    public Integer upd(OrderfoodCuisineClassify orderfoodCuisineClassify) {
        return cuisineClassifyMapper.upd(orderfoodCuisineClassify);
    }

    @Override
    public List<OrderfoodCuisineClassify> getAllbyId(Integer id) {
        List<OrderfoodCuisineClassify> list = cuisineClassifyMapper.getAllbyId(id);
        System.out.print(list);
        return cuisineClassifyMapper.getAllbyId(id);
    }

    @Override
    public Integer delpiliang(Integer classifyid) {
        return cuisineClassifyMapper.delpiliang(classifyid);
    }

    @Override
    public List<OrderfoodCuisineClassify> getcaibyfen(String names) {
        return cuisineClassifyMapper.getcaibyfen(names);
    }
}
