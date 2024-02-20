package com.example.websocket.global.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RedisRepository {

    private final RedisTemplate<String, Object> redisTemplate;

    // String 저장
    public void save(String key, String value) {
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, value);
    }

    // String 조회
    public String getValue(String key) {
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        return (String) valueOperations.get(key);
    }

    // List 저장
    public void saveList(String key, String value) {
        ListOperations<String, Object> listOperations = redisTemplate.opsForList();
        listOperations.rightPush(key, value);
    }

    // List 단일 조회
    public String getListValue(String key, long index) {
        RedisOperations<String, Object> listOperations = redisTemplate.opsForList().getOperations();
        return (String) listOperations.opsForList().index(key, index);
    }

    // List 전체 조회
    public List<Object> getListValues(String key) {
        RedisOperations<String, Object> listOperations = redisTemplate.opsForList().getOperations();
        return listOperations.opsForList().range(key, 0, -1);
    }
}
