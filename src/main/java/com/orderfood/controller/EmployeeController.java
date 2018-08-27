package com.orderfood.controller;

import com.orderfood.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class EmployeeController {
    @Resource(name="employeeService")
    private EmployeeService employeeService;
    @RequestMapping("employee")
    public ModelAndView EmployeeAll(){
        ModelAndView model=new ModelAndView("rsxz/Employlee");
        model.addObject("employees",employeeService.SelectEmployee(null));
        return model;
    }
}
