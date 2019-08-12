package com.crc.higo.base;

import com.crc.higo.domain.UserDomain;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * @author: chenrencun
 * @version：
 * @date: 2019/8/12 21:31
 **/
public abstract class BaseController {

    private static final String USER_LOGIN_KEY = "userMessage";

    private HttpServletRequest getRequest(){
        return ((ServletRequestAttributes)Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }

    public UserDomain getLoginUser(){
        HttpSession session = getRequest().getSession();
        return (UserDomain)session.getAttribute(USER_LOGIN_KEY);
    }

    public void setLoginUser(UserDomain user){
        HttpSession session = getRequest().getSession();
        if (user != null) {
            //清空用户密码
            user.setPassword("");
            session.setAttribute(USER_LOGIN_KEY, user);
            //设置session过期时间3小时
            session.setMaxInactiveInterval(3*60*60);
        }

    }
}
