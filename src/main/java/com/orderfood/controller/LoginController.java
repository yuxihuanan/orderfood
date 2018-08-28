package com.orderfood.controller;

import com.orderfood.pojo.OrderfoodEmployee;
import com.orderfood.pojo.OrderfoodJurisdiction;
import com.orderfood.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.*;
@Controller
public class LoginController {
    @Resource(name="loginService")
    private LoginService login;
    private ModelAndView model=new ModelAndView();

    /**
     * 首页获取菜单
     * @return
     */
    @ResponseBody
    @RequestMapping( value = "indextion",produces = "text/plain;charset=utf-8")
    public String indextion(Integer roleId){
        System.out.println(JSON.toJSONString(login.GetJurisdiction(roleId)));
        return JSON.toJSONString(login.GetJurisdiction(roleId));
    }

    /**
     * 跳转首页
     * @param request
     * @return
     */
    @RequestMapping(value = "index",produces = "text/plain;charset=utf-8")
public ModelAndView index(HttpServletRequest request){
    if(request.getSession().getAttribute("user")==null) {
            model.setViewName("login");
    }else{
        model.addObject("user",request.getSession().getAttribute("user"));
        model.setViewName("index");

    }
    return model;
}
    /**
     * 登录
     * @param employee
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "loginorder",produces = "text/plain;charset=utf-8")
    public String  Login(OrderfoodEmployee employee,HttpServletRequest request)
    {
            OrderfoodEmployee employee1=login.AdminLogin(employee);
            request.getSession().setAttribute("user",employee1);
            return JSON.toJSONString(employee1);
    }

    /**
     * 跳转登录页面
     * @param request
     * @return
     */
    @RequestMapping(value = "login",produces = "text/plain;charset=utf-8")
    public ModelAndView loginPage(HttpServletRequest request){
        if(null==request.getSession().getAttribute("user")){
            model.setViewName("login");
        }else{
            model.setViewName("index");
            model.addObject("user", request.getSession().getAttribute("user"));
        }
        return model;
    }

    /**
     * 注销
     * @return
     */
    @RequestMapping(value = "die",produces = "text/plain;charset=utf-8")
    public ModelAndView die(HttpServletRequest request){
            request.getSession().removeAttribute("user");
            model.setViewName("login");
            return model;
    }
}
