package com.orderfood.controller;

import com.orderfood.pojo.OrderfoodIndentDetails;
import com.orderfood.service.IndentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("IndentDetails")
public class IndentDetailsController {

    @Autowired
    private IndentDetailsService indentDetailsService;

    /**
     * 查看订单详情
     * @return
     */
    @RequestMapping("getDetail")
    public ModelAndView getDetail(){
        ModelAndView model=new ModelAndView("");
        model.addObject("Details",indentDetailsService.getDetail("3"));
        return model;
    }

    /**
     * 修改订单详情
     * @return
     */
    @RequestMapping("updateDetails")
    public ModelAndView updateDetails(OrderfoodIndentDetails orderfoodIndentDetails){
        ModelAndView model=new ModelAndView("");
        model.addObject("status",indentDetailsService.updateDetails(orderfoodIndentDetails));
        return model;
    }

    /**
     * 删除订单详情
     * @return
     */
    @RequestMapping("deleteDetaiils")
    public ModelAndView deleteDetaiils(int id){
        ModelAndView model=new ModelAndView("");
        model.addObject("status",indentDetailsService.deleteDetaiils(id));
        return model;
    }

    /**
     * 添加订单详情
     * @return
     */
    @RequestMapping("addDetails")
    public ModelAndView addDetails(OrderfoodIndentDetails orderfoodIndentDetails){
        ModelAndView model=new ModelAndView("");
        model.addObject("status",indentDetailsService.addDetails(orderfoodIndentDetails));
        return model;
    }
}
