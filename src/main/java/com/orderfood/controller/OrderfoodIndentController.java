package com.orderfood.controller;


import com.alibaba.fastjson.JSON;
import com.orderfood.pojo.OrderfoodIndent;
import com.orderfood.service.IndentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
@Controller
@RequestMapping("Indent")
public class OrderfoodIndentController {

    @Autowired
    private IndentService indentService;

    /**
     * 查询所有信息
     * @return
     */
   @RequestMapping("getAll")
  public ModelAndView modelAndView(){
       ModelAndView model=new ModelAndView("item/Indent");
       model.addObject("indent",indentService.getAll());
       return model;
   }

    /**
     * 根据id查询订单
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getInfo/{id}",produces = "text/plain;charset=utf-8")
    public String getInfo(@PathVariable("id") Integer id){
        return JSON.toJSONString(indentService.getInfo(id));
    }

    /**
     *  根据订单id查询订单详情
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getDetail/{id}",produces = "text/plain;charset=utf-8")
    public String getDetail(@PathVariable("id") Integer id){
        return JSON.toJSONString(indentService.getDetails(id));
    }

    /**
     * 根据id删除订单记录
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("del/{id}")
    public String del(@PathVariable("id") Integer id){
        return JSON.toJSONString(indentService.delIndent(id));
    }

    @RequestMapping("tail")
    public ModelAndView tail(){
        ModelAndView mode = new ModelAndView("item/IndentDetail");
        return mode;
    }
}
