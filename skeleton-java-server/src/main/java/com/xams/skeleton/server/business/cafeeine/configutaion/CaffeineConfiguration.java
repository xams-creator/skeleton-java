//package com.xams.skeleton.server.business.cafeeine.configutaion;
//
//import com.github.benmanes.caffeine.cache.Caffeine;
//import com.github.benmanes.caffeine.cache.LoadingCache;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//
//import java.time.Duration;
//
//@Configuration
//public class CaffeineConfiguration {
//
//    @Bean
//    public LoadingCache<Object, Object> cache() {
//        return Caffeine.newBuilder()
//            .maximumSize(10_000)
//            .expireAfterWrite(Duration.ofMinutes(5))
//            .refreshAfterWrite(Duration.ofMinutes(1))
//            .build(key -> key);
//    }
//
//
//}
