package com.crc.higo.service.impl;

import com.crc.higo.domain.ItemCategory;
import com.crc.higo.mapper.ItemCategoryMapper;
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
public class ItemCategoryServiceImpl implements ItemCategoryService {

    @Autowired
    private ItemCategoryMapper itemCategoryMapper;

    @Override
    public void addItemCategory(ItemCategory itemCategory) {
        itemCategoryMapper.addItemCategory(itemCategory);
    }

    @Override
    public void deleteItemCategory(String categoryId) {
        itemCategoryMapper.deleteItemCategory(categoryId);
    }

    @Override
    public void updateItemCategory(ItemCategory itemCategory) {
        itemCategoryMapper.updateItemCategory(itemCategory);
    }

    @Override
    public ItemCategory findItemCategoryById(String categoryId) {
        return itemCategoryMapper.findItemCategoryById(categoryId);
    }

    @Override
    public List<ItemCategoryVO> findItemCategoryVOList(ItemCategoryVO itemCategoryVO) {
        return itemCategoryMapper.findItemCategoryVOList(itemCategoryVO);
    }

    @Override
    public List<ItemCategory> findParentCategoryList() {
        return itemCategoryMapper.findParentCategoryList();
    }

    @Override
    public List<ItemCategory> findCategoryListByLevel(Integer categoryLevel) {
        return itemCategoryMapper.findCategoryListByLevel(categoryLevel);
    }

    @Override
    public ItemCategory findItemCategoryByNameAndLevel(String categoryName, Integer level) {
        return itemCategoryMapper.findItemCategoryByNameAndLevel(categoryName, level);
    }

}
