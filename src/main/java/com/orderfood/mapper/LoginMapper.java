package com.orderfood.mapper;

import com.orderfood.pojo.OrderfoodStaffRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository("loginMapper")
public interface LoginMapper extends CommonMapper<OrderfoodStaffRole> {
}
