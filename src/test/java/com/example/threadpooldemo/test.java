package com.example.threadpooldemo;

import com.example.threadpooldemo.tools.RedisUtil;
import org.springframework.data.redis.core.RedisTemplate;

public class test {

    RedisUtil redisUtil = new RedisUtil(new RedisTemplate<>());

    public RedisUtil getRedisUtil() {
        return redisUtil;
    }
}
