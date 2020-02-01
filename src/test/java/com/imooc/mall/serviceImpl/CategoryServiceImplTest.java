package com.imooc.mall.serviceImpl;

import com.imooc.mall.MallApplicationTests;
import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.service.ICategoryService;
import com.imooc.mall.vo.CategoryVo;
import com.imooc.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * created by Leo徐忠春
 * created Time 2020/1/6-5:57
 * email 1437665365@qq.com
 */
@Slf4j
public class CategoryServiceImplTest extends MallApplicationTests {
    @Autowired
    private ICategoryService categoryService;

    @Test
    public void categories(){
        ResponseVo<List<CategoryVo>> responseVo =
                categoryService.selectAllByStatus();
        Integer status = responseVo.getStatus();
        log.info("responseVo.getStatus()={}",status);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),
                responseVo.getStatus());

    }

    @Test
    public void findSubCategoryId(){
        Set<Integer> set = new HashSet<>();
        categoryService.findSubCategoryId(100001,set);
        log.info("set={}",set);
    }

}