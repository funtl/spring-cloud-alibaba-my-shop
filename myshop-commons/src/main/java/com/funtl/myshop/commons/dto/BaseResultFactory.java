package com.funtl.myshop.commons.dto;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 通用响应结构工厂
 * <p>Title: BaseResultFactory</p>
 * <p>Description: </p>
 *
 * @author Lusifer
 * @version 1.0.0
 * @date 2019/1/23 15:16
 */
@SuppressWarnings("all")
public class BaseResultFactory<T extends AbstractBaseDomain> {

    /**
     * 设置日志级别，用于限制发生错误时，是否显示调试信息(detail)
     *
     * @see ErrorResult#detail
     */
    public static final String LOGGER_LEVEL_DEBUG = "DEBUG";

    private static BaseResultFactory baseResultFactory;

    private BaseResultFactory() {

    }

    // 设置通用的响应
    private static HttpServletResponse response;

    public static BaseResultFactory getInstance(HttpServletResponse response) {
        if (baseResultFactory == null) {
            synchronized (BaseResultFactory.class) {
                if (baseResultFactory == null) {
                    baseResultFactory = new BaseResultFactory();
                }
            }
        }

        BaseResultFactory.response = response;
        // 设置通用响应
        baseResultFactory.initResponse();
        return baseResultFactory;
    }

    /**
     * 构建单笔数据结果集
     *
     * @param self 当前请求路径
     * @return
     */
    public AbstractBaseResult build(String self, T attributes) {
        return new SuccessResult(self, attributes);
    }

    /**
     * 构建多笔数据结果集
     *
     * @param self 当前请求路径
     * @param next 下一页的页码
     * @param last 最后一页的页码
     * @return
     */
    public AbstractBaseResult build(String self, int next, int last, List<T> attributes) {
        return new SuccessResult(self, next, last, attributes);
    }

    /**
     * 构建请求错误的响应结构
     *
     * @param code   HTTP 状态码
     * @param title  错误信息
     * @param detail 调试信息
     * @param level  日志级别，只有 DEBUG 时才显示详情
     * @return
     */
    public AbstractBaseResult build(int code, String title, String detail, String level) {
        // 设置请求失败的响应码
        response.setStatus(code);

        if (LOGGER_LEVEL_DEBUG.equals(level)) {
            return new ErrorResult(code, title, detail);
        } else {
            return new ErrorResult(code, title, null);
        }
    }

    /**
     * 初始化 HttpServletResponse
     */
    private void initResponse() {
        // 需要符合 JSON API 规范
        response.setHeader("Content-Type", "application/vnd.api+json");
    }
}
