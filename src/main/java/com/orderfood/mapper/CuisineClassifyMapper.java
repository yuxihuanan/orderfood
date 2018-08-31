package com.orderfood.mapper;

import com.orderfood.pojo.OrderfoodCuisine;
import com.orderfood.pojo.OrderfoodCuisineClassify;
import com.orderfood.pojo.OrderfoodEmployee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("CuisineClassifyMapper")
public interface CuisineClassifyMapper  extends CommonMapper<OrderfoodCuisineClassify> {
    public List<OrderfoodCuisineClassify> SelectCuisineClassifyById(@Param("classifyName") String classifyName);
    public  List<OrderfoodCuisineClassify> getAlls();
    public  List<OrderfoodCuisineClassify> getAllbyId(Integer id);
    public  Integer del( Integer classifyid);
    public  Integer add(OrderfoodCuisineClassify orderfoodCuisineClassify);
    public  Integer upd(OrderfoodCuisineClassify orderfoodCuisineClassify);
    public Integer delpiliang(Integer classifyid);

}
