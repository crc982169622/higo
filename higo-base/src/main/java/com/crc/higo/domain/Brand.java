package com.crc.higo.domain;

import com.crc.higo.base.BaseDomain;

/**
 * @Author: chenrencun
 * @Date: 2019/8/22 13:36
 * @Description: 商品品牌
 */
public class Brand extends BaseDomain {

    /**品牌名称*/
    private String brandName;

    /**申请人*/
    private String applicant;

    /**申请人联系方式*/
    private Long mobile;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }
}
