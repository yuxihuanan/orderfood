package com.orderfood.mapper;

import com.orderfood.pojo.CargoPage;
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
    /**
     * 分页查询收支流水
     * @param runningData
     * @param page
     * @return
     */
    public List<OrderfoodRunningData> SelectRunningDataPages(@Param("runningData") OrderfoodRunningData runningData,@Param("page") CargoPage page);

    /**
     * 查询收支流水总数
     * @return
     */
    public Integer RunningDataCount(@Param("runningData") OrderfoodRunningData runningData);
}
