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
