package com.crc.higo.controller;

import com.crc.higo.base.BaseController;
import com.crc.higo.domain.UserDomain;
import com.crc.higo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String info(){
        UserDomain userDomain = this.getLoginUser();
        return "/my/info";
    }

}
