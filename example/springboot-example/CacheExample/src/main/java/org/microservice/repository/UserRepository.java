package org.microservice.repository;

import lombok.extern.slf4j.Slf4j;
import org.microservice.entity.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * @author create 2022/8/17 by rao
 */
@Slf4j
@Repository
@CacheConfig(cacheNames = {"user"})
public class UserRepository {

    private final static Map<Long, User> USER_MAP = new HashMap<>();

    @Cacheable(key = "#id")
    public User getById(Long id){
        log.info("加载数据库 getById:{}",id);
        return USER_MAP.get(id);
    }

    @CacheEvict(key = "#user.id")
    public void add(User user){
        log.info("数据库新增 add:{}",user);
        USER_MAP.put(user.getId(), user);
    }

}
