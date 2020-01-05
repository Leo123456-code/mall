package com.imooc.mall.dao;

import com.imooc.mall.pojo.Category;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * created by Leo徐忠春
 * created Time 2020/1/1-20:16
 * email 1437665365@qq.com
 */
//@Mapper
public interface CategoryMapper {
    @Select("select * from mall_category")
    List<Category> findByCategory();
    //测试
    @Select(("select * from mall_category where id=#{id}"))
    Category findById(@Param("id")Integer id);
    //
    Category updateName(@Param("id")Integer id);
    //
    Category selectById(@Param("id") Integer id);
}
