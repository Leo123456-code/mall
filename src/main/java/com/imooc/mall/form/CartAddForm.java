package com.imooc.mall.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * created by Leo徐忠春
 * created Time 2020/1/7-3:36
 * email 1437665365@qq.com
 */
@Data
public class CartAddForm {
    /**
     * productId
     * selected: true
     */
    @NotNull
    private Integer productId;

    private Boolean selected;
}
