package com.imooc.mall.serviceImpl;

import com.imooc.mall.MallApplicationTests;
import com.imooc.mall.enums.RoleEnum;
import com.imooc.mall.pojo.User;
import com.imooc.mall.service.IUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * created by Leo徐忠春
 * created Time 2020/1/4-18:41
 * email 1437665365@qq.com
 */

public class UserServiceImplTest extends MallApplicationTests {

    @Autowired
    private IUserService userService;

    @Test
    public void test(){
        User user = new User("jack","123456",
                RoleEnum.CUSTOMER.getCode(),"1437665365@qq.com");
        userService.register(user);

    }

}