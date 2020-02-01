package com.imooc.mall.service;

import com.imooc.mall.vo.OrderVo;
import com.imooc.mall.vo.ResponseVo;

/**
 * created by Leo徐忠春
 * created Time 2020/1/11-5:25
 * email 1437665365@qq.com
 */
public interface IOrderService {
    //创建订单
    ResponseVo<OrderVo> create(Integer uid,Integer shippingId);

}
