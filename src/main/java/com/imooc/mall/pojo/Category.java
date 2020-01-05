package com.imooc.mall.pojo;

import jdk.nashorn.internal.ir.annotations.Immutable;
import lombok.Data;
import lombok.Value;

import java.util.Date;

/**
 * created by Leo徐忠春
 * created Time 2020/1/1-20:09
 * email 1437665365@qq.com
 */
@Data
public class Category {
    //类别Id
    private Long id;
    //父类别id当id=0时说明是根节点,一级类别
    private Long parentId;
    //类别名称
    private String name;
    //类别状态1-正常,2-已废弃
    private Integer status;
    //排序编号,同类展示顺序,数值相等则自然排序
    private Integer sortOrder;
    //创建时间
    private Date createTime;
    //创建时间
    private Date updateTime;

}
