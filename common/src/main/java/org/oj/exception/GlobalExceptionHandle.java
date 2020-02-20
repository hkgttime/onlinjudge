package org.oj.exception;

import org.oj.entity.ReslutCode;
import org.oj.entity.Restful;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandle {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private Restful restful = null;

    @ExceptionHandler(RuntimeException.class)
    public Restful runtimeExceptionHandler(RuntimeException ex) {
        restful.setData("");
        restful.setReslutCode(ReslutCode.E_1000);
        return restful;
    }

    @ExceptionHandler(MessagingException.class)
    public Restful sendMail(MessagingException ex){
        logger.error("mail send err: " + ex.toString());
        restful.setReslutCode(ReslutCode.OK_0000);
        return restful;
    }
}
