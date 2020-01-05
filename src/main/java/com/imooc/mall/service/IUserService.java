package com.imooc.mall.service;

import com.imooc.mall.pojo.User;
import com.imooc.mall.vo.ResponseVo;

/**
 * created by Leo徐忠春
 * created Time 2020/1/4-17:57
 * email 1437665365@qq.com
 */
public interface IUserService {
    /**
     * 注册
     */
    ResponseVo register(User user);
    /**
     * 登录
     */
    ResponseVo<User> login(String username,String password);

}
