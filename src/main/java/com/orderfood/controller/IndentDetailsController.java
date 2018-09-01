package com.orderfood.controller;

import com.alibaba.fastjson.JSON;
import com.orderfood.pojo.OrderfoodIndent;
import com.orderfood.pojo.OrderfoodIndentDetails;
import com.orderfood.service.IndentDetailsService;
import com.orderfood.util.CommonUtil;
import com.orderfood.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
        CommonUtil.IndentCode();
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
    public String deleteDetaiils(OrderfoodIndentDetails orderfoodIndentDetails){
        return JSON.toJSONString(indentDetailsService.deleteDetaiils(orderfoodIndentDetails));
    }

    /**
     * 添加订单详情
     * @return
     */
    @ResponseBody
    @RequestMapping("addDetails")
    public String addDetails(OrderfoodIndentDetails orderfoodIndentDetails){
        indentDetailsService.addDetails(orderfoodIndentDetails);
        return null;
    }

    /**
     * 添加新的订单
     * @param orderfoodIndent
     * @return
     */
    @ResponseBody
    @RequestMapping("addIndent")
    public String addIndent(OrderfoodIndent orderfoodIndent){
        String code=CommonUtil.IndentCode(); //随机订单号
        orderfoodIndent.setIndentcode(code);
        indentDetailsService.addIndent(orderfoodIndent);
        //返回一个订单id
        return JSON.toJSONString(indentDetailsService.getDetailsIdByIndentCode(code));
    }

    /**
     * 当订单为空时删除该订单
     * @param indentid
     * @return
     */
    @ResponseBody
    @RequestMapping("deleteIndent")
    public String deleteIndent(int indentid){
        return JSON.toJSONString(indentDetailsService.deleteIndent(indentid));
    }
}
