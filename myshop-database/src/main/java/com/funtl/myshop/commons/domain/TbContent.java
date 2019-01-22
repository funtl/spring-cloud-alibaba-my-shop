package com.funtl.myshop.commons.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_content")
public class TbContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 内容类目ID
     */
    @Column(name = "category_id")
    private Long categoryId;

    /**
     * 内容标题
     */
    private String title;

    /**
     * 子标题
     */
    @Column(name = "sub_title")
    private String subTitle;

    /**
     * 标题描述
     */
    @Column(name = "title_desc")
    private String titleDesc;

    /**
     * 链接
     */
    private String url;

    /**
     * 图片绝对路径
     */
    private String pic;

    /**
     * 图片2
     */
    private String pic2;

    private Date created;

    private Date updated;

    /**
     * 内容
     */
    private String content;

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
     * 获取内容类目ID
     *
     * @return category_id - 内容类目ID
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * 设置内容类目ID
     *
     * @param categoryId 内容类目ID
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取内容标题
     *
     * @return title - 内容标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置内容标题
     *
     * @param title 内容标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取子标题
     *
     * @return sub_title - 子标题
     */
    public String getSubTitle() {
        return subTitle;
    }

    /**
     * 设置子标题
     *
     * @param subTitle 子标题
     */
    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    /**
     * 获取标题描述
     *
     * @return title_desc - 标题描述
     */
    public String getTitleDesc() {
        return titleDesc;
    }

    /**
     * 设置标题描述
     *
     * @param titleDesc 标题描述
     */
    public void setTitleDesc(String titleDesc) {
        this.titleDesc = titleDesc;
    }

    /**
     * 获取链接
     *
     * @return url - 链接
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置链接
     *
     * @param url 链接
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取图片绝对路径
     *
     * @return pic - 图片绝对路径
     */
    public String getPic() {
        return pic;
    }

    /**
     * 设置图片绝对路径
     *
     * @param pic 图片绝对路径
     */
    public void setPic(String pic) {
        this.pic = pic;
    }

    /**
     * 获取图片2
     *
     * @return pic2 - 图片2
     */
    public String getPic2() {
        return pic2;
    }

    /**
     * 设置图片2
     *
     * @param pic2 图片2
     */
    public void setPic2(String pic2) {
        this.pic2 = pic2;
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
     * 获取内容
     *
     * @return content - 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容
     *
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content;
    }
}