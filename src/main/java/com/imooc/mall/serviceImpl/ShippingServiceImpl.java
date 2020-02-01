package com.imooc.mall.serviceImpl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imooc.mall.dao.ShippingMapper;
import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.form.ShippingForm;
import com.imooc.mall.pojo.Shipping;
import com.imooc.mall.service.IShippingService;
import com.imooc.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created by Leo徐忠春
 * created Time 2020/1/8-2:47
 * email 1437665365@qq.com
 */
@Service
@Slf4j
public class ShippingServiceImpl implements IShippingService {
    @Autowired
    private ShippingMapper shippingMapper;

    //新增地址
    @Override
    public ResponseVo<Map<String, Integer>> add(Integer uid,
                                                ShippingForm form) {
        Shipping shipping = new Shipping();
        BeanUtils.copyProperties(form,shipping);
        shipping.setUserId(uid);
        int row = shippingMapper.insertSelective(shipping);
        if(row == 0){
            return ResponseVo.error(ResponseEnum.ERROR);
        }
        Map<String, Integer> map = new HashMap<>();
        map.put("shippingId",shipping.getId());

        return ResponseVo.success(map);
    }

    //删除地址
    @Override
    public ResponseVo delete(Integer uid, Integer shippingId) {
        int row = shippingMapper.deleteByIdAndUid(uid, shippingId);
        if(row == 0){
            return ResponseVo.error(ResponseEnum.SHIPPING_DELETE_FAIL);
        }
        return ResponseVo.success(ResponseEnum.SHIPPING_DELETE_SUCCESS.getDesc());
    }

    //更新地址
    @Override
    public ResponseVo update(Integer uid, Integer shippingId, ShippingForm form) {
        Shipping shipping = new Shipping();
        BeanUtils.copyProperties(form,shipping);
        shipping.setUserId(uid);
        shipping.setId(shippingId);
        int row = shippingMapper.updateByPrimaryKeySelective(shipping);
        if(row == 0){
            return ResponseVo.error(ResponseEnum.SHIPPING_UPDATE_FAIL);
        }

        return ResponseVo.error(ResponseEnum.SHIPPING_UPDATE_SUCCESS);
    }



    //地址列表
    @Override
    public ResponseVo<PageInfo> list(Integer uid, Integer pageNum,
                                     Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Shipping> list = shippingMapper.selectByUid(uid);
        PageInfo pageInfo = new PageInfo(list);

        if (pageInfo == null){
            return ResponseVo.error(ResponseEnum.ERROR);
        }
        return ResponseVo.success(pageInfo);
    }
}
