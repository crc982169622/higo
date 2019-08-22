package com.crc.higo.domain;

import com.crc.higo.base.BaseDomain;

/**
 * @Author: chenrencun
 * @Date: 2019/8/22 14:20
 * @Description: 规格参数
 */
public class Specification extends BaseDomain {

    private String categoryId;

    private String specifications;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }
}
