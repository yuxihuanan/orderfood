package com.orderfood.controller;

import com.orderfood.pojo.OrderfoodEmployee;
import com.orderfood.pojo.OrderfoodEmployeeRole;
import com.orderfood.service.EmployeeRoleService;
import com.orderfood.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    /**
     * 查询全部员工
     * @return
     */
    @RequestMapping("employeeAll")
    public ModelAndView EmployeeAll(){
        ModelAndView model=new ModelAndView("rsxz/Employlee");
        model.addObject("employees",employeeService.getAllEm());
        return model;
    }
    /**
     * 添加员工信息
     * @param orderfoodEmployee
     * @return
     */
    @ResponseBody
    @RequestMapping("employeeAdd")
    public String EmployAdd(OrderfoodEmployee orderfoodEmployee){
        return JSON.toJSONString(employeeService.addEm(orderfoodEmployee));
    }

    /**
     * 修改员工信息
     * @param orderfoodEmployee
     * @return
     */
    @ResponseBody
    @RequestMapping("employeeUpd")
    public String EmployUpd(OrderfoodEmployee orderfoodEmployee){
        return  JSON.toJSONString(employeeService.updEm(orderfoodEmployee));
    }

    /**
     * 根据姓名查员工信息
     * @param employeename
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "EmploySel/{employeename}",produces = "text/html;charset=UTF-8")
    public String EmploySel(@PathVariable(value = "employeename")String employeename){
        System.out.println(JSON.toJSONString(employeeService.selTwo(employeename)));
        return JSON.toJSONString(employeeService.selTwo(employeename));
    }

    /**
     * 批量删除
     * @param arrays
     * @return
     */
    @ResponseBody
    @RequestMapping("delesc")
    public String delesc(@RequestParam("arrays[]")Object[] arrays){
        List<Object> list = new ArrayList<Object>();
        int i = 0;
        for (i=0;i<arrays.length;i++){
            System.out.print(arrays[i]);
            list.add(arrays[i]);
        }
       int a= employeeService.delesc(list);
        return JSON.toJSONString(a);
    }














    /**
     * 跳转添加员工
     * @return
     */
    @RequestMapping("employeeAddpage")
    public ModelAndView EmployeeAdd(){
        ModelAndView model=new ModelAndView("rsxz/AddEmploylee");
        return model;
    }

    /**
     * 传修改对象
     * @param id
     * @return
     */
    @RequestMapping("employeeUpdpage")
    public ModelAndView EmployeeUpd(Integer id){
        System.out.print(id);
        ModelAndView mode2 = new ModelAndView("rsxz/UpdEmploylee");
        OrderfoodEmployee orderfoodEmployee=employeeService.selEm(id);
        mode2.addObject("orderfoodEmployee",orderfoodEmployee);
        return mode2;
    }
}
