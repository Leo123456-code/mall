package com.imooc.mall.vo;

/**
 * created by Leo徐忠春
 * created Time 2020/1/4-21:43
 * email 1437665365@qq.com
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import com.imooc.mall.enums.ResponseEnum;
import lombok.Data;
import org.springframework.validation.BindingResult;

import java.util.Objects;

/**
 * 注册的返回值
 */
@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ResponseVo<T> {
    private Integer status;
    private String msg;
    private T data;

    public ResponseVo(Integer status,String msg){
        this.status=status;
        this.msg=msg;
    }
    public ResponseVo(Integer status,T data){
        this.status=status;
        this.data=data;
    }

    public static <T> ResponseVo<T> successByMsg(String msg){

        return new ResponseVo<>(ResponseEnum.SUCCESS.getCode(),msg);
    }
    public static <T> ResponseVo<T> success(String msg){

        return new ResponseVo<>(ResponseEnum.SUCCESS.getCode(),msg);
    }
    public static <T> ResponseVo<T> success(T data){

        return new ResponseVo<>(ResponseEnum.SUCCESS.getCode(),data);
    }
    //注册成功
    public static <T> ResponseVo<T> success(){
        return new ResponseVo<>(ResponseEnum.SUCCESS.getCode(),
                ResponseEnum.SUCCESS.getDesc());
    }
    //注册失败
    public static <T> ResponseVo<T> error(ResponseEnum responseEnum){
        return new ResponseVo<>(responseEnum.getCode(),responseEnum.getDesc());
    }
    //注册失败,给前端提示
    public static <T> ResponseVo<T> error(ResponseEnum responseEnum,String msg){
        return new ResponseVo<>(responseEnum.getCode(),msg);
    }
    //注册失败,给前端提示
    public static <T> ResponseVo<T> error(ResponseEnum responseEnum, BindingResult bindingResult){
        return new ResponseVo<>(responseEnum.getCode(), Objects.requireNonNull(bindingResult.getFieldError()).getField()+
                " "+bindingResult.getFieldError().getDefaultMessage());
    }

}
