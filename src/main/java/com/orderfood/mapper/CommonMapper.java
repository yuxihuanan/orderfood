package com.orderfood.mapper;

import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;


/**
 * 继承自己的MyMapper
 */
@Repository("commonMapper")
public interface CommonMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
