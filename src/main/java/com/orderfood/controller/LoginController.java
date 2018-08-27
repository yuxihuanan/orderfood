package com.orderfood.controller;

import com.orderfood.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class LoginController {
    @Resource(name="login")
    private LoginService login;
    @RequestMapping("login")
    public ModelAndView  Login()
    {
        ModelAndView model=new ModelAndView("index");
        model.addObject("users",login.AdminLogin(null));
        return model;
    }
}
