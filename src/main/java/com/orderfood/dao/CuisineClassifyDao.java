package com.orderfood.dao;

import com.orderfood.pojo.OrderfoodCuisineClassify;

import java.util.List;

/**
 * 菜品分类Dao接口
 */
public interface CuisineClassifyDao {
    /**
     * 新增菜品分类
     * @param classify
     * @return
     */
    public Integer InsertCuisineClassify(OrderfoodCuisineClassify classify);

    /**
     * 修改菜品分类
     * @param classify
     * @return
     */
    public Integer UpdateCuisineClassify(OrderfoodCuisineClassify classify);

    /**
     * 删除菜品分类
     * @param classifyId
     * @return
     */
    public Integer DeleteCuisineClassify(Integer classifyId);

    /**
     * 查询菜品分类
     * @param classify
     * @return
     */
    public List<OrderfoodCuisineClassify> SelectCuisineClassify(OrderfoodCuisineClassify classify);
}
