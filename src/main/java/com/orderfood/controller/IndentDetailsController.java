package com.orderfood.controller;

import com.orderfood.pojo.OrderfoodIndentDetails;
import com.orderfood.service.IndentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndentDetailsController {

    @Autowired
    private IndentDetailsService indentDetailsService;

    @RequestMapping("getDetail")
    public ModelAndView getDetail(){
        ModelAndView model=new ModelAndView("");
        model.addObject("Details",indentDetailsService.getDetail("3"));
        return model;
    }
}
