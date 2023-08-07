package com.qfedu.dao;

import com.qfedu.pojo.Customer;
import com.qfedu.vo.CustomerVo;

import java.util.List;

public interface CustomerMapper {
    /**
     * 查询
     * @param customer
     * @return
     */
    List<Customer> queryAllCustomer(Customer customer);


    /* *
    添加客户
    @param customerVo

     */

    void addCustomer(CustomerVo customerVo);
    /* *
    修改客户信息
    @param customerVo
    */


    void updateCustomer(CustomerVo customerVo);
    /* *
    删除客户信息
    @param identity
    */


    void deleteCustomer(String identity);
}
