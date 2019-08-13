package com.crc.higo.domain;

import com.crc.higo.base.BaseDomain;

/**
 * @author: chenrencun
 * @version：
 * @date: 2019/8/13 22:06
 * 商品类别
 **/
public class ItemCategory extends BaseDomain {

    /**类别名称*/
    private String categoryName;

    /**类别级别*/
    private Integer categoryLevel;

    /**父级类别*/
    private String parentId;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategoryLevel() {
        return categoryLevel;
    }

    public void setCategoryLevel(Integer categoryLevel) {
        this.categoryLevel = categoryLevel;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
