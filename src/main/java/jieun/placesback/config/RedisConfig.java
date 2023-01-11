package jieun.placesback.config;

import com.redis.om.spring.annotations.EnableRedisEnhancedRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@Configuration
//@EnableRedisEnhancedRepositories(basePackages = "com.redis.om.*")
public class RedisConfig {
    @Value("${redis.host}")
    private String host;
    @Value("${redis.port:6379}")
    private int port;

    @Bean
    LettuceConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration(host, port);
        return new LettuceConnectionFactory(configuration);
    }
}