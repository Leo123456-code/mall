package com.imooc.mall.pojo;

import lombok.Data;

/**
 * created by Leo徐忠春
 * created Time 2020/1/7-4:32
 * email 1437665365@qq.com
 */

/**
 * 存在redis中的數據
 */
@Data
public class Cart {
    private Integer productId;
    //购买数量
    private Integer quantity;
    //商品是否选中
    private Boolean productSelected;
    public Cart(){}
    public Cart(Integer productId,Integer quantity,Boolean productSelected){
        this.productId=productId;
        this.quantity=quantity;
        this.productSelected=productSelected;
    }

}
