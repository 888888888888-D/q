package com.qfedu.controller;


import com.qfedu.service.CustomerService;
import com.qfedu.utils.ResultObj;
import com.qfedu.vo.CustomerVo;
import com.qfedu.vo.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController //以json形式响应数据
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    /**
     * 加载客户列表返回DataGridView
     *
     * @param customerVo
     * @return
     */
    @GetMapping
    public DataGridView loadAllCustomer(@RequestBody CustomerVo customerVo) {
        return this.customerService.queryAllCustomer(customerVo);
    }

    /* *
    添加客户信息
    请求类型：POST
     */
    @PostMapping
    public ResultObj addCustomer(@RequestBody CustomerVo customerVo) {
        try {
            customerVo.setCreatetime(new Date());
            customerService.addCustomer(customerVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }
    /* *
       修改客户信息
    请求类型：POST
     */

    @PutMapping
    public ResultObj updateCustomer(@RequestBody CustomerVo customerVo) {
        try {
        customerService.updateCustomer(customerVo);
         return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }


     /* *
       删除客户信息
    请求类型：POST
     */

     @DeleteMapping
    public ResultObj updateCustomer(String identity) {
        try {
            customerService.deleteCustomer(identity);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

}