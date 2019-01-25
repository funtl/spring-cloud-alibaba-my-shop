package com.funtl.myshop.commons.web;

import com.funtl.myshop.commons.dto.AbstractBaseDomain;
import com.funtl.myshop.commons.dto.AbstractBaseResult;
import com.funtl.myshop.commons.dto.BaseResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 通用的控制器
 * <p>Title: AbstractBaseController</p>
 * <p>Description: </p>
 *
 * @author Lusifer
 * @version 1.0.0
 * @date 2019/1/25 11:11
 */
public abstract class AbstractBaseController<T extends AbstractBaseDomain> {

    // 用于动态获取配置文件的属性值
    private static final String ENVIRONMENT_LOGGING_LEVEL_MY_SHOP = "logging.level.com.funtl.myshop";

    protected HttpServletRequest request;
    protected HttpServletResponse response;

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @ModelAttribute
    public void initReqAndRes(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    /**
     * 请求成功
     * @param self
     * @param attribute
     * @return
     */
    protected AbstractBaseResult success(String self, T attribute) {
        return BaseResultFactory.getInstance(response).build(self, attribute);
    }

    /**
     * 请求成功
     * @param self
     * @param next
     * @param last
     * @param attributes
     * @return
     */
    protected AbstractBaseResult success(String self, int next, int last, List<T> attributes) {
        return BaseResultFactory.getInstance(response).build(self, next, last, attributes);
    }

    /**
     * 请求失败
     * @param title
     * @param detail
     * @return
     */
    protected AbstractBaseResult error(String title, String detail) {
        return error(HttpStatus.UNAUTHORIZED.value(), title, detail);
    }

    /**
     * 请求失败
     * @param code
     * @param title
     * @param detail
     * @return
     */
    protected AbstractBaseResult error(int code, String title, String detail) {
        return BaseResultFactory.getInstance(response).build(code, title, detail, applicationContext.getEnvironment().getProperty(ENVIRONMENT_LOGGING_LEVEL_MY_SHOP));
    }
}
