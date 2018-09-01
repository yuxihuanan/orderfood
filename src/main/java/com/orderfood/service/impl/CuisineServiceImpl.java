package com.orderfood.service.impl;

import com.orderfood.mapper.CuisineMapper;
import com.orderfood.pojo.OrderfoodCuisine;
import com.orderfood.pojo.OrderfoodCuisineClassify;
import com.orderfood.pojo.OrderfoodRecipe;
import com.orderfood.service.CuisineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.soap.Addressing;
import java.util.List;
@Service("cuisine")
public class CuisineServiceImpl implements CuisineService {


    @Autowired
    private CuisineMapper cuisineMapper;

    @Override
    public int Cuisinedel(int id) {
        return cuisineMapper.cuisinedel(id);
    }

    @Override
    public int Cuisineadd(OrderfoodCuisine cuisin) {
        return cuisineMapper.insert(cuisin);
    }

    @Override
    public int Cuisineupdd(OrderfoodCuisine cuisn) {
        return cuisineMapper.cuisineupdd(cuisn);
    }

    @Override
    public OrderfoodCuisine getOne(Integer cuisineid) {
        return cuisineMapper.getOne(cuisineid);
    }

    @Override
    public OrderfoodCuisine getAll(String cuisinename) {
        return cuisineMapper.getAll(cuisinename);
    }

    @Override
    public List<OrderfoodCuisine> selectAll() {
        return cuisineMapper.selectAll();
    }

    @Override
    public List<OrderfoodCuisineClassify> selectAl() {
        return cuisineMapper.selectAl();
    }
}







