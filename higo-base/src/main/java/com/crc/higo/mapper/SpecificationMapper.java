package com.crc.higo.mapper;

import com.crc.higo.domain.Brand;
import com.crc.higo.domain.Specification;
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
     * 添加规格参数
     */
    void addSpecification(Specification specification);

    /**
     * 删除规格参数
     * @param specificationId
     */
    void deleteSpecification(String specificationId);

    /**
     * 修改规格参数
     * @param specification
     */
    void editSpecification(Specification specification);

    /**
     * 根据id查找规格参数
     * @param specificationId
     * @return
     */
    Specification findSpecificationById(String specificationId);

    /**
     * 查询所有规格参数
     * @return
     */
    List<Specification> findSpecificationList();

}
