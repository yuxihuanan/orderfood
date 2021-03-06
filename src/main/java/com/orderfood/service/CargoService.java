package com.orderfood.service;


import com.orderfood.pojo.OrderfoodCargo;
import com.orderfood.pojo.OrderfoodRunningData;
import com.orderfood.pojo.OrderfoodStock;
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
     * @param cargos
     * @param runData
     * @return
     */
    Integer InsertInfo(OrderfoodRunningData runData,List<OrderfoodCargo> cargos);
    /**
     * 获取原料和单位
     * @return
     */
    List<OrderfoodStock> getUnitl();
    /**
     * 当前页的数据
     * @param Start
     * @param Size
     * @return
     */
    List<OrderfoodCargo> findNewsPage(@Param(value = "Start") Integer Start,@Param(value = "Size") Integer Size);
    /**
     * 查询数据总条数
     * @return
     */
    Integer findNewCont(@Param(value = "stockname") String stockname);
    /**
     * 根据原料名模糊查询数据
     * @param stockname
     * @return
     */
    List<OrderfoodCargo> findLike(@Param(value = "stockname") String stockname,@Param(value = "Start") Integer Start,@Param(value = "Size") Integer Size);
    /**
     * 根据原料名查数据条数
     * @param stockname
     * @return
     */
    Integer findLikeCount(@Param(value = "stockname") String stockname);
    /**
     * 查询某个原料的剩余总重量
     * @param stockname
     * @return
     */
    Float weightSum(@Param(value = "stockname") String stockname);
}
