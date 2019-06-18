package com.didispace.service.impl;

import com.didispace.domain.Customer;
import com.didispace.mapper.CustomerMapper;
import com.didispace.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ICustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public List<Customer> selectName(Customer customer) {
        return customerMapper.selectName(customer);
    }

    /**
     * 查询用户名和密码是否被使用
     *
     * @param customer
     * @return
     */
    @Override
    public List<Customer> selectRegistName(Customer customer) {
        return customerMapper.selectRegistName(customer);
    }

    /**
     * 用户名新增
     *
     * @param customer
     * @return
     */
    @Override
    public int insertCustomerName(Customer customer) {
        return customerMapper.insertCustomerName(customer);
    }

    /**
     * 电话新增
     *
     * @param customer
     * @return
     */
    @Override
    public int insertCustomerMobile(Customer customer) {
        return customerMapper.insertCustomerMobile(customer);
    }

    /**
     * 检测名字是否存在
     *
     * @param customer
     * @return
     */

    public List<Customer> selectCheckName(Customer customer) {
        return customerMapper.selectCheckName(customer);
    }

    /**
     * 修改密码
     *
     * @param customer
     * @return
     */
    @Override
    public int updatePwd(Customer customer) {
        return customerMapper.updatePwd(customer);
    }

    /*添加客户*/
    @Override
    public void insert(Customer customer) {
      customerMapper.insert(customer);
    }
}
