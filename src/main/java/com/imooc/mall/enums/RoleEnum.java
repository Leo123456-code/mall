package com.imooc.mall.enums;

import lombok.Getter;

/**
 * created by Leo徐忠春
 * created Time 2020/1/4-18:49
 * email 1437665365@qq.com
 */
@Getter
public enum RoleEnum {
    ADMIN(0),
    CUSTOMER(1),
    ;
    Integer code;

    RoleEnum(Integer code){
        this.code=code;
    }
}
