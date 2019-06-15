package com.didispace.mapper;

import com.didispace.common.mapper.MyMapper;
import com.didispace.domain.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerMapper extends MyMapper<Customer> {

    List<Customer> selectName(Customer customer);

    List<Customer> selectRegistName(Customer customer);

    int insertCustomerName(Customer customer);

    int insertCustomerMobile(Customer customer);

    List<Customer> selectCheckName(Customer customer);
}