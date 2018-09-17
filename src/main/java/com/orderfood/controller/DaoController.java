package com.orderfood.controller;

import com.alibaba.fastjson.JSON;
import com.orderfood.pojo.OrderfoodJurisdiction;
import com.orderfood.service.impl.DaoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("Dao")
public class DaoController {
    @Autowired
    private DaoServiceImpl daoService;

    /**
     * 查询管理员
     * @return
     */
    @RequestMapping(value = "getAll",produces = "text/plain;charset=utf-8")
    public ModelAndView modelAndView() {
        ModelAndView model = new ModelAndView("item/Dao");
        model.addObject("dao", daoService.getAll());
        return model;
    }

    /**
     * 根据id查询已有权限
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getMen/{id}", produces = "text/plain;charset=utf-8")
    public String getInfo(@PathVariable("id") Integer id) {
        return JSON.toJSONString(daoService.getMen(id));
    }
    /**
     * 根据id查询非有权限
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getNot/{id}", produces = "text/plain;charset=utf-8")
    public String getNot(@PathVariable("id") Integer id) {

        return JSON.toJSONString(daoService.getNot(id));
    }

    /**
     * 删除权限
     * @param j_classifyid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "del/{j_classifyid}", produces = "text/plain;charset=utf-8")
    public String del(@PathVariable("j_classifyid") Integer j_classifyid){
        return JSON.toJSONString(daoService.del(j_classifyid));
    }

    /**
     * 添加权限
     * @param orderfoodJurisdiction
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "insJurisdiction", produces = "text/plain;charset=utf-8")
    public String insJurisdiction(OrderfoodJurisdiction orderfoodJurisdiction){
        return JSON.toJSONString(daoService.insJurisdiction(orderfoodJurisdiction));
    }
}
