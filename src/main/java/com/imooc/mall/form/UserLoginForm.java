package com.imooc.mall.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * created by Leo徐忠春
 * created Time 2020/1/4-22:41
 * email 1437665365@qq.com
 */
@Data
public class UserLoginForm {
    //不能为空
    @NotBlank(message = "用户名不能为空")
    private String username;
    @NotBlank(message = "密码不能为空")
    private String password;
}
