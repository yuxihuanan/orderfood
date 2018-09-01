package com.orderfood.service;


import com.orderfood.pojo.OrderfoodCuisineClassify;

import java.util.List;

/**
 * 菜品分类管理Service接口
 */
public interface CuisineClassifyService {
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



    /**
     * 查询菜品分类根据Id查询
     * @param classifyName
     * @return
     */
    public List<OrderfoodCuisineClassify> SelectCuisineClassifyById(String classifyName);


    /**
     * 菜品分类根据Id删除
     * @param  classifyid
     * @return
     */
    public  Integer del(Integer classifyid);

    /**
     * 菜品分类根据Id删除
     * @param  orderfoodCuisineClassify
     * @return
     */
    public  Integer add(OrderfoodCuisineClassify orderfoodCuisineClassify);



    public  List<OrderfoodCuisineClassify> getAlls();
    public  Integer upd(OrderfoodCuisineClassify orderfoodCuisineClassify);
    public  List<OrderfoodCuisineClassify> getAllbyId(Integer id);
    public  Integer delpiliang(Integer classifyid);

}
