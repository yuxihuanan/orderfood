package com.orderfood.service;


import com.orderfood.pojo.OrderfoodCargo;
import com.orderfood.pojo.OrderfoodRunningData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 库存管理Service接口
 */
public interface CargoService {

    /**
     * 修改库存信息(出库)
     * @param cargo
     * @return
     */
    public Integer UpdateCargo(OrderfoodCargo cargo);


    /**
     * 查询库存信息
     * @param cargoid
     * @return
     */
    OrderfoodCargo SelectCargo(@Param(value = "cargoid") Integer cargoid);
    /**
     * 查询所有库存
     * @return
     */
    List<OrderfoodCargo> getAllCargo();
    /**
     * 批量删除
     * @param CargoIdList
     */
    Integer delCargo(List<Object> CargoIdList);

    /**
     * 添加入库支出记录
     * @return
     */
    Integer InsRunData(OrderfoodRunningData runData);
    /**
     * 添加入库记录
     * @param cargo
     * @return
     */
    Integer InsertCargo(OrderfoodCargo cargo);
    /**
     * 同步入库支出流水
     * @param cargo
     * @param runData
     * @return
     */
    Integer InsertInfo(OrderfoodCargo cargo,OrderfoodRunningData runData);
    /**
     * 根据原料主键查询该原料的目前数量
     * @return
     */
    Float selRawStock(@Param(value = "stockid") Integer stockid);
}
