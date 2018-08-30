package com.orderfood.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.orderfood.config.RedisUtil;
import com.orderfood.pojo.OrderfoodCuisine;
import com.orderfood.pojo.OrderfoodTable;
import com.orderfood.pojo.myMeum;
import com.orderfood.service.CashierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
    /**
     * @Author LYX
     * 跳转页面
     * @return 我的菜单
     */
    @RequestMapping("MymenmShow")
    public ModelAndView MymenmShow(){
        ModelAndView modelAndView=new ModelAndView("page/Mymenu");
        String info=RedisUtil.getRu().get("lyx"+Zhuohao);
        System.out.println(info);
        List<myMeum> list=JSONObject.parseArray(info,myMeum.class);
        List<myMeum> list1=list;
        for (int i = 0; i < list.size()-1; i++) {
            for (int j = i+1; j <list1.size() ;) {
                if(list.get(i).getName().equals(list.get(j).getName())){
                    list.get(i).setNum(list.get(i).getNum()+1);
                    list1.remove(j);
                    continue;
                }
                j++;
            }
            System.out.println(list.get(i).getName()+"   "+list.get(i).getPrice()+"      "+list.get(i).getNum());
        }
        modelAndView.addObject("myMeum",list);
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
     * @Author LYX
     * 修改桌子信息
     * @return int
     */
    @RequestMapping("OrderTableUpadte/{tableid}/{tablenumber}/{tablestatus}")
    public String OrderTableUpadte(@PathVariable Integer tableid,@PathVariable Integer tablenumber,@PathVariable Integer tablestatus){
        OrderfoodTable orderfoodTable=new OrderfoodTable();
        orderfoodTable.setTableid(tableid);
        orderfoodTable.setTablenumber(tablenumber);
        orderfoodTable.setTablestatus(tablestatus);
        int res=cashierService.Choosetable(orderfoodTable);
        return "redirect:/OrdermealShow";
    }
    @ResponseBody
    @RequestMapping("tableshow")
    /**
     * 拿到最后下单的json数据存入json
     */
    public String tableshow(String sss){
        String res=RedisUtil.getRu().set("lyx"+Zhuohao,sss);
        return JSON.toJSONString(res);
    }

    /**
     * @Author LYX
     * 跳转页面下单页面
     * @return modelandview
     */
    @RequestMapping("TableDetailsShow")
    public ModelAndView TableDetailsShow(){
        ModelAndView modelAndView=new ModelAndView("page/tablesdetails");
        String info=RedisUtil.getRu().get("lyx"+Zhuohao);
        System.out.println(info);
        List<myMeum> list=JSONObject.parseArray(info,myMeum.class);
        System.out.println(JSON.toJSONString(list));
        modelAndView.addObject("CusineCade",list);
        modelAndView.addObject("tableId",Zhuohao);
        modelAndView.addObject("statu",0);
        return modelAndView;
    }

    @RequestMapping("ZaiyongZhuo")
    /**
     * 加入桌子有人的话就进订单页面
     */
    public ModelAndView ZaiyongZhuo(){
        ModelAndView modelAndView=new ModelAndView("page/tablesdetails");
        modelAndView.addObject("statu",1);
        return modelAndView;
    }
}
