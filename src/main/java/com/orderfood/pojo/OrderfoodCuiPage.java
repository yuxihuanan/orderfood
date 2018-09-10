package com.orderfood.pojo;

import java.util.ArrayList;
import java.util.List;

public class OrderfoodCuiPage {
    private Integer pageIndexss;  //当前页
    private Integer pageSizess=3; //显示条数
    private Integer studentCountss; //总数
    private Integer pageSumss; //查询共几页
    private List<OrderfoodCuisine> stuss=new ArrayList<OrderfoodCuisine>();
    public Integer getPageIndexss() {
        return pageIndexss;
    }
    public void setPageIndexss(Integer pageIndexss) {
        this.pageIndexss = pageIndexss;
    }
    public Integer getPageSizess() {
        return pageSizess;
    }
    public void setPageSizess(Integer pageSizess) {
        this.pageSizess = pageSizess;
    }
    public Integer getStudentCountss() {
        return studentCountss;
    }
    public void setStudentCount(Integer studentCountss) {
        this.studentCountss= studentCountss;
        this.setPageSumss(this.studentCountss%this.pageSizess==0?this.studentCountss/this.pageSizess:this.studentCountss/this.pageSizess+1);
    }
    public Integer getPageSumss() {
        return pageSumss;
    }
    public void setPageSumss(Integer pageSumss) {
        this.pageSumss = pageSumss;
    }
    public List<OrderfoodCuisine> getStuss() {
        return stuss;
    }
    public void setStuss(List<OrderfoodCuisine> stuss) {
        this.stuss = stuss;
    }

}
