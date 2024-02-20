package com.example.websocket.global.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Set;

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

    // List 인덱스 단일 조회
    public String getListValue(String key, long index) {
        RedisOperations<String, Object> listOperations = redisTemplate.opsForList().getOperations();
//        return (String) listOperations.opsForList().rightPop(key); // 하나의 값을 출력하고 삭제한다.
        return (String) listOperations.opsForList().index(key, index);
    }

    // List 인덱스 범위 조회
    public List<Object> getListValues(String key) {
        RedisOperations<String, Object> listOperations = redisTemplate.opsForList().getOperations();
        return listOperations.opsForList().range(key, 0, -1);
    }

    // Set 저장
    public void saveSet(String key, String value) {
        SetOperations<String, Object> setOperations = redisTemplate.opsForSet();
        setOperations.add(key, value);
    }

    // Set 단일 조회
    public Object getSetValue(String key) {
        SetOperations<String, Object> setOperations = redisTemplate.opsForSet();
//        return setOperations.pop(key); // 하나의 값을 출력하고 삭제한다.
        return setOperations.randomMember(key); // 랜덤으로 하나의 값을 출력한다.
    }

    // set 전체 조회
    public Set<Object> getSetValues(String key) {
        SetOperations<String, Object> setOperations = redisTemplate.opsForSet();
//        return setOperations.intersect(key); // 집합처럼 다른 키와 합, 교, 차 집합을 구할 수 있음
        return setOperations.members(key);
    }

    // Sorted Set 저장
    public void saveZSet(String key, String value, double score) {
        ZSetOperations<String, Object> zSetOperations = redisTemplate.opsForZSet();
        zSetOperations.add(key, value, score);
    }

    // Sorted set 인덱스 범위 조회
    public Set<Object> getZSetIndexValues(String key) {
        ZSetOperations<String, Object> zSetOperations = redisTemplate.opsForZSet();
        return zSetOperations.range(key, 0, -1);
    }

    // Sorted Set 스코어 조회
    public Set<Object> getZSetScoreValues(String key, int min, int max) {
        ZSetOperations<String, Object> zSetOperations = redisTemplate.opsForZSet();
        return zSetOperations.rangeByScore(key, min, max);
    }

    // Sorted Set 스코어 키-벨류 조회
    public Set<Object> getZSetScoreKeyValues(String key, int min, int max) {
        ZSetOperations<String, Object> zSetOperations = redisTemplate.opsForZSet();
        return Collections.singleton(zSetOperations.rangeByScoreWithScores(key, min, max));
    }
}
