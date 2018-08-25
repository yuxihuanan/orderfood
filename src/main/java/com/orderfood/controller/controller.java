package com.orderfood.controller;

import com.orderfood.service.impl.LoginServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class controller {
    @Resource(name="login")
    private LoginServiceImpl login;
    @RequestMapping("index")
    public ModelAndView goIndex()
    {
        ModelAndView model=new ModelAndView("index");
        model.addObject("users",login.AdminLogin(null));
        model.addObject("use","222");
        model.addObject("ss",true);
        return model;
    }

}
