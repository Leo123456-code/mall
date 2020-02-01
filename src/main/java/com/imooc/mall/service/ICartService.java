package com.imooc.mall.service;

import com.imooc.mall.form.CartAddForm;
import com.imooc.mall.form.CartUpdateForm;
import com.imooc.mall.vo.CartVo;
import com.imooc.mall.vo.ResponseVo;

/**
 * created by Leo徐忠春
 * created Time 2020/1/7-4:07
 * email 1437665365@qq.com
 */
public interface ICartService {
    //购物车存入redis中
    ResponseVo<CartVo> add(Integer uid, CartAddForm from);
    //購物車列表
    ResponseVo<CartVo> list(Integer uid);
    //更新購物車列表
    ResponseVo<CartVo> update(Integer uid, Integer productId,
                              CartUpdateForm cartUpdateForm);
    //删除購物車列表
    ResponseVo<CartVo> delete(Integer uid, Integer productId);
    //全选中
    ResponseVo<CartVo> selectAll(Integer uid);
    //全不选中
    ResponseVo<CartVo> unSelectAll(Integer uid);
    //获取购物车数量的总和
    ResponseVo<Integer> productSum(Integer uid);


}
