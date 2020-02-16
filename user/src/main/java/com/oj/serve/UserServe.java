package com.oj.serve;

import com.oj.api.UserServeApi;
import com.oj.entity.UserBean;
import com.oj.mapper.UserDataMapper;
import com.oj.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServe implements UserServeApi {

    @Autowired
    private UserDataMapper userDataMapper;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private JavaMailSenderImpl mailSender;
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private JwtUtils jwt;


    @Override
    public int createUserServe(Claims claims) {
        UserBean user = new UserBean();
        user.setUuid(UUID.randomUUID().toString().replaceAll("-",""));
        user.setCreatDate(new Date());
        user.setName((String) claims.get("name"));
        user.setEmail((String) claims.get("email"));
        user.setPassword((String) claims.get("password"));
        user.setStatus(1);
        userDataMapper.insertUser(user);
        return 1;
    }

    @Override
    public int delUserServe() {

        return 0;
    }

    @Override
    public Map<String, Object> loginServe(String email, String password) {
        UserBean user = userDataMapper.selectUser(email, password);
        if (user == null){
            return null;
        }
        jwt.setttlMillis(7*24*60*6*1000);
        Map<String, Object> map = new HashMap<>();
        map.put("uuid", user.getUuid());
        String token = jwt.createJWT("0001", "login", map);
        Map<String, Object> res = new HashMap<>();
        res.put("user", user);
        res.put("token", token);
        return res;
    }

    @Override
    public int logoutServe() {

        return 0;
    }

    @Override
    public UserBean updateServe(String newpassword) {
        return null;
    }

    @Override
    public int sendActivateEmail(UserBean user){

        Map<String, Object> map = new HashMap<>();
        map.put("name", user.getName());
        map.put("email", user.getEmail());
        map.put("password", user.getPassword());
        jwt.setttlMillis(300000);
        String token = jwt.createJWT("0000","activation",map);
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(message,true);
            messageHelper.setSubject("[OnlineJudge] Please activation your account");
            messageHelper.setText("<a>localhost:8080<a>", true);
            messageHelper.setTo(user.getEmail());
            messageHelper.setFrom("1320643835@qq.com");
        } catch (MessagingException e) {
            logger.error(e.toString());
            return 0;
        }
        mailSender.send(message);
        return 1;
    }

}

