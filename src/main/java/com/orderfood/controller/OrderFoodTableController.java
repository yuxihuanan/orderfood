package com.orderfood.controller;

import com.alibaba.fastjson.JSON;
import com.orderfood.config.RedisUtil;
import com.orderfood.pojo.OrderfoodCuisine;
import com.orderfood.pojo.OrderfoodTable;
import com.orderfood.service.CashierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
/**
 * 收银柜台Contorller
 */
public class OrderFoodTableController {
    @Autowired
    private CashierService cashierService;//配置service实现
    @RequestMapping("OrdrTableShow")
    /**
     * @Author LYX
     * 跳转页面
     * @return 所有的桌号
     */
    public ModelAndView OrdrTableShow(){
        ModelAndView modelAndView=new ModelAndView("page/begintheatricalperformance");
        modelAndView.addObject("ordertable",cashierService.getAllTable());
        return modelAndView;
    }
    /**
     * @Author LYX
     * 跳转页面
     * @return 所有的桌号
     */
    @RequestMapping("MymenmShow")
    public ModelAndView MymenmShow(){
        ModelAndView modelAndView=new ModelAndView("page/Mymenu");
        String info=RedisUtil.getRu().get("lyx"+Zhuohao);
        System.out.println(info);
        modelAndView.addObject("myMeum",info);
        return modelAndView;
    }
    /**
     * 跳进点菜页面
     * OrdermealShow
     * @return
     */
    private Integer Zhuohao;
    @RequestMapping("OrdermealShow")
    public ModelAndView OrdermealShow(){
        ModelAndView modelAndView=new ModelAndView("page/Ordermeal");
        List<OrderfoodCuisine> list=cashierService.getOrderfoodCuisineAll();
        modelAndView.addObject("foodCuisine",list);
        modelAndView.addObject("zhuanhao",Zhuohao);
        return modelAndView;
    }

    /**
     * 获取桌号
     * OrdermealShow
     * @return
     */
    @RequestMapping("OrdermealShow/{id}")
    public String OrdermealShow(@PathVariable Integer id){
        this.Zhuohao=id;
        return "redirect:/OrdermealShow";
    }

    /**
     * 将菜单传入redis
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("AddMyMeum")
    public String MymenuShow(String jsonArray){
       String res=RedisUtil.getRu().set("lyx"+Zhuohao,jsonArray);
       System.out.println(res);
       return JSON.toJSONString(res);
    }
    /**
     * 菜谱点菜
     * @return
     */
    @RequestMapping("ThemenuorderShow")
    public ModelAndView ThemenuorderShow(){
        ModelAndView modelAndView=new ModelAndView("page/Themenuorder");
        List<OrderfoodCuisine> list=cashierService.getOrderfoodCuisineAll();
        modelAndView.addObject("foodCuisine",list);
        modelAndView.addObject("inn",1);
        return modelAndView;
    }
    /**
     * 看订单
     * OrdermealShow
     * @return
     */
    @RequestMapping("TablesdetailsShow")
    public ModelAndView TablesdetailsShow(){
        ModelAndView modelAndView=new ModelAndView("page/tablesdetails");
        return modelAndView;
    }
    @RequestMapping("OrderTableUpadte/{tableid}/{tablenumber}/{tablestatus}")
    /**
     * @Author LYX
     * 修改桌子信息
     * @return int
     */
    public String OrderTableUpadte(@PathVariable Integer tableid,@PathVariable Integer tablenumber,@PathVariable Integer tablestatus){
        OrderfoodTable orderfoodTable=new OrderfoodTable();
        orderfoodTable.setTableid(tableid);
        orderfoodTable.setTablenumber(tablenumber);
        orderfoodTable.setTablestatus(tablestatus);
        int res=cashierService.Choosetable(orderfoodTable);
        return "redirect:/OrdermealShow";
    }
}
