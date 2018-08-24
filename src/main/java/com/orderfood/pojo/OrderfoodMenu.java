package com.orderfood.pojo;

import java.io.Serializable;

/**
 * 导航表
 */
public class OrderfoodMenu implements Serializable {
    private Integer menuid;//

    private String menuname;

    private Integer parentid;

    private String menuurl;

    public OrderfoodMenu(Integer menuid, String menuname, Integer parentid, String menuurl) {
        this.menuid = menuid;
        this.menuname = menuname;
        this.parentid = parentid;
        this.menuurl = menuurl;
    }

    public OrderfoodMenu() {
        super();
    }

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname == null ? null : menuname.trim();
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getMenuurl() {
        return menuurl;
    }

    public void setMenuurl(String menuurl) {
        this.menuurl = menuurl == null ? null : menuurl.trim();
    }
}