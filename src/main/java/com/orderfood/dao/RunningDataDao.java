package com.orderfood.dao;

import com.orderfood.pojo.OrderfoodRunningData;

import java.util.List;

/**
 * 数据管理Dao接口
 */
public interface RunningDataDao {
    /**
     * 新增收支流水信息
     */
    public Integer InsertRunningData(OrderfoodRunningData runningData);

    /**
     * 修改收支流水信息
     * @param runningData
     * @return
     */
    public Integer UpdateRunningData(OrderfoodRunningData runningData);

    /**
     * 删除收支流水记录
     * @param runningDataId
     * @return
     */
    public Integer DeleteRunningData(Integer runningDataId);

    /**
     * 查询收支流水信息
     * @param runningData
     * @return
     */
    public List<OrderfoodRunningData> SelectRunningData(OrderfoodRunningData runningData);
}
