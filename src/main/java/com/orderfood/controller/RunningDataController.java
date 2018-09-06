package com.orderfood.controller;

import com.orderfood.pojo.CargoPage;
import com.orderfood.pojo.OrderfoodEmployee;
import com.orderfood.pojo.OrderfoodRunningData;
import com.orderfood.service.RunningDataService;
import com.orderfood.service.impl.RunningDataServiceImpl;
import jxl.CellView;
import jxl.SheetSettings;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.ScriptStyle;
import jxl.format.UnderlineStyle;
import jxl.write.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 收支流水
 */
@Controller
public class RunningDataController {
    private ModelAndView model=new ModelAndView();
    @Autowired
    private RunningDataService runningDataService;

    /**
     * 跳转收支流水页面
     * @param request
     * @return
     */
    @RequestMapping(value = "selectrunningDatapage", produces = "text/plain;charset=utf-8")
    private ModelAndView selectRunningDatapage(HttpServletRequest request){
        OrderfoodEmployee employee=(OrderfoodEmployee) request.getSession().getAttribute("user");
        if(null==employee){
            model.setViewName("login");
        }else{
            model.setViewName("item/Item");
        }
        return model;
    }
    /**
     * 查询收支状况
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "selectrunningData",produces = "text/plain;charset=utf-8")
    public String selectRunningData(OrderfoodRunningData runningData){
        return JSON.toJSONString(runningDataService.SelectRunningData(runningData));
    }





    /**
     * 导出EXCEL文件,主要做的就是查询一堆列表，然后创建多个工作表，每个工作表下面有很多标题及列表数据
     *
     * @param response
     */
    @ResponseBody
    @RequestMapping(value = "export",produces = "text/plain;charset=utf-8")
    public String export(HttpServletResponse response,OrderfoodRunningData runningData) {
        // 文件名
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String fileName = sdf.format(new Date()) + "收支流水统计表.xls";
        response.setContentType("application/x-excel");
        response.setCharacterEncoding("UTF-8");
        response.addHeader("Content-Disposition", "attachment;filename=" + fileName);// excel文件名
        // 业务数据，不用关注，网友请假装有数据，哈哈哈...下同
        List<OrderfoodRunningData> itemList =runningDataService.SelectRunningData(runningData);;

        try {
            // 1.创建excel文件
            WritableWorkbook book = Workbook.createWorkbook(new File("E:/"+fileName));
            // 居中
            WritableCellFormat wf = new WritableCellFormat();
            wf.setAlignment(Alignment.CENTRE);
            WritableSheet sheet = null;
            SheetSettings settings = null;
            Integer count=0;
            CellView cellView = new CellView();
            cellView.setAutosize(true); //设置自动大小
            cellView.setSize(20);
            int sheets = book.getSheets().length;
//            if (sheets == 0) {
//                sheet = book.createSheet("第1页", 0);
//            } else {
//                //如果最后一页表格的行数大于65535，就新建一页表格
//                if(book.getSheet(sheets-1).getRows()==65535){
//                    sheet = book.createSheet("第"+(sheets+1)+"页", sheets-1);
//                }else{
//                    sheet = book.getSheet(sheets-1);
//                }


// 编写文字样式
            WritableFont font = new WritableFont(
                    WritableFont.createFont("宋体"),	// 字体
                    20,					// 字号
                    WritableFont.NO_BOLD,			// 加粗样式
                    false,  				// 斜体
                    UnderlineStyle.NO_UNDERLINE,	        // 下划线样式
                    Colour.RED,				// 字体颜色
                    ScriptStyle.NORMAL_SCRIPT		// 脚本风格
            );

            sheet = book.createSheet("第1页", 0);
                for (int i = 0; i < itemList.size(); i++) {
                count++;
                // 2.创建sheet并设置冻结前两行
                //settings = sheet.getSettings();
                //settings.setVerticalFreeze(2);
                // 3.添加第一行及第二行标题数据
                sheet.addCell(new Label(0, 0, "收支编号", wf));
                sheet.addCell(new Label(0, count, count.toString(), wf));
                sheet.addCell(new Label(1, 0, "收支流水", wf));
                sheet.addCell(new Label(1, count, itemList.get(i).getDataprice() + "", wf));
                sheet.addCell(new Label(2, 0, "收支声明", wf));
                sheet.addCell(new Label(2, count, itemList.get(i).getDatastatement() + "",wf));
                sheet.addCell(new Label(3, 0, "收支明细", wf));
                sheet.addCell(new Label(3, count, itemList.get(i).getDatacomment() + "",wf));
                sheet.addCell(new Label(4, 0, "创建时间", wf));
                sheet.addCell(new Label(4, count, itemList.get(i).getCreatedate() + "",wf));
            }
            // 6.写入excel并关闭
            book.write();
            book.close();
            return "1";
        } catch (Exception e) {
            e.printStackTrace();
        }
            return "0";
    }



    /**
     * 分页查询收支流水
     * @param runningData
     * @param pagenow
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "selectrunningDataPages/{pagenow}",produces = "text/plain;charset=utf-8")
    public String SelectRunningDataPages(OrderfoodRunningData runningData,@PathVariable("pagenow") Integer pagenow){
        CargoPage page=new CargoPage(pagenow,runningDataService.RunningDataCount(runningData));
        page.setPageSize(4);
        return JSON.toJSONString(runningDataService.SelectRunningDataPages(runningData,page));
    }

    /**
     * 查询总页数
     * @return
     */
    @ResponseBody
    @RequestMapping("RunningDataCount")
    public String RunningDataCount(OrderfoodRunningData runningData){
        CargoPage page=new CargoPage(1,runningDataService.RunningDataCount(runningData));
        page.setPageSize(4);
        page.setTotalCount(runningDataService.RunningDataCount(runningData));
        System.out.println(page.getTotalPageCount());
        return JSON.toJSONString(page.getTotalPageCount());
    }
}
