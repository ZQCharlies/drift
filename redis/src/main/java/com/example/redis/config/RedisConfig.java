package com.example.redis.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author wzq
 * @Date 2021/8/2
 **/
@Configuration
public class RedisConfig {

//    @Value("${spring.redis.urls}")
//    private String urls;
//
//    @Bean
//    public RedissonClient redissonClient(){
//        RedissonClient redissonClient = null;
//        Config config = new Config();
//        config.useSingleServer().setAddress("redis://"+urls);
//        redissonClient = Redisson.create(config);
//        return redissonClient;
//    }


}
