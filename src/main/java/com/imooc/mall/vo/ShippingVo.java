package com.imooc.mall.vo;

import lombok.Data;

import java.util.Date;

/**
 * created by Leo徐忠春
 * created Time 2020/1/11-5:22
 * email 1437665365@qq.com
 */
@Data
public class ShippingVo {

    private Integer id;

    private Integer userId;

    private String receiverName;

    private String receiverPhone;

    private String receiverMobile;

    private String receiverProvince;

    private String receiverCity;

    private String receiverDistrict;

    private String receiverAddress;

    private String receiverZip;

    private Date createTime;

    private Date updateTime;

}
