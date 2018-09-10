package com.orderfood.mapper;

import com.orderfood.pojo.OrderfoodRecipe;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository("repiceMapper")
public interface RepiceMapper extends CommonMapper<OrderfoodRecipe> {

    /*
     *添加配方
     */
    public int Recipeadd(@Param("recipe") OrderfoodRecipe recipe);

    /**
     * 修改配方
     * @param recipe
     * @return
     */
    public int updRecipe(@Param("recipe") OrderfoodRecipe recipe);

    /*
    *批量删除
     */
    public int delRecipe(Integer rRecipeid);
}
