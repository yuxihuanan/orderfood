package com.orderfood.controller;

import com.alibaba.fastjson.JSON;
import com.orderfood.pojo.CargoPage;
import com.orderfood.pojo.OrderfoodStock;
import com.orderfood.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.spring.web.json.Json;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StockController {

    @Autowired
    private StockService stockService;
    @RequestMapping("stocklogin")
    public ModelAndView SelectStock(OrderfoodStock stock) {
        ModelAndView model = new ModelAndView("task/MoveTaskApply");
        model.addObject("users",stockService.SelectStock(null));
        return model;
    }

    @ResponseBody
    @RequestMapping("dell/{id}")
    public String del(@PathVariable("id") Integer id){
        System.out.print(id);
        int res=stockService.del(id);
        return JSON.toJSONString(res) ;
    }



    @ResponseBody
    @RequestMapping(value = "getInfo/{intdentName}",produces="text/plain;charset=utf-8")
    public String getDetail(@PathVariable("intdentName") String intdentName){
        return JSON.toJSONString(stockService.getInfo(intdentName));
    }


    @ResponseBody
    @RequestMapping("getdel")
    public String getdel(@RequestParam("arrays[]") Object[] arrays){
        List<Object> list=new ArrayList<Object>();
        int i=0;
        for (i = 0; i <arrays.length ; i++) {
            System.out.println(arrays[i]);
            list.add(arrays[i]);
        }
        return JSON.toJSONString(stockService.delesc(list));
    }

    @ResponseBody
    @RequestMapping("InsertStock")
    public String InsertStock(OrderfoodStock stock) {
        return JSON.toJSONString(stockService.InsertStock(stock));
    }


    @ResponseBody
    @RequestMapping("UpdateStock")
    public String UpdateStock(OrderfoodStock stock) {
        return JSON.toJSONString(stockService.UpdateStock(stock));
    }


    @RequestMapping("/task")
    public ModelAndView task() {
        ModelAndView model = new ModelAndView("task/TaskUpd");
        return model;
    }


    @RequestMapping("upd")
    public ModelAndView upd() {
        ModelAndView model = new ModelAndView("task/TaskUpdd");
        return model;
    }


    @ResponseBody
    @RequestMapping(value = "getId/{id}",produces="text/plain;charset=utf-8")
    public String getId(@PathVariable("id") int id){
        return JSON.toJSONString(stockService.getId(id));
    }




    @ResponseBody
    @RequestMapping(value = "StockInfo/{pageNow}",produces = "text/html;charset=UTF-8")
    public String ShowCargoInfo(@PathVariable(value = "pageNow") String pageNow){
        //获取当前页数
        //获取数据总条数
        System.out.println(pageNow);
        Integer totalCount=stockService.stockCont();
        CargoPage cargoPage=null;
        List<OrderfoodStock> list=new ArrayList<OrderfoodStock>();
        Integer pageNo=Integer.parseInt(pageNow);
        if(pageNo>0){
            cargoPage=new CargoPage(pageNo,totalCount);
            list=this.stockService.stockPage(cargoPage.getStartPos(),cargoPage.getPageSize());
        }else {
            cargoPage =new CargoPage(1,totalCount);
            list=this.stockService.stockPage(cargoPage.getStartPos(),cargoPage.getPageSize());
        }
        System.out.println(JSON.toJSONString(list));
        return JSON.toJSONString(list);
    }

    @ResponseBody
    @RequestMapping("getPageCount")
    public String getPageCount(){
        Integer totalCount=stockService.stockCont();
        Integer Count=totalCount/8;
        Integer PageCount=0;
        PageCount=totalCount%8==0?Count:Count+1;
        return JSON.toJSONString(PageCount);
    }







}


