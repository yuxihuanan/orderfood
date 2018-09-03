package com.orderfood.service.impl;

import com.orderfood.mapper.EmployeeMapper;
import com.orderfood.pojo.OrderfoodEmployee;
import com.orderfood.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 查询全部员工
     * @return
     */
    @Override
    public List<OrderfoodEmployee> getAllEm() {
        return employeeMapper.getAllEm();
    }

    /**
     * 添加员工
     * @param orderfoodEmployee
     * @return
     */
    @Override
    public int addEm(OrderfoodEmployee orderfoodEmployee) {
        return employeeMapper.addEm(orderfoodEmployee);
    }

    /**
     * 实现修改员工数据
     * @param orderfoodEmployee
     * @return
     */
    @Override
    public int updEm(OrderfoodEmployee orderfoodEmployee) {
//        try {
            employeeMapper.updEm(orderfoodEmployee);
//        } catch (Exception e) {
//        return 0;
//    }
        return employeeMapper.updEm(orderfoodEmployee);
    }

    /**
     * 根据id查询员工信息
     * @param employeeid
     * @return
     */
    @Override
    public OrderfoodEmployee selEm(int employeeid) {
        return employeeMapper.selEm(employeeid);
    }

    /**
     * 根据姓名条件查
     * @param employeename
     * @return
     */
    @Override
    public List<OrderfoodEmployee> selTwo(String employeename){
        System.out.println("哈哈哈哈："+employeename);
        return employeeMapper.selTwo(employeename);
    }

    /**
     * 批量删除
     * @param objects
     * @return
     * @throws RuntimeException
     */
    @Override
    public int delesc(List<Object> objects) throws RuntimeException {
        System.out.println(objects);
        try {
            Example example = new Example(OrderfoodEmployee.class);
            example.createCriteria().andIn("employeeid",objects);
            employeeMapper.deleteByExample(example);
        } catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    /**
     * 删除角色关联员工
     * @param eRoleid
     * @return
     */
    @Override
    public int del(int eRoleid) {
        return employeeMapper.del(eRoleid);
    }
}
