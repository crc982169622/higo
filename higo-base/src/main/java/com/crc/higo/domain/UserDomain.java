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

    /**类型（0：管理员  1：普通用户）*/
    private Integer type;

    private Long mobile;

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

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
