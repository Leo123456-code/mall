package com.imooc.mall.service;

import com.github.pagehelper.PageInfo;
import com.imooc.mall.vo.ProductDetailVo;
import com.imooc.mall.vo.ResponseVo;

/**
 * created by Leo徐忠春
 * created Time 2020/1/6-16:24
 * email 1437665365@qq.com
 */
public interface IProductService {
    ResponseVo<PageInfo> list(Integer categoryId,
                              Integer pageNum, Integer pageSize);
    //商品详情
    ResponseVo<ProductDetailVo> detail(Integer productId);
}
