package com.orderfood.mapper;

import com.orderfood.pojo.OrderfoodStock;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository("stockMapper")
public interface StockMapper extends CommonMapper<OrderfoodStock> {
    @Delete("DELETE FROM orderfood_stock WHERE stockId = #{id}")
    public int del(int id);
    /**
     * 新增原料
     * @param stock
     * @return
     */
    public Integer InsertStock(@Param("stock") OrderfoodStock stock);

    /**
     * 修改原料
     * @param stock
     * @return
     */
    public Integer UpdateStock(OrderfoodStock stock);

    /**
     * 删除原料
     * @param stockId
     * @return
     */
    public Integer DeleteStock(Integer stockId);

    /**
     * 查询原料
     * @param stock
     * @return
     */
    public List<OrderfoodStock> SelectStock(OrderfoodStock stock);

    /**
     * 根据原料名称查询
     * @param stock
     * @return
             */
    public List<OrderfoodStock> SelectStockName(OrderfoodStock stock);

    public List<OrderfoodStock> getInfo(String intdentName);

    public OrderfoodStock getId(@Param("id") int id);

    public int delesc(List<Object> obj);
}
