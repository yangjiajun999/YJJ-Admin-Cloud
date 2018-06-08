package com.framework.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(value = "/")
public class HelloController {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping(value = "/hello")
    public String hello() {
        redisTemplate.opsForValue().set("yangjiajun", "30", 1, TimeUnit.MINUTES);
        return redisTemplate.opsForValue().get("yangjiajun");
    }
}
