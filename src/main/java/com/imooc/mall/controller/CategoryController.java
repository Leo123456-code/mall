package com.imooc.mall.controller;

import com.imooc.mall.pojo.Category;
import com.imooc.mall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * created by Leo徐忠春
 * created Time 2020/1/1-20:19
 * email 1437665365@qq.com
 */
@RestController
@RequestMapping("/user")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/getFindAll")
    public List<Category> getFindAll(){

        return categoryService.findAll();
    }
    @RequestMapping("/getById")
    public Category getById(){

        return categoryService.findByCategoryId();
    }

    @RequestMapping("/updateByName")
    public Category updateByName(Integer id){

        return categoryService.updateByCategory(id);
    }


    @RequestMapping("/seleceById")
    public Category seleceById(Integer id){

        return categoryService.selectCategoryById(id);
    }





}
