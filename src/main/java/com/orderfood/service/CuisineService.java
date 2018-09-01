package com.orderfood.service;


import com.orderfood.pojo.OrderfoodCuisine;
import com.orderfood.pojo.OrderfoodCuisineClassify;
import com.orderfood.pojo.OrderfoodRecipe;

import java.util.List;

/**
 *菜品管理Service接口
 */
public interface CuisineService {

    /**
     * 修改菜品
     * @param id
     * @return
     */
    public int Cuisinedel(int id);

    /**
     * 新增菜品
     * @param cuisin
     * @return
     */
    public int Cuisineadd(OrderfoodCuisine cuisin);


    /**
     * 修改菜品
     * @param cuisn
     * @return
     */
    public int Cuisineupdd(OrderfoodCuisine cuisn);

    OrderfoodCuisine getOne(Integer cuisineid);
    /**
     * 根据首字母查询菜品
     * @return
     */
    OrderfoodCuisine getAll(String cuisineacronym);

    /**
     * 查询菜品
     * @return
     */
    public List<OrderfoodCuisine> selectAll();
    /**
     * 查询菜品分类
     * @return
     */
    public List<OrderfoodCuisineClassify> selectAl();


}
