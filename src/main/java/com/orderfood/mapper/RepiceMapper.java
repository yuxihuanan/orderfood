package com.orderfood.mapper;

import com.orderfood.pojo.OrderfoodRecipe;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("repiceMapper")
public interface RepiceMapper extends CommonMapper<OrderfoodRecipe> {

    /*
     *添加配方
     */
    public int Recipeadd(@Param("recipe") OrderfoodRecipe recipe);
}
