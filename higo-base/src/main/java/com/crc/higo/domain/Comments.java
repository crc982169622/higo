package com.crc.higo.domain;

import com.crc.higo.base.BaseDomain;

/**
 * @author: chenrencun
 * @version：
 * @date: 2019/8/13 22:03
 * 评论表
 **/
public class Comments extends BaseDomain {

    /**订单id*/
    private String orderId;

    /**商品id*/
    private String itemId;

    /**评论内容*/
    private String content;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
