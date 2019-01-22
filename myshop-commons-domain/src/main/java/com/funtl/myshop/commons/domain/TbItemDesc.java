package com.funtl.myshop.commons.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "tb_item_desc")
public class TbItemDesc {
    /**
     * 商品ID
     */
    @Id
    @Column(name = "item_id")
    private Long itemId;

    /**
     * 创建时间
     */
    private Date created;

    /**
     * 更新时间
     */
    private Date updated;

    /**
     * 商品描述
     */
    @Column(name = "item_desc")
    private String itemDesc;

    /**
     * 获取商品ID
     *
     * @return item_id - 商品ID
     */
    public Long getItemId() {
        return itemId;
    }

    /**
     * 设置商品ID
     *
     * @param itemId 商品ID
     */
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    /**
     * 获取创建时间
     *
     * @return created - 创建时间
     */
    public Date getCreated() {
        return created;
    }

    /**
     * 设置创建时间
     *
     * @param created 创建时间
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * 获取更新时间
     *
     * @return updated - 更新时间
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * 设置更新时间
     *
     * @param updated 更新时间
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    /**
     * 获取商品描述
     *
     * @return item_desc - 商品描述
     */
    public String getItemDesc() {
        return itemDesc;
    }

    /**
     * 设置商品描述
     *
     * @param itemDesc 商品描述
     */
    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }
}