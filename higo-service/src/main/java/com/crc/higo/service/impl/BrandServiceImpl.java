package com.crc.higo.service.impl;

import com.crc.higo.domain.Brand;
import com.crc.higo.domain.ItemCategory;
import com.crc.higo.mapper.ItemCategoryMapper;
import com.crc.higo.service.BrandService;
import com.crc.higo.service.ItemCategoryService;
import com.crc.higo.vo.ItemCategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: chenrencun
 * @version：
 * @date: 2019/8/19 23:19
 **/
@Service
public class BrandServiceImpl implements BrandService {


    @Override
    public void addBrand(Brand brand) {

    }

    @Override
    public void deleteBrandById(String brandId) {

    }

    @Override
    public void editBrandById(Brand brand) {

    }

    @Override
    public Brand findBrandById(String brandId) {
        return null;
    }

    @Override
    public List<Brand> findBrandList() {
        return null;
    }
}
