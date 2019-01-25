package com.funtl.myshop.commons.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 请求失败
 * <p>Title: ErrorResult</p>
 * <p>Description: </p>
 *
 * @author Lusifer
 * @version 1.0.0
 * @date 2019/1/23 15:07
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
// JSON 不显示为 null 的属性
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResult extends AbstractBaseResult {
    private int code;
    private String title;

    /**
     * 调试信息
     */
    private String detail;
}
