package com.xams.skeleton.server.business.cafeeine;

import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class CaffeineService {

    private static CaffeineCacheManager caffeineCacheManager;

    CaffeineService() {

        Caffeine<Object, Object> caffeine = Caffeine.newBuilder()
            .maximumSize(10_000)
            .expireAfterWrite(Duration.ofMinutes(5))
            .refreshAfterWrite(Duration.ofMinutes(1));

        caffeineCacheManager = new CaffeineCacheManager();
        caffeineCacheManager.setCacheLoader(new CacheLoader<Object, Object>() {

            @Override
            public Object load(Object o) throws Exception {
                if (o.toString().equalsIgnoreCase("hello")) {
                    Thread.sleep(3000);
                    return o.toString();
                } else if (o.toString().equalsIgnoreCase("world")) {
                    Thread.sleep(5000);
                    return o.toString();
                }
                return o.toString();
            }

            @Override
            public Object reload(Object key, Object oldValue) throws Exception {
                if (key.toString().equalsIgnoreCase("hello")) {
                    return "world";
                } else if (key.toString().equalsIgnoreCase("world")) {
                    return "hello";
                }
                return "no value";
            }
        });

        caffeineCacheManager.setCaffeine(caffeine);

    }

    public CaffeineCacheManager getCacheManager() {
        return caffeineCacheManager;
    }


}
