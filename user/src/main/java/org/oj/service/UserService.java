package org.oj.service;

import io.jsonwebtoken.Claims;
import org.oj.api.UserServiceApi;
import org.oj.entity.UserBase;
import org.oj.mapper.UserDataMapper;
import org.oj.utils.JwtUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.*;

@Service
public class UserService implements UserServiceApi {

    @Autowired
    private UserDataMapper userDataMapper;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private JavaMailSenderImpl mailSender;
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private JwtUtils jwt;
    @Value("${spring.mail.username}")
    private String fromAddr;




    @Override
    public int createUserServe(Claims claims) {
        UserBase user = new UserBase();
        user.setUuid(UUID.randomUUID().toString().replaceAll("-",""));
        user.setCreatDate(new Date());
        user.setName((String) claims.get("name"));
        user.setEmails((String) claims.get("email"));
        user.setPassword((String) claims.get("password"));
        user.setStatus(1);
        String uuid = userDataMapper.insertUser(user);
        if (uuid == null) {
            return 0;
        }
        return 1;
    }

    @Override
    public int delUserServe(Claims claims) {
        String uuid = (String) claims.get("uuid");
        int ret = userDataMapper.delUser(uuid);
        return ret;
    }

    @Override
    public Map<String, Object> loginServe(String email, String password) {
        UserBase user = userDataMapper.findUser(email, password);
        if (user == null){
            return null;
        }
        jwt.setTtl(10*24*60*60*1000);
        Map<String, Object> map = new HashMap<>();
        map.put("uuid", user.getUuid());
        String token = jwt.createJWT("0001", "login", map);
        Map<String, Object> data = new HashMap<>();
        data.put("avatar", user.getAvatar());
        data.put("token", token);
        return data;
    }


    @Override
    public UserBase updateServe(String newpassword) {
        return null;
    }

    @Override
    public int sendVCtoEmail(String email) throws MessagingException {

        int i = userDataMapper.findEmail(email);
        if (i > 0){
            return 0;
        }

        String code = getCode(5);


        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message,true);
        messageHelper.setSubject("[OnlineJudge] Please activation your account");
        messageHelper.setText("<a>localhost:8080<a>", true);
        messageHelper.setTo(email);
        messageHelper.setFrom(fromAddr);
        mailSender.send(message);
        return 1;
    }

    public UserBase getUser(String uuid){
        UserBase user = userDataMapper.findUserById(uuid);
        return user;
    }

    private String getCode(int len){
        char []cs = {'A','B','C','D','E','F','G','1','2','3','4','5','6','7','8','9','0'};
        //下标
        int count = 0;
        //随机数
        Random random = new Random();
        //动态的字符数组:用数组存储 然后遍历
        StringBuilder sb = new StringBuilder();

        while (true) {
            char c = cs[random.nextInt(cs.length)];
            if (sb.indexOf(c+"")==-1) {
                sb.append(c);
                count++;

                if (count == len) {
                    break;
                }
            }
        }
        return sb.toString();
    }

}

