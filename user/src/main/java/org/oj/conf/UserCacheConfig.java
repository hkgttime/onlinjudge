package org.oj.conf;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

@Configuration
public class UserCacheConfig {

    @Bean("pageKeyGenerate")
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                String key = method.getName() + "["+ params +"]";
                return key;
            }
        };
    }
}
