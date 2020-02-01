package com.imooc.mall.controller;

import com.imooc.mall.consts.MallConsts;
import com.imooc.mall.form.CartAddForm;
import com.imooc.mall.form.CartUpdateForm;
import com.imooc.mall.pojo.User;
import com.imooc.mall.service.ICartService;
import com.imooc.mall.vo.CartVo;
import com.imooc.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * created by Leo徐忠春
 * created Time 2020/1/7-3:39
 * email 1437665365@qq.com
 */
@RestController
@Slf4j

public class CartController {
    @Autowired
    private ICartService cartService;

    //1.购物车添加商品
    @GetMapping("/carts")
    public ResponseVo<CartVo> list(HttpSession session){
        User user = (User) session.getAttribute(MallConsts.CURRENT_USER);
        return cartService.list(user.getId());

    }

    //2.购物车添加商品
    @PostMapping("/carts")
    public ResponseVo<CartVo> add(@Valid @RequestBody
                                          CartAddForm cartAddFrom,
                                  HttpSession session){
        User user = (User) session.getAttribute(MallConsts.CURRENT_USER);
        return cartService.add(user.getId(),cartAddFrom);
    }
    //3.更新购物车
    @PutMapping("/carts/{productId}")
    public ResponseVo<CartVo> update(@PathVariable Integer productId,
            @Valid @RequestBody CartUpdateForm form,
                                          HttpSession session){
        User user = (User) session.getAttribute(MallConsts.CURRENT_USER);
        return cartService.update(user.getId(),productId,form);
    }
    //4.移除购物车某个产品
    @DeleteMapping("/carts/{productId}")
    public ResponseVo<CartVo> delete(@PathVariable Integer productId,
                                          HttpSession session){
        User user = (User) session.getAttribute(MallConsts.CURRENT_USER);
        return cartService.delete(user.getId(),productId);
    }
    //5.全选中
    @PutMapping("/carts/selectAll")
    public ResponseVo<CartVo> selectAll(HttpSession session){
        User user = (User) session.getAttribute(MallConsts.CURRENT_USER);
        return cartService.selectAll(user.getId());
    }
    //6.全不选中
    @PutMapping(" /carts/unSelectAll")
    public ResponseVo<CartVo> unSelectAll(HttpSession session){
        User user = (User) session.getAttribute(MallConsts.CURRENT_USER);
        return cartService.unSelectAll(user.getId());
    }
    //7.获取购物中所有商品数量总和
   @GetMapping("/carts/products/sum")
    public ResponseVo<Integer> productSum(HttpSession session){
        User user = (User) session.getAttribute(MallConsts.CURRENT_USER);
        return cartService.productSum(user.getId());
    }

}
