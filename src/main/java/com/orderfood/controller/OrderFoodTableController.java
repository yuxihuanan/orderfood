package com.orderfood.controller;

import com.orderfood.pojo.OrderfoodCuisine;
import com.orderfood.pojo.OrderfoodTable;
import com.orderfood.service.CashierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
    @ResponseBody
    @RequestMapping("OrderTableUpadte")
    /**
     * @Author LYX
     * 修改桌子信息
     * @return int
     */
    public Integer OrderTableUpadte(){
        OrderfoodTable orderfoodTable=new OrderfoodTable();
        orderfoodTable.setTableid(1);
        orderfoodTable.setTablenumber(1);
        orderfoodTable.setTablestatus(1);
        int res=cashierService.Choosetable(orderfoodTable);
        return res;
    }
    @ResponseBody
    @RequestMapping("getorderfoodCuisineAll")
    public List<OrderfoodCuisine> getorderfoodCuisineAll(){
        List<OrderfoodCuisine> list=cashierService.getOrderfoodCuisineAll();
        return list;
    }
}
