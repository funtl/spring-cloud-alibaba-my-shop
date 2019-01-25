package com.funtl.myshop.commons.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 通用的领域模型
 * <p>Title: AbstractBaseDomain</p>
 * <p>Description: </p>
 *
 * @author Lusifer
 * @version 1.0.0
 * @date 2019/1/23 15:50
 */
@Data
public abstract class AbstractBaseDomain implements Serializable {
    /**
     * 该注解需要保留，用于 tk.mybatis 回显 ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 格式化日期，由于是北京时间（我们是在东八区），所以时区 +8
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date created;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updated;
}
