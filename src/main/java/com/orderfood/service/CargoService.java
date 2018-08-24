package com.orderfood.service;


import com.orderfood.pojo.OrderfoodCargo;

import java.util.List;

/**
 * 库存管理Service接口
 */
public interface CargoService {
    /**
     * 货物入库
     * @param cargo
     * @return
     */
    public Integer InsertCargo(OrderfoodCargo cargo);

    /**
     * 修改库存信息(出库)
     * @param cargo
     * @return
     */
    public Integer UpdateCargo(OrderfoodCargo cargo);

    /**
     * 删除库存信息
     * @param cargoId
     * @return
     */
    public Integer DeleteCuisineCargo(Integer cargoId);

    /**
     * 查询库存信息
     * @param cargo
     * @return
     */
    public List<OrderfoodCargo> SelectCargo(OrderfoodCargo cargo);
}
