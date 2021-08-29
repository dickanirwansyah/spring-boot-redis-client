package com.core.be.appbe.common.util;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CacheUtility {

    @Autowired
    private RedisClient redisClient;

    public void set(String prefix, String key, String value, Integer expired){
        StatefulRedisConnection<String, String> connection = redisClient.connect();
        RedisCommands<String, String> redisCommand = connection.sync();
        String data = prefix + ":" + key;
        String existingData = redisCommand.get(data);
        if (StringUtils.isNotEmpty(existingData)){
            redisCommand.del(data);
        }
        redisCommand.set(data, value);
        if (ObjectUtils.isNotEmpty(expired)){
            redisCommand.expire(data, expired);
        }
        connection.close();
    }

    public String get(String prefix, String key){
        StatefulRedisConnection<String, String> connection = redisClient.connect();
        RedisCommands<String, String> redisCommands = connection.sync();
        String data = prefix + ":" + key;
        String result = redisCommands.get(data);
        if (StringUtils.isEmpty(result)){
            return null;
        }
        connection.close();
        return result;
    }

    public void delete(String prefix, String key){
        StatefulRedisConnection<String, String> connection = redisClient.connect();
        RedisCommands<String, String> redisCommands = connection.sync();
        String data = prefix + ":" + key;
        redisCommands.del(data);
        connection.close();
    }
}
