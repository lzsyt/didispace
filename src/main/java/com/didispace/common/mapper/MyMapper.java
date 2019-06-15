package com.didispace.common.mapper;

import com.didispace.domain.Customer;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
    int updatePwd(Customer customer);
}
