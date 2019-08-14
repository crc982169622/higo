package com.crc.higo.controller;

import com.crc.higo.base.BaseController;
import com.crc.higo.domain.UserDomain;
import com.crc.higo.service.UserService;
import com.crc.higo.util.ResultMessage;
import com.crc.higo.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: chenrencun
 * @Date: 2019/8/12 14:04
 * @Description: user接口类
 */
@Controller
@RequestMapping("/user")
public class userController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping("/info")
    public String info(HttpServletRequest request){
        UserDomain userDomain = this.getLoginUser();
        request.setAttribute("userDomain", userDomain);
        return "/my/info";
    }

    @RequestMapping("/editInfo")
    @ResponseBody
    public ResultMessage editInfo(UserDomain userDomain) {
        try {
            UserDomain dbUser = userService.findUserById(userDomain.getId());
            userDomain.setPassword(dbUser.getPassword());
            userService.updateUserDomain(userDomain);
            return new ResultMessage(SUCCESS, "修改用户信息成功");
        } catch (Exception e) {
            logger.error("修改用户信息错误" + StringUtil.getStackTrace(e));
            return new ResultMessage(ERROR, "修改用户信息错误");
        }
    }

    @RequestMapping("/editPassword")
    public String editPassword(){
        return "/my/editPassword";
    }


    @RequestMapping("/findUserList")
    @ResponseBody
    public ResultMessage findUserList(){
        try {
            List<UserDomain> userList = userService.findUserList();
            return new ResultMessage(SUCCESS, userList);
        } catch (Exception e) {
            logger.error("获取用户列表错误" + StringUtil.getStackTrace(e));
            return new ResultMessage(ERROR,"获取用户列表错误");
        }
    }

}
