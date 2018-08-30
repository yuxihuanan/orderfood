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
     * @return 我的菜单
     */
    @RequestMapping("MymenmShow")
    public ModelAndView MymenmShow(){
        ModelAndView modelAndView=new ModelAndView("page/Mymenu");
        String info=RedisUtil.getRu().get("lyx"+Zhuohao);
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
    private Integer status;
    private Integer detailId;
    @RequestMapping("OrdermealShow")
    public ModelAndView OrdermealShow(Integer statu,Integer detailId){
        ModelAndView modelAndView=new ModelAndView("page/Ordermeal");
        List<OrderfoodCuisine> list=cashierService.getOrderfoodCuisineAll();
        List lists=new ArrayList();
        modelAndView.addObject("foodCuisine",list);
        modelAndView.addObject("zhuanhao",false);
        modelAndView.addObject("dingdan",lists);
        this.status=statu;
        this.detailId=detailId;
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
        return "redirect:/OrdermealShow?statu=0&detailId=0";
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
    @RequestMapping("OrderTableUpadte/{tablestatus}")
    public String OrderTableUpadte(@PathVariable("tablestatus") Integer tablestatus){
        OrderfoodTable orderfoodTable=new OrderfoodTable();
        orderfoodTable.setTableid(Zhuohao);
        orderfoodTable.setTablenumber(Zhuohao);
        orderfoodTable.setTablestatus(tablestatus);
        RedisUtil.getRu().del("lyx"+Zhuohao);
        int res=cashierService.Choosetable(orderfoodTable);
        return "redirect:/OrdrTableShow";
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
        modelAndView.addObject("tableId",Zhuohao);
        modelAndView.addObject("statu",status);
        modelAndView.addObject("detailId",detailId);
        System.out.println(status);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "getTableDetailsShow",produces = "text/plain;charset=utf-8")
    public String getTableDetailsShow(){
        String info=RedisUtil.getRu().get("lyx"+Zhuohao);
        List<myMeum> list=JSONObject.parseArray(info,myMeum.class);
        return JSON.toJSONString(list);
    }

    @RequestMapping("ZaiyongZhuo/{id}")
    /**
     * 获取桌子id
     */
    public String ZaiyongZhuo(@PathVariable Integer id){
        this.Zhuohao=id;
        return "redirect:/ZaiyongZhuoShow";
    }

    /**
     * 加入桌子有人的话就进订单页面
     * @return
     */
    @RequestMapping("ZaiyongZhuoShow")
    public ModelAndView ZaiyongZhuoShow(){
        ModelAndView modelAndView=new ModelAndView("page/tablesdetails");
        modelAndView.addObject("statu",1);
        modelAndView.addObject("tableId",Zhuohao);
        return modelAndView;
    }
    @RequestMapping("OrdermealShowTwo")
    public ModelAndView OrdermealShowTwo(){
        ModelAndView modelAndView=new ModelAndView("page/Ordermeal");
        List<OrderfoodCuisine> list=cashierService.getOrderfoodCuisineAll();
        String info=RedisUtil.getRu().get("lyx"+Zhuohao);
        List<myMeum> lists=JSONObject.parseArray(info,myMeum.class);
        modelAndView.addObject("foodCuisine",list);
        modelAndView.addObject("zhuanhao",false);
        modelAndView.addObject("dingdan",lists);
        return modelAndView;
    }
}
