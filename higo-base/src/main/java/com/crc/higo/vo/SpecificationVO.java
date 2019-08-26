package com.crc.higo.vo;

import com.crc.higo.base.BaseVO;

/**
 * @Author: chenrencun
 * @Date: 2019/8/26 14:17
 * @Description: 描述
 */
public class SpecificationVO extends BaseVO {

    private String id;

    private String categoryId;

    private String categoryName;

    private String parentCategoryName;

    private String specifications;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getParentCategoryName() {
        return parentCategoryName;
    }

    public void setParentCategoryName(String parentCategoryName) {
        this.parentCategoryName = parentCategoryName;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }
}
