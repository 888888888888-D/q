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
