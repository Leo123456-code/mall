package com.imooc.mall.vo;

/**
 * created by Leo徐忠春
 * created Time 2020/1/7-2:00
 * email 1437665365@qq.com
 */

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品详情对象VO
 */
@Data
public class ProductDetailVo {

    private Integer id;

    private Integer categoryId;

    private String name;

    private String subtitle;

    private String mainImage;

    private String subImages;

    private String detail;

    private BigDecimal price;

    private Integer stock;

    private Integer status;

    private Date createTime;

    private Date updateTime;

}
