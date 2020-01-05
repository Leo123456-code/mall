package com.imooc.mall.service;

import com.imooc.mall.pojo.Category;

import java.util.List;

/**
 * created by Leo徐忠春
 * created Time 2020/1/1-20:20
 * email 1437665365@qq.com
 */
public interface CategoryService {

    List<Category> findAll();

    Category findByCategoryId();

    Category updateByCategory(Integer id);

    Category selectCategoryById(Integer id);
}
