package com.orderfood.controller;

import com.alibaba.fastjson.JSON;
import com.orderfood.pojo.OrderfoodIndentDetails;
import com.orderfood.service.IndentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("IndentDetails")
public class IndentDetailsController {

    @Autowired
    private IndentDetailsService indentDetailsService;

    /**
     * 查看订单详情
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getDetail",produces = "text/plain;charset=utf-8")
    public String getDetail(String tableId){
        return JSON.toJSONString(indentDetailsService.getDetail(tableId));
    }

    /**
     * 修改订单详情
     * @return
     */
    @ResponseBody
    @RequestMapping("updateDetails")
    public String updateDetails(OrderfoodIndentDetails orderfoodIndentDetails){
        return JSON.toJSONString(indentDetailsService.updateDetails(orderfoodIndentDetails));
    }

    /**
     * 删除订单详情
     * @return
     */
    @ResponseBody
    @RequestMapping("deleteDetaiils")
    public String deleteDetaiils(Integer id){
        return JSON.toJSONString(indentDetailsService.deleteDetaiils(id));
    }

    /**
     * 添加订单详情
     * @return
     */
    @RequestMapping("addDetails")
    public ModelAndView addDetails(OrderfoodIndentDetails orderfoodIndentDetails){
        ModelAndView model=new ModelAndView("");
        model.addObject("status",indentDetailsService.addDetails(orderfoodIndentDetails));
        return model;
    }
}
