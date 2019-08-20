package com.crc.higo.mapper;

import com.crc.higo.domain.ItemCategory;
import com.crc.higo.vo.ItemCategoryVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: chenrencun
 * @version：
 * @date: 2019/8/19 23:14
 **/
@Repository
public interface ItemCategoryMapper {
    /**
     * 添加商品分类
     * @param itemCategory
     */
    void addItemCategory(ItemCategory itemCategory);

    /**
     * 根据id删除商品分类
     * @param categoryId
     */
    void deleteItemCategory(String categoryId);

    /**
     * 修改商品分类
     * @param itemCategory
     */
    void updateItemCategory(ItemCategory itemCategory);

    /**
     * 根据id查找商品分类
     * @param categoryId
     * @return
     */
    ItemCategory findItemCategoryById(String categoryId);

    /**
     * 根据条件查找所有商品分类
     * @param itemCategoryVO
     * @return
     */
    List<ItemCategoryVO> findItemCategoryVOList(ItemCategoryVO itemCategoryVO);

    /**
     * 查找所有一级商品类别
     * @return
     */
    List<ItemCategory> findParentCategoryList();

    /**
     * 获取对应级别的商品类别
     * @param categoryLevel
     * @return
     */
    List<ItemCategory> findCategoryListByLevel(Integer categoryLevel);

    /**
     * 根据级别和名称获取商品类别
     * @param categoryName
     * @return
     */
    ItemCategory findItemCategoryByNameAndLevel(@Param("categoryName")String categoryName, @Param("categoryLevel")Integer categoryLevel);




}
