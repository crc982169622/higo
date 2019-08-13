package com.crc.higo.domain;

import com.crc.higo.base.BaseDomain;

/**
 * @author: chenrencun
 * @version：
 * @date: 2019/8/13 21:55
 * 商品类
 **/
public class ItemDomain extends BaseDomain {

    private String itemName;

    private Long itemPrice;

    /**商品库存*/
    private Long itemInventory;

    /**商品类别（小类）*/
    private String itemCategory;

    private String itemImg;

    /**商品描述*/
    private String itemDescribe;

    /**已售出数量*/
    private Long saledCount;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Long getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Long itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Long getItemInventory() {
        return itemInventory;
    }

    public void setItemInventory(Long itemInventory) {
        this.itemInventory = itemInventory;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public String getItemImg() {
        return itemImg;
    }

    public void setItemImg(String itemImg) {
        this.itemImg = itemImg;
    }

    public String getItemDescribe() {
        return itemDescribe;
    }

    public void setItemDescribe(String itemDescribe) {
        this.itemDescribe = itemDescribe;
    }

    public Long getSaledCount() {
        return saledCount;
    }

    public void setSaledCount(Long saledCount) {
        this.saledCount = saledCount;
    }
}
