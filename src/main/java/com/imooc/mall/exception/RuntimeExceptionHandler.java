package com.imooc.mall.exception;


import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.vo.ResponseVo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * created by Leo徐忠春
 * created Time 2020/1/5-1:46
 * email 1437665365@qq.com
 */
@ControllerAdvice
public class RuntimeExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseVo handle(RuntimeException e){

        return ResponseVo.error(ResponseEnum.PARAM_ERROR,e.getMessage());
    }

    @ExceptionHandler(UserLoginException.class)
    @ResponseBody
    public ResponseVo userLoginHandle(){

        return ResponseVo.error(ResponseEnum.NEED_LOGIN);
    }
}
