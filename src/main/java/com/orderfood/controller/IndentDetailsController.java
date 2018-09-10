package com.orderfood.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.orderfood.pojo.*;
import com.orderfood.service.CuisineClassifyService;
import com.orderfood.service.IndentDetailsService;
import com.orderfood.util.CommonUtil;
import com.orderfood.util.EsUtil;
import com.orderfood.util.PrintUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.UnknownHostException;
import java.util.List;

@Controller
@RequestMapping("IndentDetails")
public class IndentDetailsController {

    @Autowired
    private IndentDetailsService indentDetailsService;

    @Autowired
    private CuisineClassifyService cuisineClassifyService;

    /**
     * 查看订单详情
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getDetail",produces = "text/plain;charset=utf-8")
    public String getDetail(String tableId){
        CommonUtil.IndentCode();
        return JSON.toJSONString(indentDetailsService.getDetail(tableId));
    }

    /**
     * 修改订单详情
     * @return
     */
    @ResponseBody
    @RequestMapping("updateDetails")
    public String updateDetails(OrderfoodIndentDetails orderfoodIndentDetails){
        return JSON.toJSONString(indentDetailsService.updateDetails(orderfoodIndentDetails));
    }

    /**
     * 删除订单详情
     * @return
     */
    @ResponseBody
    @RequestMapping("deleteDetaiils")
    public String deleteDetaiils(OrderfoodIndentDetails orderfoodIndentDetails){
        return JSON.toJSONString(indentDetailsService.deleteDetaiils(orderfoodIndentDetails));
    }

    /**
     * 添加订单详情
     * @return
     */
    @ResponseBody
    @RequestMapping("addDetails")
    public String addDetails(OrderfoodIndentDetails orderfoodIndentDetails){
        indentDetailsService.addDetails(orderfoodIndentDetails);
        return null;
    }

    /**
     * 添加新的订单
     * @param orderfoodIndent
     * @return
     */
    @ResponseBody
    @RequestMapping("addIndent")
    public String addIndent(OrderfoodIndent orderfoodIndent){
        String code=CommonUtil.IndentCode(); //随机订单号
        orderfoodIndent.setIndentcode(code);
        indentDetailsService.addIndent(orderfoodIndent);
        //返回一个订单id
        return JSON.toJSONString(indentDetailsService.getDetailsIdByIndentCode(code));
    }

    /**
     * 当订单为空时删除该订单
     * @param indentid
     * @return
     */
    @ResponseBody
    @RequestMapping("deleteIndent")
    public String deleteIndent(int indentid){
        return JSON.toJSONString(indentDetailsService.deleteIndent(indentid));
    }

    /**
     * 打印订单
     * @return
     */
    @ResponseBody
    @RequestMapping("dayinIndent")
    public String dayinIndent(String indentId,int sta){
        PrintUtil.print(indentDetailsService.getDetailByTableId(indentId),sta);
        return "1";
    }

    /**
     * 得到所有的菜单分类以及菜品
     * @param classifyId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getAllClassify",produces = "text/plain;charset=utf-8")
    public String getAllClassify(Integer classifyId){
        return JSON.toJSONString(indentDetailsService.getAllClassify(classifyId));
    }

    /**
     * 根据用户的手机号获得用户的历史订单
     * @param phone
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getAllIndentsByPhone",produces = "text/plain;charset=utf-8")
    public String getAllIndentsByPhone(String phone){
        return JSON.toJSONString(indentDetailsService.getAllIndentsByPhone(phone));
    }

    /**
     * 添加用户订单信息
     * @param orderInfo
     * @return
     */
    @ResponseBody
    @RequestMapping("addUserIndentInfo")
    public String addUserIndentInfo(String orderInfo,int zhuohao,float orderPrice,String phone){
        try{
            //得到的json字符串转换为List集合,然后需要先获得数量，才知道添加哪一份菜，并创建一个订单
            List<OrderfoodCuisineClassify> fs=JSONObject.parseArray(orderInfo,OrderfoodCuisineClassify.class);

            //创建订单
            String code=CommonUtil.IndentCode(); //随机订单号
            OrderfoodIndent orderfoodIndent=new OrderfoodIndent();
            orderfoodIndent.setIndentcode(code);
            orderfoodIndent.setiTableid(zhuohao);//桌子编号
            orderfoodIndent.setTotalmoney(orderPrice);//订单总金额
            orderfoodIndent.setUserId(indentDetailsService.getUserIdByPhone(phone)); //用户编号
            //添加订单
            indentDetailsService.addIndent(orderfoodIndent);
            //返回一个订单id
            int indentId=indentDetailsService.getDetailsIdByIndentCode(code);
            for (OrderfoodCuisineClassify cfy : fs) {
                for (OrderfoodCuisine c: cfy.getCuss()) {
                    if(c.getCount()>0){
                        OrderfoodIndentDetails orderfoodIndentDetails=new OrderfoodIndentDetails();
                        orderfoodIndentDetails.setdCuisineid(c.getCuisineid());
                        orderfoodIndentDetails.setDetailscount(c.getCount());
                        orderfoodIndentDetails.setdIndentid(indentId);
                        //添加订单详情
                        indentDetailsService.addDetails(orderfoodIndentDetails);
                    }
                }
            }
            OrderfoodTable orderfoodTable=new OrderfoodTable();
            orderfoodTable.setTableid(zhuohao);
            orderfoodTable.setTablestatus(1);
            indentDetailsService.updateTableStatu(orderfoodTable);
            return "success";
        }catch (Exception e){
            return "error";
        }
    }

    /**
     * 得到所有的桌子
     * @return
     */
    @ResponseBody
    @RequestMapping("getAllTables")
    public String getAllTables(){
        return JSON.toJSONString(indentDetailsService.getAllTables());
    }
}
