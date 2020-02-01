package com.imooc.mall.service;

import com.imooc.mall.vo.CategoryVo;
import com.imooc.mall.vo.ResponseVo;

import java.util.List;
import java.util.Set;

/**
 * created by Leo徐忠春
 * created Time 2020/1/6-3:46
 * email 1437665365@qq.com
 */
public interface ICategoryService {
    //查询所有的类目商品 根据状态
    ResponseVo<List<CategoryVo>> selectAllByStatus();
    //根据子类目id查询所有的类目商品
    void findSubCategoryId(Integer id, Set<Integer> resultSet);

}
