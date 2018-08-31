package com.orderfood.mapper;

import com.orderfood.pojo.OrderfoodMenu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("menuMapper")
public interface MenuMapper extends CommonMapper<OrderfoodMenu>{
    public List<OrderfoodMenu> selectMenu(@Param("menu") OrderfoodMenu menu);
}
