package com.orderfood.service.impl;

import com.orderfood.mapper.IndentDetailsMapper;
import com.orderfood.pojo.OrderfoodIndent;
import com.orderfood.pojo.OrderfoodIndentDetails;
import com.orderfood.service.IndentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IndentDetailsServiceImpl implements IndentDetailsService {

    @Autowired
    private IndentDetailsMapper indentDetailsMapper;

    /**
     * 根据tableId获得所有的在此桌的订单，并根据日期拿到最新的订单
     * @param tableId
     * @return
     */
    @Override
    public List<OrderfoodIndentDetails> getDetail(String tableId) {
        return indentDetailsMapper.getDetail(tableId);
    }

    /**
     * 根据所传入的OrderfoodIndentDetails对象对其进行更新
     * @return
     */
    @Override
    public int updateDetails(OrderfoodIndentDetails orderfoodIndentDetails) {
        return indentDetailsMapper.updateDetails(orderfoodIndentDetails);
    }

    /**
     * 根据所传入的id删除订单详情表中的id
     * @param detailsId
     * @return
     */
    @Override
    public int deleteDetaiils(int detailsId) {
        return indentDetailsMapper.deleteDetaiils(detailsId);
    }

    /**
     * 添加订单详情
     * @param orderfoodIndentDetails
     * @return
     */
    @Override
    public int addDetails(OrderfoodIndentDetails orderfoodIndentDetails) {
        int res=indentDetailsMapper.updateStockByRecipeid(orderfoodIndentDetails.getdCuisineid());
        try {

            String s=indentDetailsMapper.ExistDetail(orderfoodIndentDetails);
            String detailId=indentDetailsMapper.ExistDetail(orderfoodIndentDetails);
            //判断该订单详情是否存在,存在则在原来的基础上添加菜品的数量
            if (!detailId.equals("0")) {
                orderfoodIndentDetails.setDetailsid(Integer.parseInt(detailId));
                indentDetailsMapper.updateDetailsByDetail(orderfoodIndentDetails);
            }else{
                indentDetailsMapper.addDetails(orderfoodIndentDetails);
            }
            return 1;
        }catch (Exception e){
            return 0;
        }
    }

    /**
     * 通过桌号，获得订单的信息
     * @return
     */
    @Override
    public OrderfoodIndent getDetailByTableId(String tableId) {
        return indentDetailsMapper.getDetailByTableId(tableId);
    }

    /**
     * 下单时生成一个订单
     * @param orderfoodIndent
     * @return
     */
    @Override
    public int addIndent(OrderfoodIndent orderfoodIndent) {
        return indentDetailsMapper.addIndent(orderfoodIndent);
    }

    /**
     * 查询该订单号的订单编号
     * @param indentCode
     * @return
     */
    @Override
    public int getDetailsIdByIndentCode(String indentCode) {
        return indentDetailsMapper.getDetailsIdByIndentCode(indentCode);
    }

    /**
     * 通过菜品id为条件让配方表与库存表进行映射，进行删减
     * @param r_cuisineId
     * @return
     */
    @Transactional
    @Override
    public int updateStockByRecipeid(Integer r_cuisineId) {
        return indentDetailsMapper.updateStockByRecipeid(r_cuisineId);
    }
}
