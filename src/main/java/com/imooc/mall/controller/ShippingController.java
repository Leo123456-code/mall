package com.imooc.mall.controller;

import com.github.pagehelper.PageInfo;
import com.imooc.mall.consts.MallConsts;
import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.form.ShippingForm;
import com.imooc.mall.pojo.User;
import com.imooc.mall.service.IShippingService;
import com.imooc.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Map;

/**
 * created by Leo徐忠春
 * created Time 2020/1/8-4:37
 * email 1437665365@qq.com
 */
@RestController

public class ShippingController {
    @Autowired
    private IShippingService shippingService;


    //添加地址
    @PostMapping(" /shippings")
    public ResponseVo shippings(@Valid @RequestBody Integer uid,
                                ShippingForm form,HttpSession session){
        User user = (User) session.getAttribute(MallConsts.CURRENT_USER);
        ResponseVo<Map<String, Integer>> map = shippingService.add(user.getId(), form);
        return map;
    }
    //删除地址
    @DeleteMapping("/shippings/{shippingId}")
    public ResponseVo delete(@Valid @RequestBody Integer uid, Integer ShippingId,
                             HttpSession session){
        User user = (User) session.getAttribute(MallConsts.CURRENT_USER);
        ResponseVo responseVo = shippingService.delete(user.getId(), ShippingId);
        return responseVo;
    }
    //更新地址
    @PutMapping("/shippings/{shippingId}")
    public ResponseVo update(@Valid @RequestBody Integer uid, Integer ShippingId,
                             ShippingForm form,HttpSession session){
        User user = (User) session.getAttribute(MallConsts.CURRENT_USER);
        ResponseVo responseVo = shippingService.update(user.getId(), ShippingId, form);
        return responseVo;
    }
    //地址列表
    @GetMapping("/shippings")
    public ResponseVo list( @RequestParam(required = false,defaultValue = "1") Integer pageNum,
                            @RequestParam(required = false,defaultValue = "10")Integer pageSize,
                            @Valid @RequestBody Integer uid,
                            HttpSession session){

        User user = (User) session.getAttribute(MallConsts.CURRENT_USER);
        ResponseVo<PageInfo> list = shippingService.list(user.getId(),pageNum,pageSize);
        if(user == null){
            return ResponseVo.error(ResponseEnum.SHIPPING_NOT_LOGIN);
        }
        return list;
    }
}
