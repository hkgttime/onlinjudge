package com.oj.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oj.api.UserServiceApi;
import com.oj.entity.UserBean;
import com.oj.mapper.UserDataMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
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


    public ArrayList<UserBean> getList(int page){
        ArrayList<UserBean> list = new ArrayList<>();
        if (page <= 20){
            list = getTwentyPages();
            return list;
        }
        int start = page * 20;
        list = (ArrayList<UserBean>) userDataMapper.findByPage(start);
        return list;
    }

    private ArrayList<UserBean> getTwentyPages(){
        ArrayList<UserBean> ls = (ArrayList<UserBean>) userDataMapper.twentyPages();
        for ( UserBean user : ls ) {
            ObjectMapper mapper = new ObjectMapper();
            ListOperations opsForList = redisTemplate.opsForList();
            try {
                String json = mapper.writeValueAsString(user);
                opsForList.leftPush("z2typages",json);
            } catch (JsonProcessingException e) {
                logger.error(e.toString());
            }
        }
        return ls;
    }

}
