package com.oj.serve;

import com.oj.api.UserServeApi;
import com.oj.entity.RestfulCode;
import com.oj.entity.UserBean;
import com.oj.mapper.UserDataMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Random;

@Service
public class UserServe implements UserServeApi {

    @Autowired
    private UserDataMapper userDataMapper;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private JavaMailSenderImpl mailSender;
    private Logger logger = LoggerFactory.getLogger(getClass());


    @Override
    public int createUserServe(String email, String verificationCode) {
        HashOperations<String,String,Object> opsForHash = redisTemplate.opsForHash();
        String time = (String) opsForHash.get(email, "email");
        logger.trace(time);
        long now = (new Date().getTime() / 1000);
        if (time != null){
            String code = (String) opsForHash.get(email,"code");
            if (code.equals(verificationCode)){
                String name = (String) opsForHash.get(email, "name");
                String password = (String) opsForHash.get(email, "password");
                UserBean user = new UserBean();
                user.setName(name);
                user.setPassword(password);
                user.setEmail(email);
                user.setCreatDate(new Date());
                int id = userDataMapper.insertUser(user);
                redisTemplate.delete(email);
                return id;
            }
        }
        return RestfulCode.OJ_NF;
    }

    @Override
    public int delUserServe(long uid, String name) {
        return 0;
    }

    @Override
    public UserBean loginServe(String name, String password) {
        return null;
    }

    @Override
    public int logoutServe(UserBean userBean) {
        return 0;
    }

    @Override
    public UserBean updateServe(UserBean userBean) {
        return null;
    }

    @Override
    public void sendActivationUserMail(UserBean user){
        HashOperations<String,String,Object> opsForHash = redisTemplate.opsForHash();
        MimeMessage message = mailSender.createMimeMessage();
        String email = user.getEmail();
        String verificationCode = getVerificationCode(5);
        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(message,true);
            messageHelper.setSubject("[OnlineJudge] Please activation your account");
            messageHelper.setText("<a>localhost:8080/user/creat?email="+email+"&vc="+verificationCode+"<a>", true);
            messageHelper.setTo(email);
            messageHelper.setFrom("1320643835@qq.com");
            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
            logger.error("mail send err", e);
        }
        long time = (new Date().getTime() / 1000) + 300000;
        String aftime = String.valueOf(time);
        opsForHash.put(email,"name", user.getName());
        opsForHash.put(email,"password", user.getPassword());
        opsForHash.put(email, "email", user.getEmail());
        opsForHash.put(email, "code", verificationCode);
        opsForHash.put(email, "time", aftime);
    }

    public String getVerificationCode(int len){
        String verificationCode = new String();
        String str="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        for(int i=0; i<len; i++)
        {
            char ch=str.charAt(new Random().nextInt(str.length()));
            verificationCode += ch;
        }
        return verificationCode;
    }
}

