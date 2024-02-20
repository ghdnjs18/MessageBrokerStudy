package com.example.websocket.domain.service;

import com.example.websocket.global.redis.RedisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RedisService {

    private final RedisRepository redisRepository;

    // String 저장
    public void save(String key, String value) {
        for (int i = 0; i < 5; i++) {
            redisRepository.save("key:"+ key + ":" + i, value + i);
        }
    }

    // String 조회
    public String getValue(String key) {
        return redisRepository.getValue("key:string:" + key);
    }

    // List 저장
    public void saveList(String key, String value) {
        redisRepository.saveList(key, value);
    }

    // List 단일 조회
    public String getListValue(String key, long index) {
        return redisRepository.getListValue(key, index);
    }

    // List 전체 조회
    public List<Object> getListValues(String key) {
        return redisRepository.getListValues(key);
    }
}
