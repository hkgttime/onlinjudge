package com.oj.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserLogAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("execution(public * com.oj.controll.UserBaseController.delUser(..))")
    public void userLog(){}

    @Before("userLog()")
    public void logs(JoinPoint joinPoint){
        logger.debug(joinPoint.getSignature().getName());
    }
}
