package com.imooc.mall.controller;


import com.imooc.mall.consts.MallConsts;
import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.form.UserLoginForm;
import com.imooc.mall.form.UserRegisterForm;
import com.imooc.mall.pojo.User;
import com.imooc.mall.service.IUserService;
import com.imooc.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * created by Leo徐忠春
 * created Time 2020/1/4-19:36
 * email 1437665365@qq.com
 */
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;


    @PostMapping("/register")
    public ResponseVo register(@Valid @RequestBody UserRegisterForm userForm,
                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("注册提交的参数有误,{}{}",
                    bindingResult.getFieldError().getField(),
                    bindingResult.getFieldError().getDefaultMessage());
            return ResponseVo.error(ResponseEnum.PARAM_ERROR, bindingResult);
        }

        User user = new User();
        //把UserForm拷贝到User中
        BeanUtils.copyProperties(userForm, user);
        return userService.register(user);
    }

    /**
     * 登錄
     */
    @PostMapping("/login")
    public ResponseVo login(@Valid @RequestBody UserLoginForm user,
                            BindingResult bindingResult,
                            HttpServletRequest httpServletRequest){

        if(bindingResult.hasErrors()){
            log.error("賬號和密碼有誤={}{}",bindingResult.getFieldError().getField(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        ResponseVo<User> userResponseVo=userService.login(user.getUsername(),user.getPassword());
        //設置session
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute(MallConsts.CURRENT_USER,userResponseVo.getData());
        return userService.login(user.getUsername(),user.getPassword());
    }

    /**
     * 獲取用戶的登錄信息
     */
    @GetMapping("/user")
    public ResponseVo<User> userInfo(HttpSession session){
        User user=(User)session.getAttribute(MallConsts.CURRENT_USER);
        if(user==null){
            return ResponseVo.error(ResponseEnum.NEED_LOGIN);
        }
        return ResponseVo.success(user);
    }
}
