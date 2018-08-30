package com.orderfood.mapper;

import com.orderfood.pojo.OrderfoodRunningData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 收支流水
 */
@Repository("runningDataMapper")
public interface RunningDataMapper extends CommonMapper<OrderfoodRunningData>{
    /**
     * 查询收支
     * @param runningData
     * @return
     */
    public List<OrderfoodRunningData> SelectRunningData(@Param("runningData") OrderfoodRunningData runningData);
}
