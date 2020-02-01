package com.imooc.mall.form;

import lombok.Data;

/**
 * created by Leo徐忠春
 * created Time 2020/1/8-0:40
 * email 1437665365@qq.com
 */
@Data
public class CartUpdateForm {

     private Integer quantity;
     private Boolean selected;

    public CartUpdateForm() {
    }

    public CartUpdateForm(Integer quantity, Boolean selected) {
        this.quantity = quantity;
        this.selected = selected;
    }
}
