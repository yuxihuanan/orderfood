package com.orderfood.service.impl;

import com.orderfood.mapper.OrderfoodIndentMapper;
import com.orderfood.pojo.OrderfoodIndent;
import com.orderfood.pojo.OrderfoodIndentDetails;
import com.orderfood.service.IndentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service("indentServiceImpl")
public class IndentServiceImpl implements IndentService {

    @Autowired
    private OrderfoodIndentMapper indentMapper;

    /**
     * 查询所有信息
     * @return
     */
    @Override
    public List<OrderfoodIndent> getAll() {
        return indentMapper.getAll();
    }

    /**
     * 根据订单号删除订单信息
     * @param indentId
     * @return
     */
    @Override
    public Integer delIndent(Integer indentId) {
        System.out.println(indentId);
        return indentMapper.delIndent(indentId);
    }

    /**
     * 根据订单号查询订单信息
     * @param indentId
     * @return
     */
    @Override
    public List<OrderfoodIndent> getInfo(Integer indentId) {
        return indentMapper.getInfo(indentId);
    }

    /**
     * 查询订单详情
     * @param d_intdentId
     * @return
     */
    @Override
    public List<OrderfoodIndentDetails> getDetails(Integer d_intdentId) {
        return indentMapper.getDetails(d_intdentId);
    }

    @Override
    @Transactional
    public int delesc(List<Object> obj) throws RuntimeException{

        try {
            Example example=new Example(OrderfoodIndent.class);
            example.createCriteria().andIn("indentid",obj);
            this.indentMapper.deleteByExample(example);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

}
