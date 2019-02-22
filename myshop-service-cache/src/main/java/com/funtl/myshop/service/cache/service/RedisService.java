package com.funtl.myshop.service.cache.service;

import org.springframework.stereotype.Service;

public interface RedisService {

    /**
     * 设置缓存
     * @param key
     * @param val
     */
    default void put(String key, Object val) {

    }

    /**
     *
     * @param key
     * @param val
     * @param seconds 超时时间
     */
    default void put(String key, Object val, int seconds) {

    }

    /**
     * 获取缓存
     * @param key
     * @return
     */
    default Object get(String key) {
        return null;
    }

    /**
     * 删除缓存
     * @param key
     */
    default void remove(String key) {

    }
}
