package com.crc.higo.base;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: chenrencun
 * @version：
 * @date: 2019/8/17 21:57
 **/
public class BaseVO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * 页数
     */
    private Integer page = 1;
    /**
     * 每页行数
     */
    private Integer limit = 30;
    /**
     * 排序字段
     */
    private String sidx;
    /**
     * 排序类型
     */
    private String sord;

    /**
     * 页面跳转类型
     */
    private String mode;

    private String createUser;

    private Date createDate;

    private String updateUser;

    private Date updateDate;

    private Integer delFlag;

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

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public String getSord() {
        return sord;
    }

    public void setSord(String sord) {
        this.sord = sord;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
