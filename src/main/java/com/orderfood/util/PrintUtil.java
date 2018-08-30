package com.orderfood.util;

import com.orderfood.pojo.OrderfoodIndent;
import com.orderfood.pojo.OrderfoodIndentDetails;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class PrintUtil {

    public static void print(OrderfoodIndent orderfoodIndent){
        PrintWriter out=null;
        try {
            out=new PrintWriter("F:/订单/"+orderfoodIndent.getIndentcode()+".txt");
            out.println("************XXX餐厅消费账单************");
            out.println("开台单号:"+orderfoodIndent.getIndentcode());
            out.println("桌位:"+orderfoodIndent.getOrderfoodTable().getTablenumber()+"    服务员:"+orderfoodIndent.getOrderfoodEmployee().getEmployeename());
            //out.print("结账时间:"+);
            out.println("ID\t菜品\t价格\t数量\t金额");
            int number=1;
            for (OrderfoodIndentDetails details : orderfoodIndent.getDetails()){
                out.print("0"+number+"\t"+details.getCuisine().getCuisinename()+"  "+details.getCuisine().getPrice()+"  "+details.getDetailscount()+"  "
                        +(details.getCuisine().getPrice())*(details.getDetailscount()));
            }
            out.print("\t\t\t----"+orderfoodIndent.getTotalmoney());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(out!=null){
                out.flush();
                out.close();
            }
        }
    }
}
