package com.orderfood.pojo;

import java.io.File;
import java.io.Serializable;

public class OrderfoodUtil implements Serializable {
    //封装上传文件对象
    private File userExcel;
    // 封装上传文件类型的属性
    private String userExcelContentType;
    // 封装上传文件名的属性
    private String userExcelFileName;
}
