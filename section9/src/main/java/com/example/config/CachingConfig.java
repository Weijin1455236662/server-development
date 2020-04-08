package com.example.config;

import org.springframework.cache.CacheManager;
//import net.sf.ehcache.CacheManager;
//import net.sf.ehcache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

//import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
//import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
//import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableCaching
public class CachingConfig {

//    @Bean
//    public CacheManager cacheManager() {
//        return new ConcurrentMapCacheManager();
//    }

//    @Bean
//    public EhCacheCacheManager cacheManager(CacheManager cm) {
//        return new EhCacheCacheManager(cm);
//    }
//
//    @Bean
//    public EhCacheManagerFactoryBean ehcache() {
//        EhCacheManagerFactoryBean ehCacheFactoryBean =
//                new EhCacheManagerFactoryBean();
//        ehCacheFactoryBean.setConfigLocation(
//                new ClassPathResource("com/example/cache/hellocache.xml"));
//        return ehCacheFactoryBean;
//    }


    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        return new RedisCacheManager(redisTemplate);
    }

    @Bean
    public RedisConnectionFactory redisCF() {
        return new JedisConnectionFactory();
    }

    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory cf) {
        RedisTemplate<String, String> redis = new RedisTemplate<>();
        redis.setConnectionFactory(cf);
        return redis;
    }
}
