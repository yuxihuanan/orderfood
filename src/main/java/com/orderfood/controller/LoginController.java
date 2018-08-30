package com.orderfood.controller;

import com.orderfood.config.CacheConfiguration;
import com.orderfood.pojo.OrderfoodEmployee;
import com.orderfood.service.LoginService;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import com.alibaba.fastjson.*;
import redis.clients.jedis.Jedis;

@Controller
public class LoginController {
    @Resource(name="loginService")
    private LoginService login;
    private ModelAndView model=new ModelAndView();

    private CacheConfiguration cacheConfiguration;

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
        System.out.println(request.getSession().getAttribute("user"));
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
        //Jedis jedis=new Jedis();
//        jedis.set("user",JSON.toJSONString(employee1));
//        System.out.println(jedis.get("user"));
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

    @RequestMapping("index1")
    public ModelAndView index1(){
        model.setViewName("index1");
        return model;
    }
}
