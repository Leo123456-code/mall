package com.imooc.mall.interceptor;

/**
 * created by Leo徐忠春
 * created Time 2020/1/6-2:13
 * email 1437665365@qq.com
 */

import com.imooc.mall.consts.MallConsts;
import com.imooc.mall.exception.UserLoginException;
import com.imooc.mall.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 统一对登录状态进行拦截
 */
@Slf4j
public class UserLoginInterceptor implements HandlerInterceptor {
    /**
     * true表示继续流程,false表示中断
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    //在执行之前拦截
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        log.info("preHandle()");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(MallConsts.CURRENT_USER);
        if(user==null){
            log.info("user==null");
            throw  new UserLoginException();
        }

        return true;
    }
}
