package com.qfedu.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qfedu.dao.CustomerMapper;
import com.qfedu.pojo.Customer;
import com.qfedu.vo.CustomerVo;
import com.qfedu.vo.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerMapper customerMapper;

    /**
     * 分页查询
     * @param customVo
     * @return
     */



    @Override
    public DataGridView queryAllCustomer(CustomerVo customVo) {
        //通过PageHelper完成分页
        Page<Object> page = PageHelper.startPage(customVo.getPage(), customVo.getLimit());
        List<Customer> customers = customerMapper.queryAllCustomer(customVo);
        return new DataGridView(page.getTotal(), customers);
    }


    /*  *
    添加客户
    @param customerVo
     */
    @Override
    public void addCustomer(CustomerVo customerVo) {
        customerMapper.addCustomer(customerVo);

    }
    /* *
    修改客户信息
    @param customerVo
    */

    @Override
    public void updateCustomer(CustomerVo customerVo) {
        this.customerMapper.updateCustomer(customerVo);

    }

    @Override
    public void deleteCustomer(String identity) {
        customerMapper.deleteCustomer(identity);
    }
}
