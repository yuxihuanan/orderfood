package com.orderfood.service.impl;

import com.orderfood.mapper.EmployeeRodeMapper;
import com.orderfood.pojo.OrderfoodEmployeeRole;
import com.orderfood.service.EmployeeRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;
@Service("employeeRoleService")
public class EmployeeRoleServiceImpl implements EmployeeRoleService {


    @Autowired
    private DataSourceTransactionManager transactionManager;

    @Autowired
    private EmployeeRodeMapper employeeRodeMapper;

    @Override
    public List<OrderfoodEmployeeRole> getAllRo() {
        return employeeRodeMapper.getAllRo();
    }

    @Override
    public int delRo(int roleid) {
        return employeeRodeMapper.delRo(roleid);
    }

    public int updEm(int roleid) {
        return employeeRodeMapper.updEm(roleid);
    }

    public int delAndUpd(int roleid) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW); // 事物隔离级别，开启新事务，这样会比较安全些。
        TransactionStatus status = transactionManager.getTransaction(def);
        try {
            this.txMadelAndUpd(roleid);
        } catch (Exception e) {
            e.printStackTrace();
            transactionManager.rollback(status);
            return 0;
        }
        transactionManager.commit(status);
        return 1;
    }

    public int txMadelAndUpd(int roleid){
        try {
            this.updEm(roleid);
            this.delRo(roleid);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    @Override
    public int addRo(OrderfoodEmployeeRole orderfoodEmployeeRole) {
        return employeeRodeMapper.addRo(orderfoodEmployeeRole);
    }

    @Override
    public int updRo(OrderfoodEmployeeRole orderfoodEmployeeRole) {
        return employeeRodeMapper.updRo(orderfoodEmployeeRole);
    }


    @Override
    public OrderfoodEmployeeRole selRo(Integer roleid) {
        return employeeRodeMapper.selRo(roleid);
    }

    public List<OrderfoodEmployeeRole> selAll() {
        return employeeRodeMapper.selAll();
    }
}
