package com.crc.higo.vo;

import com.crc.higo.base.BaseVO;

/**
 * @Author: chenrencun
 * @Date: 2019/8/20 9:25
 * @Description: 描述
 */
public class ItemCategoryVO extends BaseVO {

    private String id;

    /**类别名称*/
    private String categoryName;

    /**类别级别*/
    private Integer categoryLevel;

    /**父级类别*/
    private String parentId;

    /**父级类别名称*/
    private String parentName;

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
