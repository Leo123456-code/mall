package com.imooc.mall.enums;

import lombok.Getter;

/**
 * created by Leo徐忠春
 * created Time 2020/1/7-2:13
 * email 1437665365@qq.com
 */
@Getter
public enum DetailStatusEnum {
    ON_SALE(1,"在售"),
    OFF_SALE(2,"下架"),
    DELETE(3,"删除"),
    ;
    private Integer code;
    private String msg;

    DetailStatusEnum(Integer code,String msg){
        this.code=code;
        this.msg=msg;

    }
}
