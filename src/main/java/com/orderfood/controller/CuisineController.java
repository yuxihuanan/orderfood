package com.orderfood.controller;

import com.alibaba.fastjson.JSON;
import com.orderfood.pojo.OrderfoodCuisine;
import com.orderfood.pojo.OrderfoodRecipe;
import com.orderfood.service.CuisineService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("cuisinecontroller")
public class CuisineController {
    @Resource(name="cuisine")
    private CuisineService cuisine;
    @RequestMapping("cuisine")
    public ModelAndView  goCuisine()
    {
        ModelAndView model=new ModelAndView("knowledge/CuisineManage");
        model.addObject("users",cuisine.selectAll());
        return model;
    }




    @RequestMapping("gocuisi")
    public ModelAndView gocuisi(){
        ModelAndView model=new ModelAndView("knowledge/Recipeadd");
        model.addObject("si",cuisine.sine());
        return model;
    }

    @RequestMapping("recipeadd")
    public ModelAndView recipeadd(OrderfoodRecipe recipe){
        ModelAndView model=new ModelAndView("knowledge/Recipeadd");
        model.addObject("stock",cuisine.getRecipe());
        model.addObject("si",cuisine.sine());
        return model;
    }

    @RequestMapping("getStock")
    public ModelAndView getStock(){
        ModelAndView model=new ModelAndView("knowledge/Recipeadd");
        model.addObject("stock",cuisine.getRecipe());
        model.addObject("si",cuisine.sine());
        return model;
    }

    @ResponseBody
    @RequestMapping("recipe")
    public String recipe(OrderfoodRecipe recipe){
        return JSON.toJSONString(cuisine.Recipeadd(recipe));
    }


    @RequestMapping("goCui")
    public String goCui(){
        return JSON.toJSONString(cuisine.selectAll());
    }

    @RequestMapping("goRecipe")
    public ModelAndView goRecipe(){
        ModelAndView model=new ModelAndView("knowledge/RecipeManage");
        model.addObject("users",cuisine.getRecipe());
        return model;
    }


    @RequestMapping("cuisineupd")
    public ModelAndView cuisineupd(Integer cuisineid){
        ModelAndView model=new ModelAndView("knowledge/CuisineUpd");
        model.addObject("updd",cuisine.getOne(cuisineid));
        model.addObject("users",cuisine.selectAl());
        return model;
    }

    @ResponseBody
    @RequestMapping("cuisneupdd")
    public String cuisneupdd(OrderfoodCuisine cuisn){
        System.out.print(cuisn.getcClassifyid());
        return JSON.toJSONString(cuisine.Cuisineupdd(cuisn));
    }
    @RequestMapping( "getOne/{cuisineid}")
    public String getOne(@PathVariable("cuisineid") Integer cuisineid){
        return JSON.toJSONString(cuisine.getOne(cuisineid));
    }

    @ResponseBody
    @RequestMapping( value ="getAll/{cuisineacronym}",produces="text/plain;charset=utf-8")
    public String getAll(@PathVariable("cuisineacronym") String cuisineacronym){
        return JSON.toJSONString(cuisine.getAll(cuisineacronym));
    }




    @RequestMapping("cuiadd")
    public ModelAndView cuiadd(){
        ModelAndView model=new ModelAndView("knowledge/CuisineAdd");
        model.addObject("users",cuisine.selectAl());
        return model;
    }
    @ResponseBody
    @RequestMapping("del/{cuisineid}")
    public String del(@PathVariable("cuisineid") int cuisineId){
        System.out.print(cuisineId);
        return JSON.toJSONString(cuisine.Cuisinedel(cuisineId));
    }


    @ResponseBody
    @RequestMapping("cuisineadd")
    public ModelAndView cuisineadd(@RequestParam("multipartFile") MultipartFile multipartFile,ModelMap map, OrderfoodCuisine cuisin, HttpServletRequest request, HttpServletResponse response){
        //首先解析MultipartFile对象，判断文件是否为空，判断文件不为空，为空则返回0
        String pPicturepath = request.getParameter("pPicturepath");
        if (multipartFile!=null) {
            //2.获取文件的名称
            String oldFileName = multipartFile.getOriginalFilename();
            //3.获取文件的后缀名
            String hz = FilenameUtils.getExtension(oldFileName);
            if ("jpg".equals(hz) || "png".equals(hz)) {
                //4.获取文件的大小
                if (multipartFile.getSize() <= 5000000) {
                    //5.创建保存文件的路径
          /*  String newPath=request.getServletContext().getRealPath("/views/static/images/temp");
            System.out.println(newPath);*/
                    //6.根据新路径创建File对象,从新定义文件名
                    String newFileName = UUID.randomUUID() + "." + hz;
                    System.out.println(newFileName);
                    File newFile = new File("D:/orderfood/views/static/images/" + newFileName);
                    //7.判断File对象是否存在，如果不存在创建文件
                    if (!newFile.exists()) {
                        newFile.getParentFile().mkdir();
                    }
                    //8.将原文件的内容复制到新文件中
                    try {
                        multipartFile.transferTo(newFile);
                        //将路径传入picture对象
                       cuisin.setPicture("/images/" + newFileName);
                       cuisine.Cuisineadd(cuisin);
                    } catch (IllegalStateException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //9.向数据库保存图片路径
                } else {
                    System.out.println("文件大小不得超过500KB");
                    return null;
                }
            }
        }
        return goCuisine();
    }
}
