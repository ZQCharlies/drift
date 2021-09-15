package com.example.redis.util;

import org.junit.Test;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class RedisUtilTest {
    
    @Autowired
    private RedissonClient client;

    @Test
    public void testRedisson(){
        client.getMap("map");
    }

}