package com.orderfood.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

    @GetMapping("tablesdetails")
    public ModelAndView goXuanzhuo(String tableId){
        ModelAndView model=new ModelAndView("page/tablesdetails");
        model.addObject("tableId",3);
        model.addObject("statu",0);
        return model;
    }

    @RequestMapping("orderDetails")
    public ModelAndView goOrderDetails(String tableId){
        ModelAndView model=new ModelAndView("page/orderdetails");
        model.addObject("tableId",tableId);
        return model;
    }
}
