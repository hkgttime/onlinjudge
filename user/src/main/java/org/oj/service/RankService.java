package org.oj.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.oj.api.UserServiceApi;
import org.oj.entity.UserBean;
import org.oj.mapper.UserDataMapper;
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
        int start = page * 20;
        list = (ArrayList<UserBean>) userDataMapper.findByPage(start);
        return list;
    }

    public ArrayList<UserBean> getTwentyPages(int page){
        ArrayList<UserBean> ls = (ArrayList<UserBean>) userDataMapper.twentyPages();
        for ( UserBean user : ls ) {
            ObjectMapper mapper = new ObjectMapper();
            ListOperations opsForList = redisTemplate.opsForList();
            try {
                String json = mapper.writeValueAsString(user);
                opsForList.leftPush("z2tpages",json);
            } catch (JsonProcessingException e) {
                logger.error(e.toString());
            }
        }
        return ls;
    }

}
