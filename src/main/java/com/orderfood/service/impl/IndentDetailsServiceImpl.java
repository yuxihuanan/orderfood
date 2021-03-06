package com.orderfood.service.impl;

import com.alibaba.fastjson.JSON;
import com.orderfood.mapper.IndentDetailsMapper;
import com.orderfood.mapper.OrderFoodTableMapper;
import com.orderfood.pojo.OrderfoodCuisineClassify;
import com.orderfood.pojo.OrderfoodIndent;
import com.orderfood.pojo.OrderfoodIndentDetails;
import com.orderfood.pojo.OrderfoodTable;
import com.orderfood.service.IndentDetailsService;
import com.orderfood.util.MqUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import java.util.List;
import java.util.Timer;

@Service
@Transactional
public class IndentDetailsServiceImpl implements IndentDetailsService {

    @Autowired
    private MqUtils mqUtils;

    @Autowired
    private IndentDetailsMapper indentDetailsMapper;

    @Autowired
    private OrderFoodTableMapper orderFoodTableMapper;

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
        int res=indentDetailsMapper.updateStockByRecipeid(orderfoodIndentDetails);
        return indentDetailsMapper.updateDetails(orderfoodIndentDetails);
    }

    /**
     * 根据所传入的id删除订单详情表中的id
     * @param orderfoodIndentDetails
     * @return
     */
    @Override
    public int deleteDetaiils(OrderfoodIndentDetails orderfoodIndentDetails) {
        int res=indentDetailsMapper.updateStockByRecipeid(orderfoodIndentDetails);
        return indentDetailsMapper.deleteDetaiils(orderfoodIndentDetails);
    }

    /**
     * 添加订单详情,并更新库存
     * @param orderfoodIndentDetails
     * @return
     */
    @Override
    public int addDetails(OrderfoodIndentDetails orderfoodIndentDetails) {
        try {
            mqUtils.sendQueueMessage("updateStock",orderfoodIndentDetails);
            String s=indentDetailsMapper.ExistDetail(orderfoodIndentDetails);
            //判断该订单详情是否存在,存在则在原来的基础上添加菜品的数量
            if (s!=null) {
                orderfoodIndentDetails.setDetailsid(Integer.parseInt(s));
                indentDetailsMapper.updateDetailsByDetail(orderfoodIndentDetails);
            }else{
                mqUtils.sendQueueMessage("addDetails",orderfoodIndentDetails);
                //indentDetailsMapper.addDetails(orderfoodIndentDetails);
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
    public OrderfoodIndent getDetailByTableId(String indentId) {
        return indentDetailsMapper.getDetailByTableId(indentId);
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
     * 当订单为空时删除该订单
     * @param indentid
     * @return
     */
    @Override
    public int deleteIndent(int indentid) {
        return indentDetailsMapper.deleteIndent(indentid);
    }

    /**
     * 得到所有的菜单分类以及菜品
     * @param classifyId
     * @return
     */
    @Override
    public List<OrderfoodCuisineClassify> getAllClassify(Integer classifyId) {
        return indentDetailsMapper.getAllClassify(classifyId);
    }

    /**
     * 通过用户手机号获得其所有的订单
     * @param phone
     * @return
     */
    @Override
    public List<OrderfoodIndent> getAllIndentsByPhone(String phone) {
        return indentDetailsMapper.getAllIndentsByPhone(phone);
    }

    /**
     * 通过手机号查询用户编号
     * @param phone
     * @return
     */
    @Override
    public Integer getUserIdByPhone(String phone) {
        return indentDetailsMapper.getUserIdByPhone(phone);
    }

    /**
     * 得到所有的桌子信息
     * @return
     */
    @Override
    public List<OrderfoodTable> getAllTables() {
        return orderFoodTableMapper.selectAll();
    }

    /**
     * 更新桌子的状态
     * @param orderfoodTable
     * @return
     */
    @Override
    public int updateTableStatu(OrderfoodTable orderfoodTable) {
        return orderFoodTableMapper.updateByPrimaryKeySelective(orderfoodTable);
    }

    /**
     * 监听updateStock队列
     * @param message
     */
    @JmsListener(destination = "updateStock")
    public void receiveQueue1UpdateMessage(Object message){
        OrderfoodIndentDetails orderfoodIndentDetails=null;
        try {
            orderfoodIndentDetails=((OrderfoodIndentDetails)((ObjectMessage)message).getObject());
            indentDetailsMapper.updateStockByRecipeid(orderfoodIndentDetails);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    /**
     * 监听addDetails队列
     * @param message
     */
    @JmsListener(destination = "addDetails")
    public void receiveQueue1AddMessage(Object message){
        OrderfoodIndentDetails orderfoodIndentDetails=null;
        try {
            orderfoodIndentDetails=((OrderfoodIndentDetails)((ObjectMessage)message).getObject());
            indentDetailsMapper.addDetails(orderfoodIndentDetails);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
