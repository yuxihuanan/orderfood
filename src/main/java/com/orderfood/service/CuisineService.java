package com.orderfood.service;


import com.orderfood.pojo.OrderfoodCuisine;
import com.orderfood.pojo.OrderfoodCuisineClassify;
import com.orderfood.pojo.OrderfoodRecipe;
import com.orderfood.pojo.OrderfoodStock;

import java.util.List;

/**
 *菜品管理Service接口
 */
public interface CuisineService {

    /**
     * 删除菜品
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

    /**
     * 根据id删除
     * @param cuisineid
     * @return
     */
    OrderfoodCuisine getOne(Integer cuisineid);

    /**
     * 根据首字母查询菜品
     * @return
     */
    List<OrderfoodCuisine> getAll(String cuisineacronym);

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


    /**
     * 查询菜品配方
     */
    public OrderfoodCuisine getRecipe(Integer cuisineid);

    /**
     *添加菜品配方
     */
    public int Recipeadd(OrderfoodRecipe recipe);

    /**
     * 查询菜品原料
     */
    public List<OrderfoodStock> getStock();

    /**
     * 查询菜品
     */
    public List<OrderfoodCuisine> sine();


}
