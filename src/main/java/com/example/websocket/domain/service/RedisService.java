package com.example.websocket.domain.service;

import com.example.websocket.global.redis.RedisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
