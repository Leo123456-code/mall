package com.imooc.mall.dao;


import com.imooc.mall.pojo.Shipping;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

public interface ShippingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shipping record);

    int insertSelective(Shipping record);

    Shipping selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shipping record);

    int updateByPrimaryKey(Shipping record);

    int deleteByIdAndUid(@Param("uid") Integer uid,
                         @Param("shippingId") Integer shippingId);

    List<Shipping> selectByUid(Integer uid);

//    Shipping selectByUidAndShippingId(@Param("uid") Integer uid,
//                                      @Param("shippingId") Integer shippingId);
//
//    List<Shipping> selectByIdSet(@Param("idSet") Set idSet);

    Shipping selectByUidAndShippingId(@Param("uid") Integer uid,
                                      @Param("shippingId")
                                              Integer shippingId);
}