package com.orderfood.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 员工表实体类
 */
public class OrderfoodEmployee implements Serializable {
    /**
     * 员工编号
     */
    @Column(name = "employeeId")
    private Integer employeeId;//员工编号
    /**
     * 姓名
     */
    @Column(name = "employeeName")
    private String employeeName;//姓名
    /**
     * 年龄
     */
    @Column(name = "age")
    private Integer age;//年龄
    /**
     * 用户名
     */
    @Column(name = "userName")
    private String userName;//用户名
    /**
     * 密码
     */
    @Column(name = "password")
    private String passWord;//密码
    /**
     * 角色
     */
    @Column(name = "e_roleId")
    private Integer eRoleid;//角色
    /**
     * 性别
     */
    @Column(name = "sex")
    private Integer sex;//性别
    /**
     * 所在地址
     */
    @Column(name = "address")
    private String address;//所在地址
    /**
     * 电话号
     */
    @Column(name = "phone")
    private String phone;//电话号
    /**
     * 入店时间
     */
    @Column(name = "createDate")
    private Date createDate;//入店时间

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return passWord;
    }

    public void setPassword(String password) {
        this.passWord = password;
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
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}