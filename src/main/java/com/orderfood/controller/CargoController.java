package com.orderfood.controller;

import com.orderfood.pojo.OrderfoodRunningData;
import com.orderfood.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.orderfood.pojo.OrderfoodCargo;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("CargoController")
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @RequestMapping("toCargo")
    public ModelAndView toCargo(){
        ModelAndView mav=new ModelAndView("client/OrderManager");
        /*OrderfoodCargo cargo2=new OrderfoodCargo();
        cargo2.setCargoid(13);
        cargo2.setcStockid(26);
        cargo2.setCargoprice(111.00f);
        cargo2.setCargoweight(22.22f);
        List<Object> list=new ArrayList<Object>();
        list.add(24);
        list.add(25);
        list.add(26);
        OrderfoodCargo cargo=new OrderfoodCargo();
        cargo.setcStockid(30);
        cargo.setCargoprice(111.00f);
        cargo.setCargoweight(22.22f);
        cargoService.delCargo(list);
        OrderfoodRunningData runningData=new OrderfoodRunningData();
        runningData.setDataprice(100.00f);
        runningData.setDatacomment("买了1kg黄瓜");

        mav.addObject("ins",cargoService.InsertInfo(cargo,runningData));
        mav.addObject("upd",cargoService.UpdateCargo(cargo2));
        mav.addObject("single",cargoService.SelectCargo(10));*/
        mav.addObject("cargo",cargoService.getAllCargo());
        mav.addObject("sum",cargoService.selRawStock(26));
        return mav;
    }
    @RequestMapping("toOrderClass")
    public ModelAndView toOrderClass(){
        ModelAndView mav=new ModelAndView("client/OrderClass");
        return mav;
    }
    @RequestMapping("toAddOrder")
    public ModelAndView toAddOrder(){
        ModelAndView mav=new ModelAndView("client/AddOrder");
        return mav;
    }

}
