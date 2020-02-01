package com.imooc.mall.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * created by Leo徐忠春
 * created Time 2020/1/8-2:34
 * email 1437665365@qq.com
 */
@Data
public class ShippingForm {
    /**
     * receiverName=廖师兄
     * receiverPhone=010
     * receiverMobile=18688888888
     * receiverProvince=北京
     * receiverCity=北京市
     * receiverDistrict=海淀区
     * receiverAddress=中关村
     * receiverZip=100000
     */
    @NotBlank
    private String receiverName;
    @NotBlank
    private String receiverPhone;
    @NotBlank
    private String receiverMobile;
    @NotBlank
    private String receiverProvince;
    @NotBlank
    private String receiverCity;
    @NotBlank
    private String receiverDistrict;
    @NotBlank
    private String receiverAddress;
    @NotBlank
    private String receiverZip;




}
