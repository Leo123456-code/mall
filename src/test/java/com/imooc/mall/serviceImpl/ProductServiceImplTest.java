package com.imooc.mall.serviceImpl;

import com.github.pagehelper.PageInfo;
import com.imooc.mall.MallApplicationTests;
import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.service.IProductService;
import com.imooc.mall.vo.ProductDetailVo;
import com.imooc.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * created by Leo徐忠春
 * created Time 2020/1/6-23:00
 * email 1437665365@qq.com
 */
@Slf4j
public class ProductServiceImplTest extends MallApplicationTests {
    @Autowired
    private IProductService productService;

    @Test
    public void selectByCategoryIdSet(){

        ResponseVo<PageInfo> responseVo = productService.list(null, 2, 2);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),
                responseVo.getStatus());

    }

    @Test
    public void detail(){
        ResponseVo<ProductDetailVo> detailVoResponseVo
                = productService.detail(26);
        Assert.assertEquals
                (ResponseEnum.SUCCESS.getCode(),detailVoResponseVo.getStatus());
    }


}