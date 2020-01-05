package com.imooc.mall.enums;

/**
 * created by Leo徐忠春
 * created Time 2020/1/4-22:15
 * email 1437665365@qq.com
 */

import lombok.Getter;

/**
 * 注册异常枚举
 */
@Getter
public enum  ResponseEnum {
    ERROR(-1,"服务端错误"),
    SUCCESS(0,"成功"),
    PASSWORD_ERROR(1,"密码错误"),
    USERNAME_EXIST(2,"用户名已存在"),
    PARAM_ERROR(3,"参数错误"),
    EMAIL_ERROR(4,"邮箱已存在"),
    NEED_LOGIN(10,"用户未登录,请先登录"),
    USER_OR_PASSWORD_FAIL(11,"用戶名或密碼錯誤");
        ;
    private Integer code;
    private String desc;

    ResponseEnum(Integer code,String desc){
        this.code=code;
        this.desc=desc;
    }



}
