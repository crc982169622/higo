package com.crc.higo.service;

import com.crc.higo.domain.Brand;
import com.crc.higo.domain.Specification;
import com.crc.higo.vo.SpecificationVO;

import java.util.List;

/**
 * @author: chenrencun
 * @version：
 * @date: 2019/8/19 23:18
 **/
public interface SpecificationService {

    /**
     * 查询所有规格参数
     * @return
     */
    List<SpecificationVO> findSpecificationVOList();

}
