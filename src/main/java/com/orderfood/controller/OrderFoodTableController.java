package com.orderfood.controller;

import com.orderfood.pojo.OrderfoodTable;
import com.orderfood.service.CashierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderFoodTableController {
    @Autowired
    private CashierService cashierService;
    @RequestMapping("OrdrTableShow")
    public ModelAndView OrdrTableShow(){
        ModelAndView modelAndView=new ModelAndView("index");
        modelAndView.addObject("ordertable",cashierService.getAllTable());
        return modelAndView;
    }
    @ResponseBody
    @RequestMapping("OrderTableUpadte")
    public Integer OrderTableUpadte(){
        OrderfoodTable orderfoodTable=new OrderfoodTable();
        orderfoodTable.setTableid(1);
        orderfoodTable.setTablenumber(1);
        orderfoodTable.setTablestatus(1);
        int res=cashierService.Choosetable(orderfoodTable);
        return res;
    }
}
