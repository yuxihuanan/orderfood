package com.orderfood.mapper;

import com.orderfood.pojo.OrderfoodEmployee;
import com.orderfood.pojo.OrderfoodJurisdiction;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("loginMapper")
public interface LoginMapper extends CommonMapper<OrderfoodEmployee>{
    /**
     * 权限
     * @param roleId
     * @return
     */
    public List<OrderfoodJurisdiction> GetJurisdiction(@Param("roleId") Integer roleId);
}
