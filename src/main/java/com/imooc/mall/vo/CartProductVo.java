package com.imooc.mall.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * created by Leo徐忠春
 * created Time 2020/1/7-3:22
 * email 1437665365@qq.com
 */
@Data
public class CartProductVo {

    private Integer productId;
    //购买数量
    private Integer quantity;
    private String productName;
    private String productSubtitle;
    private String productMainImage;
    private BigDecimal productPrice;
    private Integer productStatus;
    //总价 =quantity*productPrice
    private BigDecimal productTotalPrice;
    //库存
    private Integer productStock;
    //商品是否选中
    private Boolean productSelected;


    public CartProductVo() {
    }

    public CartProductVo(Integer productId, Integer quantity, String productName, String productSubtitle, String productMainImage, BigDecimal productPrice, Integer productStatus, BigDecimal productTotalPrice, Integer productStock, Boolean productSelected) {
        this.productId = productId;
        this.quantity = quantity;
        this.productName = productName;
        this.productSubtitle = productSubtitle;
        this.productMainImage = productMainImage;
        this.productPrice = productPrice;
        this.productStatus = productStatus;
        this.productTotalPrice = productTotalPrice;
        this.productStock = productStock;
        this.productSelected = productSelected;
    }
}
