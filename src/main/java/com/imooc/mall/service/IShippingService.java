package com.imooc.mall.service;

import com.github.pagehelper.PageInfo;
import com.imooc.mall.form.ShippingForm;
import com.imooc.mall.vo.ResponseVo;

import java.util.Map;

/**
 * created by Leo徐忠春
 * created Time 2020/1/8-2:36
 * email 1437665365@qq.com
 */
public interface IShippingService {
    //新增地址
    ResponseVo<Map<String,Integer>> add(Integer uid, ShippingForm form);
    //删除地址
    ResponseVo delete(Integer uid,Integer shippingId);
    //更新地址
    ResponseVo update(Integer uid,Integer
            shippingId,ShippingForm form);
    //地址列表
    ResponseVo<PageInfo> list(Integer uid,
                              Integer pageNum, Integer pageSize);
}
