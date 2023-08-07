##### pom.xml配置⽂件中添加如下内容

```
<dependency>
 <groupId>com.alibaba</groupId>
 <artifactId>druid</artifactId>
 <version>1.2.6</version>
</dependency
```

#### application.yml配置⽂件

```

#服务器配置
server:
  port: 8080

#数据源配置
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/pro-db?serverTimezon=UTC
    username: root
    password:
    type: com.alibaba.druid.pool.DruidDataSource
    main:
      allow-circular-references: true


#配置mybatis映射文件位置
mybatis:
  mapper-locations: classpath:mapper/*Mapper.xml


```

#### 客户表: t_customer 具体如下

```
create table `t_customer` (
 `identity` varchar (255),
 `custname` varchar (255),
 `sex` int ,
 `address` varchar (255),
 `phone` varchar (255),
 `career` varchar (255),
 `createtime` datetime
);
insert into `t_customer` (`identity`, `custname`, `sex`,
`address`, `phone`, `career`, `createtime`)
values('421087133414144412','张⼩明','1','北京','13456788987','程序
员','2022-05-07 14:52:24');
insert into `t_customer` (`identity`, `custname`, `sex`,
`address`, `phone`, `career`, `createtime`)
values('43131334113331131','习⼤⼤','1','武汉','13888888888','国家最
⾼领导⼈','2022-05-07 14:52:24');
insert into `t_customer` (`identity`, `custname`, `sex`,
`address`, `phone`, `career`, `createtime`)
values('431321199291331131','张三','1','南京','13431334113','程序
员','2022-05-07 14:52:24');
insert into `t_customer` (`identity`, `custname`, `sex`,
`address`, `phone`, `career`, `createtime`)
values('431321199291331132','孙中⼭','1','⻓沙','134131314131','总
统','2022-05-07 14:52:24');
insert into `t_customer` (`identity`, `custname`, `sex`,
`address`, `phone`, `career`, `createtime`)
values('431341134191311311','李四','0','⻄
安','13451313113','CEO','2022-05-07 14:52:24');
insert into `t_customer` (`identity`, `custname`, `sex`,
`address`, `phone`, `career`, `createtime`)
values('431341134191311314','王⼩明','1','郑
州','13413131113','CEO','2022-05-07 14:52:24');


```

#### 通⽤模块

##### 1.封装常量

关于项⽬中⽤到的描述信息，状态信息项⽬在接⼝中封装常量，⽅便我们以后调⽤ SysConstant

```
/**
* 常量接⼝状态码
*/
public interface SysConstant {
 /**
 *操作状态
 * */
 String ADD_SUCCESS="添加成功";
 String ADD_ERROR="添加失败";
 String UPDATE_SUCCESS="修改成功";
 String UPDATE_ERROR="修改失败";
 String DELETE_SUCCESS="删除成功";
 String DELETE_ERROR="删除失败";
 Integer CODE_SUCCESS = 0;//操作成功
 Integer CODE_ERROR = -1;//操作失败
}
```

##### 2.封装服务器返回对象

服务器返回数据类型我们统⼀封装到ResultObj对象中，并且提供静态⽅法返回常量 信息。

```
package com.qfedu.utils;

import com.qfedu.constant.SysConstant;

/**
 * 服务器返回数据类型我们统⼀封装到ResultObj对象中，并且提供静态⽅法返回常量
 * 信息

 */

public class ResultObj {

    private Integer code;
    private String msg;
    /**
     * 添加成功
     */
    public static final ResultObj ADD_SUCCESS = new
            ResultObj(SysConstant.CODE_SUCCESS,SysConstant.ADD_SUCCESS);
    /**
     * 添加失败
     */
    public static final ResultObj ADD_ERROR = new
            ResultObj(SysConstant.CODE_ERROR,SysConstant.ADD_ERROR);
    /**
     * 更新成功
     */
    public static final ResultObj UPDATE_SUCCESS = new
            ResultObj(SysConstant.CODE_SUCCESS,SysConstant.UPDATE_SUCCESS);
    /**
     * 更新失败
     */
    public static final ResultObj UPDATE_ERROR = new
            ResultObj(SysConstant.CODE_ERROR,SysConstant.UPDATE_ERROR);
    /**
     * 删除成功
     */
    public static final ResultObj DELETE_SUCCESS = new
            ResultObj(SysConstant.CODE_SUCCESS,SysConstant.DELETE_SUCCESS);
    /**
     * 删除失败
     */
    public static final ResultObj DELETE_ERROR = new
            ResultObj(SysConstant.CODE_ERROR,SysConstant.DELETE_ERROR);

    /**
     * 状态码0 成功
     */
    public static final ResultObj STATUS_TRUE = new
            ResultObj(SysConstant.CODE_SUCCESS);
    /**
     * 状态码-1 失败
     */
    public static final ResultObj STATUS_FALSE = new
            ResultObj(SysConstant.CODE_ERROR);
    private ResultObj(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    private ResultObj(Integer code) {
        this.code = code;
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}



```

#### 4.5 查询客户

http://localhost/customer

请求⽅式：get 

请求参数: 

##### 封装layui数据表格的数据对象DataGridView

```
package com.qfedu.vo;


/**
 * 前台展示数据对象
 */
public class DataGridView {
    

/**
     * 封装数据表格的数据对象
     */
    private Integer code=0;
    private String msg="";
    private Long count;
    private Object data;
    public DataGridView() {
    }
    public DataGridView(Object data) {
        super();
        this.data = data;
    }
    public DataGridView(Long count, Object data) {
        super();
        this.count = count;
        this.data = data;
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public Long getCount() {
        return count;
    }
    public void setCount(Long count) {
        this.count = count;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
}





```

##### 封装客户实体对象Customer

```
package com.qfedu.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/*
封装客户实体对象
 */
public class Customer {
    //身份证号
    private String identity;
    //客户名称
    private String custname;
    //性别
    private Integer sex;
    //地址
    private String address;
    //电话
    private String phone;
    //职业
    private String career;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createtime;
    public String getIdentity() {
        return identity;
    }
    public void setIdentity(String identity) {
        this.identity = identity == null ? null : identity.trim();
    }
    public String getCustname() {
        return custname;
    }
    public void setCustname(String custname) {
        this.custname = custname == null ? null : custname.trim();
    }
    public Integer getSex() {
        return sex;
    }
    public void setSex(Integer sex) {
        this.sex = sex;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
    public String getPhone() {

        return phone;

    }
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }
    public String getCareer() {
        return career;
    }
    public void setCareer(String career) {
        this.career = career == null ? null : career.trim();
    }
    public Date getCreatetime() {
        return createtime;
    }
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "identity='" + identity + '\'' +
                ", custname='" + custname + '\'' +
                ", sex=" + sex +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", career='" + career + '\'' +
                ", createtime=" + createtime +
                '}';
    }
}

```

##### 封装客户视图对象CustomerVo

```
package com.qfedu.vo;

import com.qfedu.pojo.Customer;

public class CustomerVo extends Customer {
    /**
     * 分⻚参数
     */
    private Integer page;
    private Integer limit;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}

```

##### CustomerController 控制器

```
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
```

##### CustomerService接⼝

```
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

```

##### CustomerServiceImpl 实现类

```
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

```

##### CustomerMapper接⼝

```
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

```

##### CustomerMapper.xml

```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.qfedu.dao.CustomerMapper">
    <sql id="Base_Column_List">
        identity ,custname ,sex , address , phone , career , createtime
    </sql>

    <resultMap id="BaseResultMap" type="com.qfedu.pojo.Customer">
        <id column="identity" jdbcType="VARCHAR" property="identity"></id>
        <result column="custname" jdbcType="VARCHAR" property="custname"></result>
        <result column="sex" jdbcType="INTEGER" property="sex"></result>
        <result column="address" jdbcType="VARCHAR" property="address"></result>
        <result column="phone" jdbcType="VARCHAR" property="phone"></result>
        <result column="career" jdbcType="VARCHAR" property="career"></result>
        <result column="createtime" jdbcType="TIMESTAMP" property="createtime"></result>
    </resultMap>
    <select id="queryAllCustomer" resultMap="BaseResultMap">
        select <include refid="Base_Column_List"/>
        from t_customer
        <where>
            <if test="identity != null and identity != ''">
                and identity  like concat("%",#{identity},"%")
            </if>
            <if test="custname != null and custname != ''">
                and custname  like concat("%",#{custname},"%")
            </if>
            <if test="phone != null and phone != ''">
                and phone  like concat("%",#{phone},"%")
            </if>
            <if test="career != null and career != ''">
                and career  like concat("%",#{career},"%")
            </if>
            <if test="address != null and address != ''">
                and address  like concat("%",#{address},"%")
            </if>
            <if test="sex != null ">
                and sex = #{sex}
            </if>
        </where>
        order by createtime desc
    </select>

    <!--添加客户-->
    <insert id="addCustomer" parameterType="com.qfedu.vo.CustomerVo">
        insert into t_customer
         <trim prefix="(" suffix=")" suffixOverrides=",">
             <if test="identity != null">
                 identity,
             </if>
             <if test="custname != null">
                 custname,
             </if>
             <if test="sex != null">
                 sex,
             </if>
             <if test="address != null">
                 address,
             </if>
             <if test="phone != null">
                 phone,
             </if>
             <if test="career != null">
                 career,
             </if>
             <if test="createtime != null">
                 createtime,
             </if>
         </trim>
         <trim prefix="values (" suffix=")" suffixOverrides=",">
            <if test="identity != null">
                #{identity},
            </if>
            <if test="custname != null">
                #{custname},
            </if>
            <if test="sex != null">
                #{sex},
            </if>
            <if test="address != null">
                #{address},
            </if>
            <if test="phone != null">
                #{phone},
            </if>
            <if test="career != null">
                #{career},
            </if>
            <if test="createtime != null">
                #{createtime},
            </if>
        </trim>
    </insert>

    <!--修改客户信息-->
    <update id="updateCustomer">
        update t_customer
        <set>
            <if test="custname != null">
                custname = #{custname},
            </if>
            <if test="sex != null">
                sex = #{sex},
            </if>
            <if test="address != null">
                address = #{address},
            </if>
            <if test="phone != null">
                phone = #{phone},
            </if>
            <if test="career != null">
                career = #{career},
            </if>
        </set>
        where identity = #{identity }
    </update>


    <!--删除客户信息-->
    <delete id="deleteCustomer">
        delete from t_customer where identity = #{identity }
    </delete>
</mapper>
```

