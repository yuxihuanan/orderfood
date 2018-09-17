package com.orderfood.controller;


import com.alibaba.fastjson.JSONObject;
import com.orderfood.pojo.OrderfoodEmployee;
import com.orderfood.pojo.OrderfoodMenu;
import com.orderfood.service.LoginService;
import com.orderfood.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
    private RedisUtils redisUtils;

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
    if(redisUtils.get("user")==null) {
            model.setViewName("login");
    }else{
        OrderfoodEmployee employeeList=JSONObject.parseObject(redisUtils.get("user").toString(),OrderfoodEmployee.class);
        model.addObject("user",employeeList);
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
        OrderfoodEmployee employeeList=null;
        if(employee!=null) {
             employee1= login.AdminLogin(employee);
             if(employee1!=null) {
                 redisUtils.set("user", JSON.toJSONString(employee1));
                 employeeList=JSONObject.parseObject(redisUtils.get("user").toString(),OrderfoodEmployee.class);
             }
        }
            return JSON.toJSONString(employeeList);
    }

    /**
     * 跳转登录页面
     * @param request
     * @return
     */
    @RequestMapping(value = "login",produces = "text/plain;charset=utf-8")
    public ModelAndView loginPage(HttpServletRequest request){
        OrderfoodEmployee employeeList=JSONObject.parseObject(redisUtils.get("user").toString(),OrderfoodEmployee.class);
        if(null==employeeList){
            model.setViewName("login");
        }else{
                model.setViewName("index");
            model.addObject("user", employeeList);
        }
        return model;
    }

    /**
     * 注销
     * @return
     */
    @RequestMapping(value = "die",produces = "text/plain;charset=utf-8")
    public ModelAndView die(HttpServletRequest request){
            redisUtils.delete("user");
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
