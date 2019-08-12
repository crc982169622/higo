package com.crc.higo.base;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: chenrencun
 * @Date: 2019/8/12 9:21
 * @Description: 基本类
 */
public class BaseDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String createUser;

    private Date createDate;

    private String updateUser;

    private Date udateDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUdateDate() {
        return udateDate;
    }

    public void setUdateDate(Date udateDate) {
        this.udateDate = udateDate;
    }
}
