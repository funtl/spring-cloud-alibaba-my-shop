package com.funtl.myshop.service.reg.controller;

import com.funtl.myshop.commons.domain.TbUser;
import com.funtl.myshop.commons.dto.AbstractBaseResult;
import com.funtl.myshop.commons.service.TbUserService;
import com.funtl.myshop.commons.validator.BeanValidator;
import com.funtl.myshop.commons.web.AbstractBaseController;
import com.funtl.myshop.service.reg.service.RegService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "reg")
public class RegController extends AbstractBaseController<TbUser> {

    @Autowired
    private TbUserService tbUserService;

    @Autowired
    private RegService regService;

    @ApiOperation(value = "用户注册", notes = "参数为实体类，注意用户名和邮箱不要重复")
    @PostMapping(value = "")
    public AbstractBaseResult reg(@ApiParam(name = "tbUser", value = "用户模型") TbUser tbUser) {
        // 数据校验
        String message = BeanValidator.validator(tbUser);
        if (StringUtils.isNotBlank(message)) {
            return error(message, null);
        }

        // 验证密码是否为空
        if (StringUtils.isBlank(tbUser.getPassword())) {
            return error("密码不可为空", null);
        }

        // 验证用户名是否重复
        if (!tbUserService.unique("username", tbUser.getUsername())) {
            return error("用户名已存在", null);
        }

        // 验证邮箱是否重复
        if (!tbUserService.unique("email", tbUser.getEmail())) {
            return error("邮箱重复，请重试", null);
        }

        // 注册用户
        try {
            tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
            TbUser user = tbUserService.save(tbUser);
            if (user != null) {
                regService.sendEmail(user);
                response.setStatus(HttpStatus.CREATED.value());
                return success(request.getRequestURI(), user);
            }
        } catch (Exception e) {
            // 这里补一句，将 RegService 中的异常抛到 Controller 中，这样可以打印出调试信息
            return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "注册邮件发送失败", e.getMessage());
        }

        // 注册失败
        return error("注册失败，请重试", null);
    }
}
