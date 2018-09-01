package com.orderfood.controller;

import com.alibaba.fastjson.JSON;
import com.orderfood.pojo.CargoPage;
import com.orderfood.pojo.OrderfoodRunningData;
import com.orderfood.service.CargoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
        /*mav.addObject("sum",cargoService.selRawStock(26));*/
        return mav;
    }

    @ResponseBody
    @RequestMapping("updCargo")
    public String updCargo(OrderfoodCargo cargo){
        System.out.println(cargo.getCargoprice());
        System.out.println(cargo.getCargoweight());
        cargo.setCargoid(cargid);
        return JSON.toJSONString(cargoService.UpdateCargo(cargo));
    }

    @RequestMapping("toOrderClass")
    public ModelAndView toOrderClass(){
        ModelAndView mav=new ModelAndView("client/OrderClass");
        return mav;
    }
    @ResponseBody
    @RequestMapping(value = "adUnitl",produces ="text/html;charset=UTF-8")
    public String  adUnitl(){
        return JSON.toJSONString(cargoService.getUnitl());
    }
    @RequestMapping("toAddOrder")
    public ModelAndView toAddOrder(){
        ModelAndView mav=new ModelAndView("client/AddOrder");
        return mav;
    }

    @ResponseBody
    @RequestMapping("insCargo")
    public String insCargo(OrderfoodCargo cargo, OrderfoodRunningData runningData){
        System.out.println(cargo.getCargoprice());
        System.out.println(runningData.getDataprice());
        return JSON.toJSONString(cargoService.InsertInfo(cargo,runningData));
    }

    @ResponseBody
    @RequestMapping("mandel")
    public String manDel(@RequestParam(value = "arrays[]") Object[] arrays){
        List<Object> list=new ArrayList<Object>();
        int i;
        for (i=0;i<arrays.length;i++){
            System.out.println(arrays[i]);
            list.add(arrays[i]);
        }
        return JSON.toJSONString(cargoService.delCargo(list));
    }

    @ResponseBody
    @RequestMapping(value = "toCargoEditor",produces = "text/html;charset=UTF-8")
    public String toCargoEditor(){
        return JSON.toJSONString(cargoService.SelectCargo(cargid));
    }

    @RequestMapping("ToCargoEditor")
    public ModelAndView ToCargoEditor(){
        ModelAndView mav=new ModelAndView("client/OrderShow");
        return mav;
    }

    private Integer cargid=0;

    @RequestMapping("toEditor/{Cargoid}")
    public String toEditor(@PathVariable(value = "Cargoid") Integer Cargoid){
        this.cargid=Cargoid;

        return "redirect:/CargoController/ToCargoEditor";
    }

    @ResponseBody
    @RequestMapping(value = "ShowCargoInfo/{pageNow}",produces = "text/html;charset=UTF-8")
    public String ShowCargoInfo(@PathVariable(value = "pageNow") String pageNow){
        //获取当前页数
        //获取数据总条数
        System.out.println(pageNow);
        Integer totalCount=cargoService.findNewCont();
        CargoPage cargoPage=null;
        List<OrderfoodCargo> list=new ArrayList<OrderfoodCargo>();
        Integer pageNo=Integer.parseInt(pageNow);
        if(pageNo>0){
            cargoPage=new CargoPage(pageNo,totalCount);
            list=this.cargoService.findNewsPage(cargoPage.getStartPos(),cargoPage.getPageSize());
        }else {
            cargoPage =new CargoPage(1,totalCount);
            list=this.cargoService.findNewsPage(cargoPage.getStartPos(),cargoPage.getPageSize());
        }
        System.out.println(JSON.toJSONString(list));
        return JSON.toJSONString(list);
    }

    @ResponseBody
    @RequestMapping("getPageCount")
    public String getPageCount(){
        Integer totalCount=cargoService.findNewCont();
        Integer Count=totalCount/8;
        Integer PageCount=0;
        PageCount=totalCount%8==0?Count:Count+1;
        return JSON.toJSONString(PageCount);
    }
    @ResponseBody
    @RequestMapping(value = "findLike/{pageNow}",produces = "text/html;charset=UTF-8")
    public String findLike(@Param(value = "stockname") String stockname,@PathVariable(value = "pageNow") String pageNow){
        //获取当前页数
        //获取数据总条数
        System.out.println(stockname);
        System.out.println(pageNow);
        Integer totalCount=cargoService.findLikeCount(stockname);
        CargoPage cargoPage=null;
        List<OrderfoodCargo> list=new ArrayList<OrderfoodCargo>();
        Integer pageNo=Integer.parseInt(pageNow);
        if(pageNo>0){
            cargoPage=new CargoPage(pageNo,totalCount);
            list=this.cargoService.findLike(stockname,cargoPage.getStartPos(),cargoPage.getPageSize());

        }else {
            cargoPage =new CargoPage(1,totalCount);
            list=this.cargoService.findLike(stockname,cargoPage.getStartPos(),cargoPage.getPageSize());
        }
        System.out.println(JSON.toJSONString(list));
        return JSON.toJSONString(list);
    }
    @ResponseBody
    @RequestMapping("getLikePageCount")
    public String getLikePageCount(@Param(value = "stockname") String stockname){
        Integer totalCount=cargoService.findLikeCount(stockname);
        Integer Count=totalCount/2;
        Integer PageCount=0;
        PageCount=totalCount%2==0?Count:Count+1;
        return JSON.toJSONString(PageCount);
    }

    @ResponseBody
    @RequestMapping("weightSum/{stockname}")
    public ModelAndView weightSum(@Param(value = "stockname") String stockname){
        System.out.println(stockname);
        ModelAndView mav=new ModelAndView("client/OrderClass");
        mav.addObject(cargoService.weightSum(stockname));
        return mav;
    }
}
