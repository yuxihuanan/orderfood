package com.orderfood.controller;

import com.orderfood.pojo.OrderfoodEmployee;
import com.orderfood.pojo.OrderfoodJurisdiction;
import com.orderfood.pojo.OrderfoodMenu;
import com.orderfood.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.*;

import java.util.List;

@Controller
public class LoginController {
    @Resource(name="loginService")
    private LoginService login;
    private ModelAndView model=new ModelAndView();
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 首页获取菜单
     * @return
     */
    @ResponseBody
    @RequestMapping( value = "indexMenu",produces = "text/plain;charset=utf-8")
    public String indextion(Integer roleId,HttpServletRequest request){
        return JSON.toJSONString(login.GetJurisdiction(roleId));
    }

    /**
     * 跳转首页
     * @param request
     * @return
     */
    @RequestMapping(value = "shouye",produces = "text/plain;charset=utf-8")
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
        OrderfoodEmployee employee1=new OrderfoodEmployee();
        if(employee!=null) {
             employee1= login.AdminLogin(employee);
            request.getSession().setAttribute("user", employee1);
        }
            return JSON.toJSONString(employee1);
    }

    /**
     * 跳转登录页面
     * @param request
     * @return
     */
    @RequestMapping(value = "login",produces = "text/plain;charset=utf-8")
    public ModelAndView loginPage(HttpServletRequest request){
        if(request.getSession().getAttribute("user")==null){
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

    /**
     * 去首页
     * @return
     */
    @RequestMapping("index1")
    public ModelAndView index1(){
        model.setViewName("index1");
        return model;
    }

    /**
     * 首页跳转其他页面
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "jump",produces = "text/plain;charset=utf-8")
    public String tiaozhuan(OrderfoodMenu menu){
        List<OrderfoodMenu> menus = login.selectMenu(menu);
        return JSON.toJSONString(menus);
    }
}
