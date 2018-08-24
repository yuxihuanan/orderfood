package com.orderfood.dao;

import com.orderfood.pojo.OrderfoodRecipe;

import java.util.List;

/**
 * 菜品管理Dao接口
 */
public interface CuisineDao {
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
