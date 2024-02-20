package com.example.websocket.domain.service;

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
        redisRepository.saveList("listKey:" + key, "listTest" + value);
    }

    // List 단일 조회
    public String getListValue(String key, long index) {
        return redisRepository.getListValue("listKey:" + key, index);
    }

    // List 전체 조회
    public List<Object> getListValues(String key) {
        return redisRepository.getListValues("listKey:" + key);
    }

    // Set 저장
    public void saveSet(String key, String value) {
        redisRepository.saveSet("setKey:" + key, "setTest" + value);
    }

    // Set 단일 조회
    public String getSetValue(String key) {
        return (String) redisRepository.getSetValue("setKey:" + key);
    }

    // set 전체 조회
    public Set<Object> getSetValues(String key) {
        return redisRepository.getSetValues("setKey:" + key);
    }

    // Sorted Set 저장
    public void saveZSet(String key, String value, double score) {
        for (int i = 1; i < 4; i++) {
            redisRepository.saveZSet("score:" + key, value + i , score * i);
        }
    }

    // Sorted set 인덱스 범위 조회
    public Set<Object> getZSetIndexValues(String key) {
        return redisRepository.getZSetIndexValues("score:" + key);
    }

    // Sorted Set 스코어 조회
    public Set<Object> getZSetScoreValues(String key, int min, int max) {
        return redisRepository.getZSetScoreValues("score:" + key, min, max);
    }

    // Sorted Set 스코어 조회
    public Set<Object> getZSetScoreKeyValues(String key, int min, int max) {
        return redisRepository.getZSetScoreKeyValues("score:" + key, min, max);
    }

    // Hash 저장
    public void saveHash(String key, String hashKey, String value) {
        redisRepository.saveHash("hashKey:" + key, "testKey:" + hashKey, "hashTest" + value);
    }

    // Hash 다중 저장
    public void saveAllHash(String key, String hashKey, String value) {
        Map<String, String> map = new HashMap<>();
        map.put("testKey:" + hashKey + "first", value + "first");
        map.put("testKey:" + hashKey + "second", value + "second");
        map.put("testKey:" + hashKey + "third", value + "third");
        redisRepository.saveHash("hashKey:" + key, map);
    }

    // Hash 단일 조회
    public String getHash(String key, String hashKey) {
        return (String) redisRepository.getHash("hashKey:" + key, "testKey:" + hashKey);
    }

    // Hash key 전체 조회
    public Set<Object> getHashKeys(String key) {
        return redisRepository.getHashKeys("hashKey:" + key);
    }

    // Hash value 전체 조회
    public List<Object> getHashValues(String key) {
        return redisRepository.getHashValues("hashKey:" + key);
    }

    // Hash 전체 조회
    public Map<Object, Object> getHashMaps(String key) {
        return redisRepository.getHashMaps("hashKey:" + key);
    }
}
