package org.oj.service;

import org.oj.api.UserServiceApi;
import org.oj.entity.UserBase;
import org.oj.mapper.UserDataMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RankService implements UserServiceApi {

    @Autowired
    private UserDataMapper userDataMapper;
    @Autowired
    RedisTemplate redisTemplate;
    private Logger logger = LoggerFactory.getLogger(getClass());


    @Cacheable(cacheNames = "ranklist", keyGenerator = "pageKeyGenerate", condition = "#page < 20")
    public ArrayList<UserBase> getList(int page){
        ArrayList<UserBase> list = new ArrayList<>();
        int start = page * 20;
        list = (ArrayList<UserBase>) userDataMapper.findByPage(start);
        return list;
    }

}
