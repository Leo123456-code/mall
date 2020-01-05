package com.imooc.mall.serviceImpl;

import com.imooc.mall.dao.UserMapper;
import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.pojo.User;
import com.imooc.mall.service.IUserService;
import com.imooc.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

/**
 * created by Leo徐忠春
 * created Time 2020/1/4-18:05
 * email 1437665365@qq.com
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 注册
     * @param user
     */
    @Override
    public ResponseVo register(User user) {
        //效验
        //用户名和邮箱不能重复
        int countByUsername = userMapper.CountByUsername(user.getUsername());
        if(countByUsername>0){
            return ResponseVo.error(ResponseEnum.USERNAME_EXIST);
        }
        int countByEmail = userMapper.CountByemail(user.getEmail());
        if(countByEmail>0){
            return ResponseVo.error(ResponseEnum.EMAIL_ERROR);
        }
        //MD5摘要算法(Spring自带)
        user.setPassword(DigestUtils.md5DigestAsHex(
                user.getPassword().getBytes(StandardCharsets.UTF_8)
        ));
        int resultCount = userMapper.insertSelective(user);
        if(resultCount==0){
            return ResponseVo.error(ResponseEnum.ERROR);
        }
        return ResponseVo.success();


    }

    @Override
    public ResponseVo<User> login(String username, String password) {
        //通過用戶名查數據
        User user = userMapper.selectByUsername(username);
        if(user==null){
            return ResponseVo.error(ResponseEnum.USER_OR_PASSWORD_FAIL);

        }
        if(!user.getPassword().equalsIgnoreCase
                (DigestUtils.md5DigestAsHex
                        (password.getBytes(StandardCharsets.UTF_8)))){
            //密碼錯誤
             return ResponseVo.error(ResponseEnum.USER_OR_PASSWORD_FAIL);
        }
        user.setPassword("");
        return ResponseVo.success(user);
    }
}
