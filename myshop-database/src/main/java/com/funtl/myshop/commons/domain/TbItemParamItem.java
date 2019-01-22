package com.funtl.myshop.commons.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_item_param_item")
public class TbItemParamItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 商品ID
     */
    @Column(name = "item_id")
    private Long itemId;

    private Date created;

    private Date updated;

    /**
     * 参数数据，格式为json格式
     */
    @Column(name = "param_data")
    private String paramData;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

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
     * @return created
     */
    public Date getCreated() {
        return created;
    }

    /**
     * @param created
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * @return updated
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * @param updated
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    /**
     * 获取参数数据，格式为json格式
     *
     * @return param_data - 参数数据，格式为json格式
     */
    public String getParamData() {
        return paramData;
    }

    /**
     * 设置参数数据，格式为json格式
     *
     * @param paramData 参数数据，格式为json格式
     */
    public void setParamData(String paramData) {
        this.paramData = paramData;
    }
}