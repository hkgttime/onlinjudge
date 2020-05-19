package org.oj.exception;

import io.jsonwebtoken.JwtException;
import org.oj.entity.Restful;
import org.oj.entity.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.mail.MessagingException;

@ControllerAdvice
public class GlobalExceptionHandle {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private Restful restful = null;

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Restful runtimeExceptionHandler(RuntimeException ex) {
        logger.error("runtime err: " + ex.toString());
        restful.setResultCode(ResultCode.runtime_exception.getCode());
        return restful;
    }

    @ExceptionHandler(MessagingException.class)
    public Restful sendMail(MessagingException ex) {
        logger.error("mail send err: " + ex.toString());
        restful.setResultCode(ResultCode.messaging_exception.getCode());
        return restful;
    }

    @ResponseBody
    @ExceptionHandler(JwtException.class)
    public Restful jwtParse(JwtException ex) {
        logger.error("jwt parse: " + ex.toString());
        return restful;
    }
}
