package com.imooc.mall.dao;

import com.imooc.mall.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    //查询用户名是不是唯一的
    int CountByUsername(String username);
    //查询email是不是唯一的
    int CountByemail(String email);
    //通過用戶名查詢
    User selectByUsername(String username);
}