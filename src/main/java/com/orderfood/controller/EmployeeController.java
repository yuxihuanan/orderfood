package com.orderfood.controller;

import com.orderfood.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import javax.annotation.Resource;

@Controller
public class EmployeeController {
    @Resource(name="employeeService")
    private EmployeeService employeeService;
    @RequestMapping("employeeAll")
    public ModelAndView EmployeeAll(){
        ModelAndView model=new ModelAndView("rsxz/Employlee");
        model.addObject("employees",employeeService.getAllEm());
        return model;
    }

    @ResponseBody
    @RequestMapping("employeeDel/{employeeid}")
    public String EmployDel(@PathVariable(value = "employeeid") int employeeid){
        return JSON.toJSONString(employeeService.delEm(employeeid));
    }
}
