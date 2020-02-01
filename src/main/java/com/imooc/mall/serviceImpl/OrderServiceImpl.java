package com.imooc.mall.serviceImpl;

import com.imooc.mall.dao.ShippingMapper;
import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.pojo.Shipping;
import com.imooc.mall.service.ICartService;
import com.imooc.mall.service.IOrderService;
import com.imooc.mall.vo.OrderVo;
import com.imooc.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * created by Leo徐忠春
 * created Time 2020/1/11-5:27
 * email 1437665365@qq.com
 */
@Slf4j
@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private ShippingMapper shippingMapper;
    @Autowired
    private ICartService cartService;
    @Override
    public ResponseVo<OrderVo> create(Integer uid,
                                      Integer shippingId) {
        //收货地址效验(总之要查出来)
        Shipping shipping = shippingMapper.
                selectByUidAndShippingId(uid, shippingId);
        if(shipping==null){
            return ResponseVo.error
                    (ResponseEnum.SHIPPING_NOT_EXIST);
        }
        //获取购物车,效验(是否有商品,库存)

        //计算总价,只计算选中的商品
        //生成订单,入库,order和order_item,事务控制
        //减库存
        //清空购物车(选中的商品)
        //构造OrderVo
        return null;
    }
}
