package com.example.websocket.domain.service;

import com.example.websocket.domain.dto.RedisRequestDto;
import com.example.websocket.global.redis.RedisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    // Set 저장
    public void saveSet(String key, String value) {
        redisRepository.saveSet(key, value);
    }

    // Set 단일 조회
    public String getSetValue(String key) {
        return (String) redisRepository.getSetValue(key);
    }

    // set 전체 조회
    public Set<Object> getSetValues(String key) {
        return redisRepository.getSetValues(key);
    }

    // Sorted Set 저장
    public void saveZSet(String key, String value, double score) {
        for (int i = 1; i < 4; i++) {
            redisRepository.saveZSet(key, value + i , score * i);
        }
    }

    // Sorted set 인덱스 범위 조회
    public Set<Object> getZSetIndexValues(String key) {
        return redisRepository.getZSetIndexValues(key);
    }

    // Sorted Set 스코어 조회
    public Set<Object> getZSetScoreValues(String key, int min, int max) {
        return redisRepository.getZSetScoreValues(key, min, max);
    }

    // Sorted Set 스코어 조회
    public Set<Object> getZSetScoreKeyValues(String key, int min, int max) {
        return redisRepository.getZSetScoreKeyValues(key, min, max);
    }

    // Hash 저장
    public void saveHash(String key, String hashKey, String value) {
        redisRepository.saveHash(key, hashKey, value);
    }

    // Hash 다중 저장
    public void saveAllHash(String key, String hashKey, String value) {
        Map<String, String> map = new HashMap<>();
        map.put(hashKey + "first", value + "first");
        map.put(hashKey + "second", value + "second");
        map.put(hashKey + "third", value + "third");
        redisRepository.saveHash(key, map);
    }

    // Hash 단일 조회
    public String getHash(String key, String hashKey) {
        return (String) redisRepository.getHash(key, hashKey);
    }

    // Hash key 전체 조회
    public Set<Object> getHashKeys(String key) {
        return redisRepository.getHashKeys(key);
    }

    // Hash value 전체 조회
    public List<Object> getHashValues(String key) {
        return redisRepository.getHashValues(key);
    }

    // Hash 전체 조회
    public Map<Object, Object> getHashMaps(String key) {
        return redisRepository.getHashMaps(key);
    }
}
