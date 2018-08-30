package com.orderfood.service.impl;


import com.orderfood.mapper.CargoMapper;
import com.orderfood.pojo.OrderfoodCargo;
import com.orderfood.pojo.OrderfoodRunningData;
import com.orderfood.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;
@Service("cargoService")
public class CargoServiceImpl implements CargoService {

    @Autowired
    private DataSourceTransactionManager transactionManager;

    @Autowired
    private CargoMapper cargoMapper;

    @Override
    @Transactional
    public Integer UpdateCargo(OrderfoodCargo cargo)throws RuntimeException {
        return cargoMapper.UpdateCargo(cargo);
    }

    @Override
    public OrderfoodCargo SelectCargo(Integer cargoid) {
        return cargoMapper.SelectCargo(cargoid);
    }

    @Override
    public List<OrderfoodCargo> getAllCargo() {
        return cargoMapper.getAllCargo();
    }

    @Override
    @Transactional
    public Integer delCargo(List<Object> CargoIdList) throws RuntimeException {
        try {
            Example example =new Example(OrderfoodCargo.class);
            example.createCriteria().andIn("cargoid",CargoIdList);
            this.cargoMapper.deleteByExample(example);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    @Override
    public Integer InsRunData(OrderfoodRunningData runData) {
        return cargoMapper.InsRunData(runData);
    }

    @Override
    public Integer InsertCargo(OrderfoodCargo cargo) {
        return cargoMapper.InsertCargo(cargo);
    }
    @Override
    public Integer InsertInfo(OrderfoodCargo cargo,OrderfoodRunningData runData) throws RuntimeException{
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW); // 事物隔离级别，开启新事务，这样会比较安全些。
        TransactionStatus status = transactionManager.getTransaction(def);
        int res=0;
        if (cargo!=null&&runData!=null) {
            try {
            this.txIns(cargo,runData);
            } catch (Exception e) {
                transactionManager.rollback(status);
                e.printStackTrace();
                return 0;
            }
        }else{
            return 0;
        }
        transactionManager.commit(status);
        return res;
    }

    @Override
    public Float selRawStock(Integer stockid) {
        Float rs=0.00f;
        if(stockid!=null&&stockid!=0){
            rs=cargoMapper.selRawStock(stockid);
        }else {
            return 0f;
        }
        return rs;
    }

    public Integer txIns(OrderfoodCargo cargo,OrderfoodRunningData runData){
        try {
            this.InsertCargo(cargo);
            this.InsRunData(runData);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }
}
