package com.banulp.rediscache.conf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.CacheKeyPrefix;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;
import java.util.HashMap;

@Configuration
@EnableCaching
@Slf4j
public class RedisCacheConfig {

//    @Autowired
//    private RedisClusterConfigurationProperties clusterProperties;


//    @Bean
//    public JedisConnectionFactory redisConnectionFactory() {
//        log.info("Redis (/Lettuce) configuration enabled.");
//
//        RedisStandaloneConfiguration redisConf = new RedisStandaloneConfiguration();
////        redisConf.setHostName("localhost");
//        redisConf.setHostName("172.19.170.60");
//        redisConf.setPort(6379);
//
////        RedisClusterConfiguration redisConf = new RedisClusterConfiguration(clusterProperties.getNodes());
//
//        // pool 설정하는거 있나본데 찾아서 넣고 확인하기
//        //JedisConnectionFactory jcf = new JedisConnectionFactory(redisConf);
//        //JedisClientConfiguration jcc = new JedisClientConfiguration();
//
//        return new JedisConnectionFactory(redisConf);
//
//    }

    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {

        RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig()
                .disableCachingNullValues()
                .computePrefixWith(CacheKeyPrefix.simple())
                .entryTtl(Duration.ofSeconds(60))
                .serializeValuesWith(
                        RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));

        return RedisCacheManager.RedisCacheManagerBuilder.fromConnectionFactory(connectionFactory)
                .cacheDefaults(configuration)
                .withInitialCacheConfigurations(new HashMap<String, RedisCacheConfiguration>()).build();
    }
}
