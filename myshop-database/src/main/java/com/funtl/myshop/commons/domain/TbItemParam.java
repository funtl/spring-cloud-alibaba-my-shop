package com.funtl.myshop.commons.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_item_param")
public class TbItemParam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 商品类目ID
     */
    @Column(name = "item_cat_id")
    private Long itemCatId;

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
     * 获取商品类目ID
     *
     * @return item_cat_id - 商品类目ID
     */
    public Long getItemCatId() {
        return itemCatId;
    }

    /**
     * 设置商品类目ID
     *
     * @param itemCatId 商品类目ID
     */
    public void setItemCatId(Long itemCatId) {
        this.itemCatId = itemCatId;
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