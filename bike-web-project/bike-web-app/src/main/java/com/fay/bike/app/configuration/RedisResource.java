package com.fay.bike.app.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author toyer
 * @date 2018-04-24
 */
@Component
@Slf4j
public class RedisResource {
    /** 一周 */
    private static final int EX_SECONDS = 60 * 60 * 24 * 7;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    private ValueOperations<String, Object> opsForValue() {
        return redisTemplate.opsForValue();
    }
    
    public Object get(String key) {
        return opsForValue().get(key);
    }

    public void set(String key, Object value) {
        opsForValue().set(key, value);
    }

    public void set(String key, Object value, int seconds) {
        opsForValue().set(key, value, seconds);
    }

    public void del(String key) {
        opsForValue().getOperations().delete(key);
    }
}
