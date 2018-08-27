package com.orderfood.controller;


import com.orderfood.pojo.OrderfoodIndent;
import com.orderfood.service.IndentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@RestController
public class OrderfoodIndentController {

    @Autowired
    private IndentService indentService;
   @RequestMapping("getAll")
    public List<OrderfoodIndent> getAll(){
        List<OrderfoodIndent> s=indentService.getAll();
        System.out.print(1);
        return null;
    }

}
