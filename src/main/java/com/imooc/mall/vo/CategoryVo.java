package com.imooc.mall.vo;

import lombok.Data;

import java.util.List;

/**
 * created by Leo徐忠春
 * created Time 2020/1/6-3:43
 * email 1437665365@qq.com
 */
@Data
public class CategoryVo {
    private Integer id;

    private Integer parentId;

    private String name;

    private Integer sortOrder;
    //子类目
    private List<CategoryVo> subCategories;


}
