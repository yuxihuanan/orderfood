package com.orderfood.controller;

import com.orderfood.service.StockService;
import org.springframework.web.bind.annotation.RequestMapping;

public class StockController {

    private StockService stockService;

    @RequestMapping("SelectStock")
    public String SelectStock(){

        return "";
    }
}
