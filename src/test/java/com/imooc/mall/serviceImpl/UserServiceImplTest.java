package com.imooc.mall.serviceImpl;

import com.imooc.mall.MallApplicationTests;
import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.enums.RoleEnum;
import com.imooc.mall.pojo.User;
import com.imooc.mall.service.IUserService;
import com.imooc.mall.vo.ResponseVo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * created by Leo徐忠春
 * created Time 2020/1/4-18:41
 * email 1437665365@qq.com
 */

public class UserServiceImplTest extends MallApplicationTests {
    public static final String USERNAME="jack";
    public static final String PASSWORD="123456";

    @Autowired
    private IUserService userService;

    @Test
    @Before
    public void register(){
        User user = new User(USERNAME,PASSWORD,
                RoleEnum.CUSTOMER.getCode(),"1437665365@qq.com");
        userService.register(user);

    }

    @Test
    public void login(){
        register();
        ResponseVo<User> responseVo=userService.login(USERNAME,PASSWORD);
        //比较成功0与执行结果的状态的比较
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }

}

