package com.orderfood.mapper;

import com.orderfood.pojo.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("cuisineMapper")
public interface CuisineMapper extends CommonMapper<OrderfoodCuisine> {
    @Delete("DELETE FROM orderfood_cuisine WHERE cuisineid = #{id}")
    public int cuisinedel(int id);

    @Update("update orderfood_cuisine set  cuisinename=#{cuisinename},price=#{price},cuisineacronym=#{cuisineacronym},cuisineidentify=#{cuisineidentify},c_classifyId=#{cClassifyid}  where cuisineid=#{cuisineid} ")
    public int cuisineupdd(OrderfoodCuisine cuisn);

    @Insert("insert into orderfood_cuisine values(null,cuisinename=#{cuisin.cuisinename},price=#{cuisin.price},cuisineacronym=#{cuisin.cuisineacronym},cuisineidentify=#{cuisin.cuisineidentify},c_classifyid=#{cuisin.cClassifyid},picture=#{cuisin.picture})")
    public int cuisineadd(@Param("cuisin") OrderfoodCuisine cuisin);

    @Select("select * from orderfood_cuisine where cuisineid=#{cuisineid}")
    public OrderfoodCuisine getOne(Integer cuisineid);

    public OrderfoodCuisine getAll(String cuisineacronym);

    public List<OrderfoodCuisine> selectAll();

    public List<OrderfoodCuisineClassify> selectAl();

    @Insert("INSERT INTO orderfood_recipe VALUES(NULL,recipeContent=#{recipe.recipecontent},r_stockId=#{recipe.rStockid},recipeWeight=#{recipe.recipeweight},r_cuisineId=#{recipe.rCuisineid})")
    public int Recipeadd(@Param("recipe") OrderfoodRecipe recipe);


    public List<OrderfoodRecipe> getRecipe();

    @Select("select * from orderfood_stock")
    public List<OrderfoodStock> getStock();


    @Select("select * from orderfood_cuisine")
    public List<OrderfoodCuisine> sine();

}
