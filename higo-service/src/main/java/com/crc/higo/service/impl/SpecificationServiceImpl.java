package com.crc.higo.service.impl;

import com.crc.higo.domain.Brand;
import com.crc.higo.domain.Specification;
import com.crc.higo.mapper.SpecificationMapper;
import com.crc.higo.service.BrandService;
import com.crc.higo.service.SpecificationService;
import com.crc.higo.vo.SpecificationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: chenrencun
 * @version：
 * @date: 2019/8/19 23:19
 **/
@Service
public class SpecificationServiceImpl implements SpecificationService {

    @Autowired
    private SpecificationMapper specificationMapper;


    @Override
    public List<SpecificationVO> findSpecificationVOList() {
        return specificationMapper.findSpecificationVOList();
    }
}
