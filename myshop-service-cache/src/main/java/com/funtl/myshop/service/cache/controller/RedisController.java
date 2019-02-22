package com.funtl.myshop.service.cache.controller;

import com.funtl.myshop.service.cache.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "cache")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @PostMapping("redis/{key}/{val}")
    public String put(@PathVariable String key, @PathVariable String val) {
        redisService.put(key, val);
        return "ok";
    }

    @GetMapping(value = "redis/{key}")
    public String get(@PathVariable String key) {
        return (String) redisService.get(key);
    }
}
