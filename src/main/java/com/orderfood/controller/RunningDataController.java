package com.orderfood.controller;

import com.orderfood.pojo.OrderfoodRunningData;
import com.orderfood.service.RunningDataService;
import com.orderfood.service.impl.RunningDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 收支流水
 */
@Controller
public class RunningDataController {
    private ModelAndView model=new ModelAndView();
    @Autowired
    private RunningDataService runningDataService;
    @RequestMapping(value = "selectrunningDatapage", produces = "text/plain;charset=utf-8")
    private ModelAndView selectRunningDatapage(HttpServletRequest request){
        if(null==request.getSession().getAttribute("user")){
            model.setViewName("login");
        }else {
            model.setViewName("item/Item");
        }
        return model;
    }
    /**
     * 查询收支状况
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "selectrunningData",produces = "text/plain;charset=utf-8")
    public String selectRunningData(OrderfoodRunningData runningData){
        return JSON.toJSONString(runningDataService.SelectRunningData(runningData));
    }
}
