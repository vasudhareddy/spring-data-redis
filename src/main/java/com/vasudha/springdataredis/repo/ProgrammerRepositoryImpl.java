package com.vasudha.springdataredis.repo;

import com.vasudha.springdataredis.model.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.concurrent.*;

@Repository
public class ProgrammerRepositoryImpl implements ProgrammerRepository {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    @Qualifier("listOperations")
    private ListOperations<String, Programmer> listOperations;

    @Autowired
    @Qualifier("setOperations")
    private SetOperations<String, Programmer> setOperations;

    @Autowired
    @Qualifier("hashOperations")
    private HashOperations<String,Integer, Programmer> hashOperations;

    String LIST_KEY = "ProgrammerList";
    String SET_KEY = "ProgrammerSet";
    String HASH_KEY = "ProgrammerHash";

    @Override
    public void setProgrammerAsString(String key, String programmer) {
      redisTemplate.opsForValue().set(key,programmer);
      redisTemplate.expire(key, 10, TimeUnit.SECONDS);
    }

    @Override
    public String getProgrammerAsString(String key) {
        return (String) redisTemplate.opsForValue().get(key);
    }

    @Override
    public void addProgrammerToList(Programmer programmer) {
        listOperations.leftPush(LIST_KEY, programmer);
    }

    @Override
    public List<Programmer> getProgrammerListMembers() {
        return listOperations.range(LIST_KEY,0,-1);
    }

    @Override
    public Long getProgrammerListCount() {
        return listOperations.size(LIST_KEY);
    }

    @Override
    public void addProgrammerToSet(Programmer... programmer) {
        setOperations.add(SET_KEY,programmer);
    }

    @Override
    public Set<Programmer> getProgrammerSetMembers() {
        return setOperations.members(SET_KEY);
    }

    @Override
    public boolean isSetMember(Programmer programmer) {
        return setOperations.isMember(SET_KEY, programmer);
    }

    @Override
    public void saveHash(Programmer programmer) {
        hashOperations.put(HASH_KEY,programmer.getId(),programmer);
    }

    @Override
    public void updateHash(Programmer programmer) {
        hashOperations.put(HASH_KEY,programmer.getId(),programmer);
    }

    @Override
    public Map<Integer, Programmer> findAllHash() {
        return hashOperations.entries(HASH_KEY);
    }

    @Override
    public Programmer findInHash(int id) {
        return hashOperations.get(HASH_KEY, id);
    }

    @Override
    public void deleteHash(int id) {
        hashOperations.delete(HASH_KEY,id);
    }
}
