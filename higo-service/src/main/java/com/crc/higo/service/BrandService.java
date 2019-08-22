package com.crc.higo.service;

import com.crc.higo.domain.Brand;
import com.crc.higo.domain.ItemCategory;
import com.crc.higo.vo.ItemCategoryVO;

import java.util.List;

/**
 * @author: chenrencun
 * @version：
 * @date: 2019/8/19 23:18
 **/
public interface BrandService {

    /**
     * 添加品牌
     */
    void addBrand(Brand brand);

    /**
     * 根据id删除品牌
     * @param brandId
     */
    void deleteBrandById(String brandId);

    /**
     * 修改品牌
     * @param brand
     */
    void editBrandById(Brand brand);

    /**
     * 根据id查找品牌
     * @param brandId
     * @return
     */
    Brand findBrandById(String brandId);

    /**
     * 查找所有品牌
     * @return
     */
    List<Brand> findBrandList();

}
