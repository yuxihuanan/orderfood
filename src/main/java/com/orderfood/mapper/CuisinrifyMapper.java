package com.orderfood.mapper;

import com.orderfood.pojo.OrderfoodCuisineClassify;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuisinrifyMapper extends CommonMapper<OrderfoodCuisineClassify>{
    List<OrderfoodCuisineClassify> SelectCuisineClassifyById(@Param("classifyName") String classifyName);
    List<OrderfoodCuisineClassify>  getAlls();
    List<OrderfoodCuisineClassify> getAllbyId(Integer id);
    Integer delss(Integer classifyid);
    Integer add(OrderfoodCuisineClassify orderfoodCuisineClassify);
    Integer upd(OrderfoodCuisineClassify orderfoodCuisineClassify);
    Integer delpiliang(Integer classifyid);
    List<OrderfoodCuisineClassify> getcaibyfen(String names);

    //得到全部的分类个数
    Integer getAllCount();
    //分类得到数据
    List<OrderfoodCuisineClassify> getTiao(@Param("pageIndexss")Integer pageIndexss,@Param("pageSizess")Integer pageSizess);
}
