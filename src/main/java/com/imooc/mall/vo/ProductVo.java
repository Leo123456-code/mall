package com.imooc.mall.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * created by Leo徐忠春
 * created Time 2020/1/6-16:21
 * email 1437665365@qq.com
 */
@Data
public class ProductVo {
    private Integer id;

    private Integer categoryId;

    private String name;

    private String subtitle;

    private String mainImage;

    private Integer status;

    private BigDecimal price;

}
