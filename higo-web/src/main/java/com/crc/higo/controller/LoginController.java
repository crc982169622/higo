package com.crc.higo.controller;

import com.crc.higo.base.BaseController;
import com.crc.higo.util.ResultMessage;
import com.crc.higo.domain.UserDomain;
import com.crc.higo.service.UserService;
import com.crc.higo.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: chenrencun
 * @Date: 2019/8/12 15:23
 * @Description: 描述
 */
@Controller
public class LoginController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String loginPage(){
        return "/login";
    }

    @RequestMapping("/doLogin")
    @ResponseBody
    public ResultMessage doLogin(UserDomain user){
        try {
            List<UserDomain> dbUsers = userService.findUserByName(user.getUserName());
            if (dbUsers != null && dbUsers.size() > 0) {
                if (dbUsers.get(0).getPassword().equals(user.getPassword())) {
                    dbUsers.get(0).setPassword("");
                    //登录成功
                    this.setLoginUser(dbUsers.get(0));
                    return new ResultMessage();
                } else {
                    return new ResultMessage(ERROR,"密码不正确");
                }
            } else {
                return new ResultMessage(ERROR, "此用户名不存在");
            }
        } catch (Exception e){
            logger.error("用户登录错误" + StringUtil.getStackTrace(e));
            return new ResultMessage(ERROR, "用户登录错误");
        }

    }

    @RequestMapping("/main")
    public String main(HttpServletRequest request){
        UserDomain userDomain = this.getLoginUser();
        request.setAttribute("user",userDomain);
        return "/main";
    }

    @RequestMapping("/findUserByName")
    @ResponseBody
    public ResultMessage findUserByName(String userName){
        List<UserDomain> dbUsers = userService.findUserByName(userName);
        if (dbUsers != null && dbUsers.size() > 0){
            return new ResultMessage("error", "此用户名已存在");
        }
        return new ResultMessage();
    }

}
