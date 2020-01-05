package com.imooc.mall.serviceImpl;

import com.imooc.mall.dao.CategoryMapper;
import com.imooc.mall.pojo.Category;
import com.imooc.mall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * created by Leo徐忠春
 * created Time 2020/1/1-20:20
 * email 1437665365@qq.com
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> findAll() {
        Category category = new Category();
        category.setCreateTime(new Date());
        category.setUpdateTime(category.getCreateTime());
        List<Category> list = categoryMapper.findByCategory();
        return list;
    }

    @Override
    public Category findByCategoryId() {
        Category category = new Category();
        category.setCreateTime(new Date());
        category.setUpdateTime(category.getCreateTime());
        Category byId = categoryMapper.findById(100008);
        return byId;
    }

    @Override
    public Category updateByCategory(Integer id) {
        Category c = new Category();
        c.setStatus(1);
        return categoryMapper.updateName(100008);

    }

    @Override
    public Category selectCategoryById(Integer id) {
        return categoryMapper.selectById(100008);
    }
}
