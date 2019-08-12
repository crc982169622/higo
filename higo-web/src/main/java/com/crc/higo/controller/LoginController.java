package com.crc.higo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: chenrencun
 * @Date: 2019/8/12 15:23
 * @Description: 描述
 */
@Controller
public class LoginController {

    @RequestMapping("/")
    public String loginPage(){
        return "/login";
    }

}
