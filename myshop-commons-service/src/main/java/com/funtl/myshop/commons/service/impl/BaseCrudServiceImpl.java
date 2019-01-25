package com.funtl.myshop.commons.service.impl;

import com.funtl.myshop.commons.dto.AbstractBaseDomain;
import com.funtl.myshop.commons.service.BaseCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.MyMapper;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.ParameterizedType;
import java.util.Date;

public class BaseCrudServiceImpl<T extends AbstractBaseDomain, M extends MyMapper<T>> implements BaseCrudService<T> {

    @Autowired
    protected M mapper;

    private Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    @Override
    public boolean unique(String property, String value) {
        Example example = new Example(entityClass);
        example.createCriteria().andEqualTo(property, value);
        int result = mapper.selectCountByExample(example);
        if (result > 0) {
            return false;
        }
        return true;
    }

    @Override
    public T save(T domain) {
        int result = 0;
        Date currentDate = new Date();
        domain.setUpdated(currentDate);

        // 创建
        if (domain.getId() == null) {
            domain.setCreated(currentDate);

            /**
             * 用于自动回显 ID，领域模型中需要 @ID 注解的支持
             * {@link AbstractBaseDomain}
             */
            result = mapper.insertUseGeneratedKeys(domain);
        }

        // 更新
        else {
            result = mapper.updateByPrimaryKey(domain);
        }

        // 保存数据成功
        if (result > 0) {
            return domain;
        }

        // 保存数据失败
        return null;
    }
}
