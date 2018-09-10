package com.orderfood.mapper;

import com.orderfood.pojo.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("cuisineMapper")
public interface CuisineMapper extends CommonMapper<OrderfoodCuisine> {
    @Delete("DELETE FROM orderfood_cuisine WHERE cuisineid = #{id}")
    public int cuisinedel(int id);

    @Update("update orderfood_cuisine set picture=#{picture}, cuisinename=#{cuisinename},price=#{price},cuisineacronym=#{cuisineacronym},cuisineidentify=#{cuisineidentify},c_classifyId=#{cClassifyid}  where cuisineid=#{cuisineid} ")
    public int cuisineupdd(OrderfoodCuisine cuisn);

    @Insert("insert into orderfood_cuisine values(null,cuisinename=#{cuisin.cuisinename},price=#{cuisin.price},cuisineacronym=#{cuisin.cuisineacronym},cuisineIdentify=#{cuisin.cuisineidentify},c_classifyid=#{cuisin.cClassifyid},picture=#{cuisin.picture})")
    public int cuisineadd(@Param("cuisin") OrderfoodCuisine cuisin);

    //@Select("select c_classifyId,cuisineId,cuisineName,price,cuisineAcronym,cuisineIdentify,picture from orderfood_cuisine where cuisineid=#{cuisineid}")
    public OrderfoodCuisine getOne(Integer cuisineid);

    public List<OrderfoodCuisine> getAll(@Param("cuisineacronym") String cuisineacronym);





    /*
     *查询全部菜品
     */
    public List<OrderfoodCuisine> selectAll();


    /*
     *查询菜品分类
     */
    public List<OrderfoodCuisineClassify> selectAl();







    /*
     *查询配方
     */
    //public List<OrderfoodRecipe> getRecipe(@Param("cuisineid") Integer cuisineid);

    public OrderfoodCuisine getRecipe(@Param("cuisineid") Integer cuisineid);



    /*
     *添加配方原料查询
     */
    @Select("select * from orderfood_stock")
    public List<OrderfoodStock> getStock();


    /*
     *添加配方菜品查询
     */
    @Select("select * from orderfood_cuisine")
    public List<OrderfoodCuisine> sine();


    //得到全部的分类个数
    Integer getAllCount();
    //分类得到数据
    List<OrderfoodCuisine> getTiao(@Param("pageIndexss")Integer pageIndexss, @Param("pageSizess")Integer pageSizess);

}
