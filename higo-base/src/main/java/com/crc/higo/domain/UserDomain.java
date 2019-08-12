package com.crc.higo.domain;

import com.crc.higo.base.BaseDomain;

/**
 * @Author: chenrencun
 * @Date: 2019/8/12 9:26
 * @Description: 用户类
 */
public class UserDomain extends BaseDomain {

    private String userName;

    private String password;

    private String nick;

    /**头像*/
    private String headImg;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }
}
