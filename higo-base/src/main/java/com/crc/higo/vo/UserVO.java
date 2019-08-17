package com.crc.higo.vo;

import com.crc.higo.base.BaseVO;

/**
 * @author: chenrencun
 * @version：
 * @date: 2019/8/17 22:03
 **/
public class UserVO extends BaseVO {

    private String id;

    private String userName;

    private String password;

    private String nick;

    /**头像*/
    private String headImg;

    /**类型（0：管理员  1：普通用户）*/
    private Integer type;

    private Long mobile;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }
}
