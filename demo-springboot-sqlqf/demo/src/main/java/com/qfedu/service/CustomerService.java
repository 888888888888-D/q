package com.qfedu.service;

import com.qfedu.vo.CustomerVo;
import com.qfedu.vo.DataGridView;

public interface CustomerService {
    /**
     * 查询所有客户
     * @param customerVo
     * @return
     */
    public DataGridView queryAllCustomer(CustomerVo customerVo);


    /* *
    添加客户
    @param customerVo
     */
    void addCustomer(CustomerVo customerVo);


    /*  *

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
