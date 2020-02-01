package com.imooc.mall.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * created by Leo徐忠春
 * created Time 2020/1/7-3:19
 * email 1437665365@qq.com
 */
@Data
public class CartVo {

    private List<CartProductVo> cartProductVoList;



    private Boolean selectedAll;

    private BigDecimal cartTotalPrice;

    private Integer cartTotalQuantity;

    public CartVo() {
    }

    public CartVo(List<CartProductVo> cartProductVoList, Boolean selectedAll, BigDecimal cartTotalPrice, Integer cartTotalQuantity) {
        this.cartProductVoList = cartProductVoList;
        this.selectedAll = selectedAll;
        this.cartTotalPrice = cartTotalPrice;
        this.cartTotalQuantity = cartTotalQuantity;
    }



}
