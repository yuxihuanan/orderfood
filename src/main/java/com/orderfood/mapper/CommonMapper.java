package com.orderfood.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;


/**
 * 继承自己的MyMapper
 */
public interface CommonMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
