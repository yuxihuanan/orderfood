package com.orderfood.controller;

import com.orderfood.pojo.OrderfoodStock;
import com.orderfood.service.StockService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
@Controller
public class StockController {

    @Resource(name="stockService")
    private StockService stockService;
    @RequestMapping("stocklogin")
    public ModelAndView SelectStock(OrderfoodStock stock) {
        ModelAndView model = new ModelAndView("index");
        model.addObject("users",stockService.SelectStock(null));
        return model;

    }
}


