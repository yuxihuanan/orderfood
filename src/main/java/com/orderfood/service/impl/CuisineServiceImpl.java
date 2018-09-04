package com.orderfood.service.impl;

import com.orderfood.mapper.CuisineMapper;
import com.orderfood.mapper.RepiceMapper;
import com.orderfood.pojo.OrderfoodCuisine;
import com.orderfood.pojo.OrderfoodCuisineClassify;
import com.orderfood.pojo.OrderfoodRecipe;
import com.orderfood.pojo.OrderfoodStock;
import com.orderfood.service.CuisineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.soap.Addressing;
import java.util.List;
@Service("cuisine")
public class CuisineServiceImpl implements CuisineService {


    @Autowired
    private CuisineMapper cuisineMapper;

    @Autowired
    private RepiceMapper repiceMapper;
    /**
     * 删除菜品
     * @param id
     * @return
     */
    public int Cuisinedel(int id) {
        return cuisineMapper.cuisinedel(id);
    }

    /**
     * 新增菜品
     * @param cuisin
     * @return
     */
    public int Cuisineadd(OrderfoodCuisine cuisin) {
        return cuisineMapper.insert(cuisin);
    }

    /**
     * 修改菜品
     * @param cuisn
     * @return
     */
    public int Cuisineupdd(OrderfoodCuisine cuisn) {
        return cuisineMapper.cuisineupdd(cuisn);
    }

    /**
     * 根据id查询
     * @param cuisineid
     * @return
     */
    public OrderfoodCuisine getOne(Integer cuisineid) {
        return cuisineMapper.getOne(cuisineid);
    }

    /**
     * 根据首字母查询菜品
     * @return
     */
    public List<OrderfoodCuisine> getAll(String cuisineacronym) {
        return cuisineMapper.getAll(cuisineacronym);
    }

    /**
     * 查询菜品
     * @return
     */
    public List<OrderfoodCuisine> selectAll() {
        return cuisineMapper.selectAll();
    }

    /**
     * 查询菜品分类
     * @return
     */
    public List<OrderfoodCuisineClassify> selectAl() {
        return cuisineMapper.selectAl();
    }

    /**
     * 查询菜品配方
     */
    public OrderfoodCuisine getRecipe(Integer cuisineid) {
        return cuisineMapper.getRecipe(cuisineid);
    }

    /**
     *添加菜品配方
     */
    public int Recipeadd(OrderfoodRecipe recipe) {
        return repiceMapper.insert(recipe);
    }

    /**
     * 查询菜品原料
     */
    public List<OrderfoodStock> getStock() {
        return cuisineMapper.getStock();
    }

    /**
     * 查询菜品
     */
    public List<OrderfoodCuisine> sine() {
        return cuisineMapper.sine();
    }
}







