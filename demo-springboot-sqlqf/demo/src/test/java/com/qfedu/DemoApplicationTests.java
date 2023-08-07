package com.qfedu;

import com.qfedu.dao.CustomerMapper;
import com.qfedu.pojo.Customer;
import com.qfedu.vo.CustomerVo;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@MapperScan("com.qfedu.dao")
class DemoApplicationTests {

    @Autowired
    private CustomerMapper customerMapper;

    @Test
    void contextLoads() {
        CustomerVo vo=new CustomerVo();
        vo.setCareer("程序");
        List<Customer> customers = customerMapper.queryAllCustomer(vo);
        System.out.println(customers);
    }

}
