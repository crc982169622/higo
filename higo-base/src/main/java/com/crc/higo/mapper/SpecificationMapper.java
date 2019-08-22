package com.crc.higo.mapper;

import com.crc.higo.domain.Brand;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: chenrencun
 * @version：
 * @date: 2019/8/19 23:14
 **/
@Repository
public interface SpecificationMapper {

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
