package com.orderfood.service;


import com.orderfood.pojo.OrderfoodRecipe;

import java.util.List;

/**
 *菜品管理Service接口
 */
public interface CuisineService {
    /**
     * 新增菜品
     * @param recipe
     * @return
     */
    public Integer InsertCuisine(OrderfoodRecipe recipe);

    /**
     * 修改菜品
     * @param recipe
     * @return
     */
    public Integer UpdateCuisine(OrderfoodRecipe recipe);

    /**
     * 删除菜品
     * @param recipeId
     * @return
     */
    public Integer DeleteCuisine(Integer recipeId);

    /**
     * 查询菜品
     * @param recipe
     * @return
     */
    public List<OrderfoodRecipe> SelectCuisine(OrderfoodRecipe recipe);
}
