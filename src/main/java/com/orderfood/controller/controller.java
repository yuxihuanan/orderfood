package com.orderfood.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class controller {

    @RequestMapping("index")
    public ModelAndView goIndex()
    {
        ModelAndView model=new ModelAndView("index");
        model.addObject("user","123456");
        return model;
    }

}
