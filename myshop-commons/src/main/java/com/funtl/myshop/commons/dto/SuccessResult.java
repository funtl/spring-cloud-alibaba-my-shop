package com.funtl.myshop.commons.dto;

import com.google.common.collect.Lists;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * 请求成功
 * <p>Title: SuccessResult</p>
 * <p>Description: </p>
 *
 * @author Lusifer
 * @version 1.0.0
 * @date 2019/1/23 15:07
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SuccessResult<T extends AbstractBaseDomain> extends AbstractBaseResult {
    private Links links;
    private List<DataBean> data;

    /**
     * 请求的结果（单笔）
     * @param self 当前请求路径
     * @param attributes 领域模型
     */
    public SuccessResult(String self, T attributes) {
        links = new Links();
        links.setSelf(self);

        createDataBean(null, attributes);
    }

    /**
     * 请求的结果（分页）
     * @param self 当前请求路径
     * @param next 下一页的页码
     * @param last 最后一页的页码
     * @param attributes 领域模型集合
     */
    public SuccessResult(String self, int next, int last, List<T> attributes) {
        links = new Links();
        links.setSelf(self);
        links.setNext(self + "?page=" + next);
        links.setLast(self + "?page=" + last);

        attributes.forEach(attribute -> createDataBean(self, attribute));
    }

    /**
     * 创建 DataBean
     * @param self 当前请求路径
     * @param attributes 领域模型
     */
    private void createDataBean(String self, T attributes) {
        if (data == null) {
            data = Lists.newArrayList();
        }

        DataBean dataBean = new DataBean();
        dataBean.setId(attributes.getId());
        dataBean.setType(attributes.getClass().getSimpleName());
        dataBean.setAttributes(attributes);

        if (StringUtils.isNotBlank(self)) {
            Links links = new Links();
            links.setSelf(self + "/" + attributes.getId());
            dataBean.setLinks(links);
        }

        data.add(dataBean);
    }
}
