package com.orderfood.util;


import jxl.Cell;
import jxl.Sheet;
import jxl.SheetSettings;
import jxl.Workbook;
import jxl.write.*;

import java.io.File;

/**
 * 读写excel工具类
 */
public class ExcelUtil {
    /**
     * 创建一个excel文件写入操作
     */
    public void WriteExcel() {
        File file = new File("E:/cnblogs/jsl_text.xls");//生成的表格存储的位置
        String[] str = {"id", "name", "sex"};//标题内容
        try {
            if (!file.exists()) {//判断文件是否存在
                file.createNewFile();//创建新的文件
            }
            //创建工作簿
            WritableWorkbook workbook = Workbook.createWorkbook(file);
            //创建sheet对象
            WritableSheet sheet = workbook.createSheet("sheet1", 0);
            //行对象
            Label label = null;

            //添加标题
            for (int i = 0; i < str.length; i++) {
                /**
                 * Label(i,j,String);
                 * i:列
                 * j:行
                 * String:表示内容
                 */
                label = new Label(i, 0, str[i]);
                sheet.addCell(label);
            }

            //添加数据
            for (int i = 1; i <= 10; i++) {
                label = new Label(0, i, i + "");
                sheet.addCell(label);
                label = new Label(1, i, "name" + i);
                sheet.addCell(label);
                label = new Label(2, i, "男");
                sheet.addCell(label);
            }
            workbook.write();//把表格信息写入文件
            workbook.close();//关闭
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("表格生成");
    }

    /**
     * 读取excel
     */
    public void ReadExcel(){
        File file = new File("E:/cnblogs/jsl_text.xls");//表格存储的位置
        try{
            if(file.exists()){//判断文件是否存在
                //创建工作簿
                Workbook workbook = Workbook.getWorkbook(file);
                //获得第一个工作表sheet1
                Sheet sheet = workbook.getSheet(0);

                //获得数据
                for (int i = 0; i < sheet.getRows(); i++) {//sheet.getRows():获得表格文件行数
                    for (int j = 0; j < sheet.getColumns(); j++) {//sheet.getColumns():获得表格文件列数
                        Cell cell = sheet.getCell(j,i);
                        System.out.print(cell.getContents()+" ");
                    }
                    System.out.println("");
                }
                workbook.close();//关闭
            }else{
                System.out.println("文件不存在");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 生成excel表格基本为三个步骤： 1.创建excel工作簿 2.创建工作表sheet 3.创建单元格并添加到sheet中
     *
     * @throws Exception
     */
    public void writeExcel1(){
        try {
            /*
             * 创建可读写的excel对象，一个excel文件对应着一个WritableWorkbook对象
             * 以下是通过生成本地文件的方式创建excel对象，还可以在构造时传入输出流的方式创建
             * 注意：因为jxl不支持office2007及以上版本，所以只能操作.xls文件，而无法操作.xlsx文件
             * 方法：Workbook.createWorkbook()
             */
            WritableWorkbook book = Workbook.createWorkbook(new File("F:/test.xls"));
            // WritableWorkbook book = Workbook.createWorkbook(outputstream);

            /*
             * 创建只读的excel对象
             */
            // jxl.Workbook rw = jxl.Workbook.getWorkbook(new File(sourcefile));

            /*
             * 创建工作表sheet对象，可以根据需求创建多个 方法：createSheet() pararm1：工作表的名称
             * param2：工作表的索引下表（0开始）
             */
            WritableSheet sheet = book.createSheet("工作表1", 0);
            // WritableSheet sheet2 = book.createSheet("工作表2", 1);

            /*
             * 设置工作表的行或列冻结
             */
            SheetSettings settings = sheet.getSettings();
            // 冻结前两行
            settings.setVerticalFreeze(1);
            // 冻结前两列
            // settings.setHorizontalFreeze(2);

            /*
             * 添加文本单元格，一个Label对象对应着一个单元格 param1:第几列 param2:第几行 param3:单元格内容（值）
             */
            Label label_00 = new Label(0, 0, "标题1");

            /*
             * 设置单元格字体，还有很多其他样式，不一一列举
             */
            WritableFont wf = new WritableFont(WritableFont.createFont("楷书"), 20);
            /*
             * 设置单元格样式并添加字体样式
             */
            WritableCellFormat wcf = new WritableCellFormat(wf);
            // 设置内容居中
            wcf.setAlignment(Alignment.CENTRE);
            // 设置单元格的背景颜色
            wcf.setBackground(jxl.format.Colour.RED);

            /*
             * 在创建单元格的时候使用样式
             */
            Label label_10 = new Label(1, 0, "标题2", wcf);

            /**
             * 注意：要把所有单元格对象添加到工作表中
             */
            sheet.addCell(label_00);
            sheet.addCell(label_10);

            /*
             * 合并单元格 方法：sheet.mergeCells(x,y,m,n)，xymn都从0开始
             * 表示将单元格从第(x+1)列、第(y+1)行合并到第(m+1)列、(n+1)行合并
             */
            sheet.mergeCells(0, 1, 0, 2);

            /*
             * 写入到文件
             */
            book.write();

            /*
             * 一定要使用close()方法来关闭先前创建的对象，以释放其所占用的内存空间
             */
            book.close();
        }catch (Exception e){
            e.getMessage();
        }


}
}
