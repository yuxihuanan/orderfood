package com.orderfood.controller;

import com.alibaba.fastjson.JSON;
import com.orderfood.pojo.OrderfoodEmployee;
import com.orderfood.pojo.OrderfoodEmployeeRole;
import com.orderfood.service.EmployeeRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeRodeController {
    @Autowired
    private EmployeeRoleService employeeRoleService;

    /**
     * 查询全部角色
     * @return
     */
    @RequestMapping("employeeRodeAll")
    public ModelAndView EmployeeRodeAll(){
        ModelAndView model=new ModelAndView("rsxz/EmployeeDetail");
        model.addObject("employeesdetail",employeeRoleService.getAllRo());
        return model;
    }

    /**
     * 查询全部角色
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "EmployeeselAll",produces = "text/html;charset=UTF-8")
    public String EmployeeselAll(){
       return JSON.toJSONString(employeeRoleService.selAll());
    }

    /**
     * 根据id删除角色信息
     * @param roleid
     * @return
     */
    @ResponseBody
    @RequestMapping("employeeRoDel/{roleid}")
    public String EmployRoDel(@PathVariable(value = "roleid") int roleid){
        return JSON.toJSONString(employeeRoleService.delAndUpd(roleid));
    }

    /**
     * 添加角色信息
     * @param orderfoodEmployeeRole
     * @return
     */
    @ResponseBody
    @RequestMapping("employeeRoAdd")
    public String EmployRoAdd(OrderfoodEmployeeRole orderfoodEmployeeRole){
        return JSON.toJSONString(employeeRoleService.addRo(orderfoodEmployeeRole));
    }

    /**
     * 修改角色信息
     * @param orderfoodEmployeeRole
     * @return
     */
    @ResponseBody
    @RequestMapping("employeeRoUpd")
    public String EmployRoUpd(OrderfoodEmployeeRole orderfoodEmployeeRole){
        return JSON.toJSONString(employeeRoleService.updRo(orderfoodEmployeeRole));
    }

    /**
     * 传修改对象
     * @param roleid
     * @return
     */
    @RequestMapping("employeeRoUpdpage")
    public ModelAndView EmployeeUpd(Integer roleid){
        ModelAndView mode4 = new ModelAndView("rsxz/UpdEmployeeDetail");
        OrderfoodEmployeeRole orderfoodEmployeeRole=employeeRoleService.selRo(roleid);
        mode4.addObject("orderfoodEmployeeRole",orderfoodEmployeeRole);
        return mode4;
    }

    /**
     * 跳转添加角色
     * @return
     */
    @RequestMapping("employeeRoAddpage")
    public ModelAndView employeeRoAddpage(){
        ModelAndView mode2=new ModelAndView("rsxz/AddEmployeeDetail");
        return mode2;
    }
    /**
     * 跳转修改页面
     * @param id
     * @return
     */
    @RequestMapping("employeeRoUpdpage/{id}")
    public ModelAndView EmployeeRoUpd(@PathVariable(value = "id") Integer id){
        ModelAndView mode3 = new ModelAndView("rsxz/UpdEmployeeDetail");
        OrderfoodEmployeeRole orderfoodEmployeeRole=employeeRoleService.selRo(id);
        mode3.addObject("orderfoodEmployeeRole",orderfoodEmployeeRole);
        return mode3;
    }
}
