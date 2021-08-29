package com.core.be.appbe.config;


import io.lettuce.core.RedisClient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ObjectUtils;

@Slf4j
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "redis")
public class RedisConfig {

    private String host;
    private String passsword;
    private Integer port;
    private Integer dbIndex;

    @Bean(name = "redisClient")
    public RedisClient getRedisClient(){
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("redis://");
        strBuilder.append(ObjectUtils.isEmpty(this.getPasssword()) ? "" : this.getPasssword());
        strBuilder.append("@");
        strBuilder.append(this.getHost());
        strBuilder.append(":");
        strBuilder.append(this.getPort());
        strBuilder.append("/");
        strBuilder.append(ObjectUtils.isEmpty(this.dbIndex) ? 0 : this.dbIndex);
        log.info("connect to redis : {}", strBuilder.toString());
        return RedisClient.create(strBuilder.toString());
    }
}
