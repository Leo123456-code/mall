package com.imooc.mall.service;

import com.imooc.mall.vo.CategoryVo;
import com.imooc.mall.vo.ResponseVo;

import java.util.List;

/**
 * created by Leo徐忠春
 * created Time 2020/1/6-3:46
 * email 1437665365@qq.com
 */
public interface ICategoryService {
    //查询所有的类目根据状态
    ResponseVo<List<CategoryVo>> selectAllByStatus();
}
