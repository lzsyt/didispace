package com.didispace.service;

import com.didispace.domain.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> selectName(Customer customer);

    /**
     * 查询用户名和密码是否被使用
     *
     * @param customer
     * @return
     */
    List<Customer> selectRegistName(Customer customer);

    /**
     * 用户名新增
     *
     * @param customer
     * @return
     */
    public int insertCustomerName(Customer customer);

    /**
     * 电话新增
     *
     * @param customer
     * @return
     */
    public int insertCustomerMobile(Customer customer);

    /**
     * 检测名字是否存在
     *
     * @param customer
     * @return
     */
    List<Customer> selectCheckName(Customer customer);

    /**
     * 修改密码
     *
     * @param customer
     * @return
     */
    public int updatePwd(Customer customer);

    void insert(Customer customer);
}
