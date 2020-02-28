package org.oj.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@ConfigurationProperties( prefix = "jwt.conf")
@Component
public class JwtUtils {

    private  String key;
    private  long ttl;


    public String getKey() {
        return key;
    }

    public long getTtl() {
        return ttl;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setTtl(long ttl) {
        this.ttl = ttl;
    }

    /**
     * 签发JWT
     * @param id
     * @param subject 可以是JSON数据 尽可能少
     * @return  String
     *
     */
    public String createJWT(String id, String subject, Map<String, Object> map) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        JwtBuilder builder = Jwts.builder()
                .setId(id)
                .setSubject(subject)   // 主题
                .setIssuer("admin")     // 签发者
                .setIssuedAt(now)      // 签发时间
                .addClaims(map)
                .signWith(signatureAlgorithm, key); // 签名算法以及密匙
        if (ttl >= 0) {
            long expMillis = nowMillis + ttl;
            Date expDate = new Date(expMillis);
            builder.setExpiration(expDate); // 过期时间
        }
        return builder.compact();
    }


    /**
     *
     * 解析JWT字符串
     * @param jwt
     * @return
     * @throws Exception
     */
    public Claims parseJWT(String jwt) throws Exception {
        return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(jwt)
                .getBody();
    }
}
