package com.orderfood.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 员工表实体类
 */
public class OrderfoodEmployee implements Serializable {
    private Integer employeeid;//员工编号

    private String employeename;//姓名

    private Integer age;//年龄

    private String username;//用户名

    private String password;//密码

    private Integer eRoleid;//角色

    private Integer sex;//性别

    private String address;//所在地址

    private String phone;//电话号

    private Date createdate;//入店时间

    public OrderfoodEmployee(Integer employeeid, String employeename, Integer age, String username, String password, Integer eRoleid, Integer sex, String address, String phone, Date createdate) {
        this.employeeid = employeeid;
        this.employeename = employeename;
        this.age = age;
        this.username = username;
        this.password = password;
        this.eRoleid = eRoleid;
        this.sex = sex;
        this.address = address;
        this.phone = phone;
        this.createdate = createdate;
    }

    public OrderfoodEmployee() {
        super();
    }

    public Integer getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Integer employeeid) {
        this.employeeid = employeeid;
    }

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename == null ? null : employeename.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer geteRoleid() {
        return eRoleid;
    }

    public void seteRoleid(Integer eRoleid) {
        this.eRoleid = eRoleid;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}