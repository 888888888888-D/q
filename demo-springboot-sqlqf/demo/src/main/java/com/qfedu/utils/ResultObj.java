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


