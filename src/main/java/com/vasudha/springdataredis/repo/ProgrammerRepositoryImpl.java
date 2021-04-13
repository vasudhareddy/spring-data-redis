package com.vasudha.springdataredis.repo;

import org.springframework.beans.factory.annotation.*;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.*;

import java.util.concurrent.*;

@Repository
public class ProgrammerRepositoryImpl implements ProgrammerRepository {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public void setProgrammerAsString(String key, String programmer) {
      redisTemplate.opsForValue().set(key,programmer);
      redisTemplate.expire(key, 10, TimeUnit.SECONDS);
    }

    @Override
    public String getProgrammerAsString(String key) {
        return (String) redisTemplate.opsForValue().get(key);
    }
}
