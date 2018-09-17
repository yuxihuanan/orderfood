package com.orderfood.controller;

import com.alibaba.fastjson.JSON;
import com.orderfood.pojo.CargoPage;
import com.orderfood.pojo.OrderfoodRunningData;
import com.orderfood.service.CargoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.orderfood.pojo.OrderfoodCargo;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("CargoController")
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @RequestMapping("toCargo")
    public ModelAndView toCargo(){
        ModelAndView mav=new ModelAndView("client/OrderManager");
        return mav;
    }

    @ResponseBody
    @RequestMapping("updCargo")
    public String updCargo(OrderfoodCargo cargo){
        cargo.setCargoid(cargid);
        return JSON.toJSONString(cargoService.UpdateCargo(cargo));
    }

    @RequestMapping("toOrderClass")
    public ModelAndView toOrderClass(){
        ModelAndView mav=new ModelAndView("client/OrderClass");
        return mav;
    }
    @ResponseBody
    @RequestMapping(value = "adUnitl",produces ="text/html;charset=UTF-8")
    public String  adUnitl(){
        return JSON.toJSONString(cargoService.getUnitl());
    }
    @RequestMapping("toAddOrder")
    public ModelAndView toAddOrder(){
        ModelAndView mav=new ModelAndView("client/AddOrder");
        return mav;
    }

    /**
     * 原料入库
     * @param cargo
     * @param runningData
     * @return
     */
    @ResponseBody
    @RequestMapping("insCargo")
    public String insCargo(OrderfoodCargo cargo, OrderfoodRunningData runningData){
        return JSON.toJSONString(cargoService.InsertInfo(cargo,runningData));
    }

    /**
     * 批量删除
     * @param arrays
     * @return
     */
    @ResponseBody
    @RequestMapping("mandel")
    public String manDel(@RequestParam(value = "arrays[]") Object[] arrays){
        List<Object> list=new ArrayList<Object>();
        int i;
        for (i=0;i<arrays.length;i++){
            System.out.println(arrays[i]);
            list.add(arrays[i]);
        }
        return JSON.toJSONString(cargoService.delCargo(list));
    }


    @ResponseBody
    @RequestMapping(value = "toCargoEditor",produces = "text/html;charset=UTF-8")
    public String toCargoEditor(){
        return JSON.toJSONString(cargoService.SelectCargo(cargid));
    }

    /**
     * 修改页面跳转
     * @return
     */
    @RequestMapping("ToCargoEditor")
    public ModelAndView ToCargoEditor(){
        ModelAndView mav=new ModelAndView("client/OrderShow");
        return mav;
    }

    private Integer cargid=0;

    /**
     * 根据id修改信息
     * @param Cargoid
     * @return
     */
    @RequestMapping("toEditor/{Cargoid}")
    public String toEditor(@PathVariable(value = "Cargoid") Integer Cargoid){
        this.cargid=Cargoid;

        return "redirect:/CargoController/ToCargoEditor";
    }

    /**
     * 获取分页数据
     * @param pageNow
     * @return
     */
    /*@ResponseBody
    @RequestMapping(value = "ShowCargoInfo/{pageNow}",produces = "text/html;charset=UTF-8")
    public String ShowCargoInfo(@PathVariable(value = "pageNow") String pageNow){
        //获取当前页数
        //获取数据总条数
        System.out.println(pageNow);
        //Integer totalCount=cargoService.findNewCont();
        CargoPage cargoPage=null;
        List<OrderfoodCargo> list=new ArrayList<OrderfoodCargo>();
        Integer pageNo=Integer.parseInt(pageNow);
        if(pageNo>0){
            cargoPage=new CargoPage(pageNo,totalCount);
                list=this.cargoService.findNewsPage(cargoPage.getStartPos(),cargoPage.getPageSize());
        }else {
            cargoPage =new CargoPage(1,totalCount);
            list=this.cargoService.findNewsPage(cargoPage.getStartPos(),cargoPage.getPageSize());
        }
        System.out.println(JSON.toJSONString(list));
        return JSON.toJSONString(list);
    }*/

    /**
     * 获取总页数
     * @return
     */
    @ResponseBody
    @RequestMapping("getPageCount")
    public String getPageCount(@Param(value = "stockname") String stockname){
        Integer totalCount=cargoService.findNewCont(stockname);
        Integer Count=totalCount/8;
        Integer PageCount=0;
        PageCount=totalCount%8==0?Count:Count+1;
        return JSON.toJSONString(PageCount);
    }

    /**
     * 模糊查分页数据
     * @param stockname
     * @param pageNow
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "findLike/{pageNow}",produces = "text/html;charset=UTF-8")
    public String findLike(@Param(value = "stockname") String stockname,@PathVariable(value = "pageNow") String pageNow){
        //获取当前页数
        //获取数据总条数
        Integer totalCount=cargoService.findLikeCount(stockname);
        CargoPage cargoPage=null;
        List<OrderfoodCargo> list=new ArrayList<OrderfoodCargo>();
        Integer pageNo=Integer.parseInt(pageNow);
        if(pageNo>0){
            cargoPage=new CargoPage(pageNo,totalCount);
            list=this.cargoService.findLike(stockname,cargoPage.getStartPos(),cargoPage.getPageSize());

        }else {
            cargoPage =new CargoPage(1,totalCount);
            list=this.cargoService.findLike(stockname,cargoPage.getStartPos(),cargoPage.getPageSize());
        }
        System.out.println(JSON.toJSONString(list));
        return JSON.toJSONString(list);
    }

    /**
     * 模糊查总条数
     * @param stockname
     * @return
     */
    @ResponseBody
    @RequestMapping("getLikePageCount")
    public String getLikePageCount(@Param(value = "stockname") String stockname){
        Integer totalCount=cargoService.findLikeCount(stockname);
        Integer Count=totalCount/2;
        Integer PageCount=0;
        PageCount=totalCount%2==0?Count:Count+1;
        return JSON.toJSONString(PageCount);
    }

    /**
     * 总重量
     * @param stockname
     * @return
     */
    @ResponseBody
    @RequestMapping("weightSum/{stockname}")
    public ModelAndView weightSum(@Param(value = "stockname") String stockname){
        ModelAndView mav=new ModelAndView("client/OrderClass");
        mav.addObject(cargoService.weightSum(stockname));
        return mav;
    }
}
