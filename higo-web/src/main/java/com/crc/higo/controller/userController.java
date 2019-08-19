package com.crc.higo.controller;

import com.crc.higo.base.BaseController;
import com.crc.higo.domain.UserDomain;
import com.crc.higo.service.UserService;
import com.crc.higo.util.ResultMessage;
import com.crc.higo.util.ResultPageMessage;
import com.crc.higo.util.StringUtil;
import com.crc.higo.vo.UserVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
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
            dbUser.setUserName(userDomain.getUserName());
            dbUser.setNick(userDomain.getNick());
            dbUser.setMobile(userDomain.getMobile());
            userService.updateUserDomain(dbUser);
            return new ResultMessage(SUCCESS, "修改用户信息成功");
        } catch (Exception e) {
            logger.error("修改用户信息错误" + StringUtil.getStackTrace(e));
            return new ResultMessage(ERROR, "修改用户信息错误");
        }
    }

    @RequestMapping("/editPassword")
    public String editPassword(HttpServletRequest request){
        try {
            request.setAttribute("userId", this.getLoginUser().getId());
        } catch (Exception e) {
            logger.error("获取登录用户信息错误" + StringUtil.getStackTrace(e));
        }
        return "/my/editPassword";
    }

    @RequestMapping("/judgePassword")
    @ResponseBody
    public ResultMessage judgePassword(UserDomain userDomain){
        UserDomain dbUser = userService.findUserById(userDomain.getId());
        if (dbUser.getPassword().equals(userDomain.getPassword())) {
            return new ResultMessage();
        }
        return new ResultMessage(ERROR, "原密码不正确");

    }

    @RequestMapping("/editPasswordPro")
    @ResponseBody
    public ResultMessage editPasswordPro(UserDomain userDomain){
        try {
            userService.updatePassword(userDomain);
            this.setLoginUser(null);
            return new ResultMessage(SUCCESS, "修改用户密码成功");
        } catch (Exception e) {
            logger.error("修改用户密码错误" + StringUtil.getStackTrace(e));
            return new ResultMessage(ERROR, "修改用户密码错误");
        }
    }

    @RequestMapping("/toUserList")
    public String toUserList() {
        return "/userPages/userList";
    }

    @RequestMapping("/toUserForm")
    public String toUserForm() {
        return "/userPages/userForm";
    }

    @RequestMapping("/findUserList")
    @ResponseBody
    public ResultPageMessage<UserDomain> findUserList(UserVO userVO){
        PageHelper.startPage(userVO.getPage(), userVO.getLimit());
        List<UserDomain> userList = userService.findUserList(userVO);
        PageInfo pageInfo = new PageInfo<UserDomain>(userList);
        return new ResultPageMessage(pageInfo.getTotal(), pageInfo.getList());

    }

    @RequestMapping("/findUserById")
    @ResponseBody
    public ResultMessage findUserById(String userId) {
        try{
            UserDomain userDomain = userService.findUserById(userId);
            return new ResultMessage(SUCCESS, userDomain);
        } catch (Exception e) {
            logger.error("获取用户信息错误" + StringUtil.getStackTrace(e));
            return new ResultMessage(ERROR, "获取用户列表错误");
        }
    }

    @RequestMapping("/findUserByName")
    @ResponseBody
    public ResultMessage findUserByName(String userName) {
        try {
            List<UserDomain> dbUsers = userService.findUserByName(userName);
            if (dbUsers != null && dbUsers.size()> 0) {
                return new ResultMessage(SUCCESS, dbUsers.get(0));
            }
            return new ResultMessage();
        } catch (Exception e) {
            logger.error("获取用户信息错误" + StringUtil.getStackTrace(e));
            return new ResultMessage(ERROR, "获取用户信息错误");
        }
    }

    @RequestMapping("/delUserById")
    @ResponseBody
    public ResultMessage delUserById(String userId) {
        try {
            userService.deleteUserDomain(userId);
            return new ResultMessage();
        } catch (Exception e) {
            logger.error("删除用户信息错误" + StringUtil.getStackTrace(e));
            return new ResultMessage(ERROR, "删除用户信息错误");
        }
    }

    @RequestMapping("/delUserList")
    @ResponseBody
    public ResultMessage delUserList(String[] userIds) {
        try {
            for (String userId : userIds
                 ) {
                userService.deleteUserDomain(userId);
            }
            return new ResultMessage();
        } catch (Exception e) {
            logger.error("删除用户信息错误" + StringUtil.getStackTrace(e));
            return new ResultMessage(ERROR, "删除用户信息错误");
        }
    }

    @RequestMapping("/toAdminUserList")
    public String toAdminUserList() {
        return "/userPages/adminUserList";
    }

    @RequestMapping("/findAdminUserList")
    @ResponseBody
    public ResultPageMessage<UserDomain> findAdminUserList(UserVO userVO){
        PageHelper.startPage(userVO.getPage(), userVO.getLimit());
        List<UserDomain> userList = userService.findAdminUserList(userVO);
        PageInfo pageInfo = new PageInfo<>(userList);
        return new ResultPageMessage(pageInfo.getTotal(), pageInfo.getList());

    }

    @RequestMapping("/toAdminUserForm")
    public String toAdminUserForm(String userId, HttpServletRequest request) {
        if (userId != null && !userId.equals("")) {
            // 编辑管理员
            UserDomain dbUser = userService.findUserById(userId);
            // 清空密码
            dbUser.setPassword("");
            request.setAttribute("userDomain", dbUser);
        }

        return "/userPages/adminUserForm";
    }

    @RequestMapping("/addAdminUserPro")
    @ResponseBody
    public ResultMessage addAdminUserPro(UserDomain userDomain) {
        try {
            //默认密码
            userDomain.setPassword("11111111");
            //管理员类型
            userDomain.setType(0);
            userDomain.setCreateUser(this.getLoginUser().getUserName());
            userDomain.setCreateDate(new Date());
            userService.addAdminUser(userDomain);
            return new ResultMessage(SUCCESS, "添加管理员成功");
        } catch (Exception e) {
            logger.error("添加管理员错误" + StringUtil.getStackTrace(e));
            return new ResultMessage(ERROR, "添加管理员错误");
        }
    }

    @RequestMapping("/editAdminUserPro")
    @ResponseBody
    public ResultMessage editAdminUserPro(UserDomain userDomain) {
        try {
            UserDomain oldUser = userService.findUserById(userDomain.getId());
            oldUser.setUserName(userDomain.getUserName());
            oldUser.setNick(userDomain.getNick());
            oldUser.setMobile(userDomain.getMobile());
            oldUser.setUpdateDate(new Date());
            oldUser.setUpdateUser(this.getLoginUser().getUserName());
            userService.updateUser(oldUser);
            return new ResultMessage(SUCCESS, "修改管理员成功");
        } catch (Exception e) {
            logger.error("修改管理员错误" + StringUtil.getStackTrace(e));
            return new ResultMessage(ERROR, "修改管理员错误");
        }
    }
}
