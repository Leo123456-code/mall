package com.imooc.mall.dao;

import com.imooc.mall.pojo.orderItem;

public interface orderItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(orderItem record);

    int insertSelective(orderItem record);

    orderItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(orderItem record);

    int updateByPrimaryKey(orderItem record);
}