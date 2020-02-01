package com.imooc.mall.dao;


import com.imooc.mall.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);



    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
    //
    List<Product> selectByCategoryIdSet
            (@Param("categoryIdSet") Set<Integer> categoryIdSet);
    //商品详情
    Product selectByPrimaryKey(Integer id);
}