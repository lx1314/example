package com.lgj.mymapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 通用mapper，所用的dao都要继承这个接口
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
