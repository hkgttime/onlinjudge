package org.oj.api;

import io.jsonwebtoken.Claims;
import org.oj.entity.UserBase;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.Map;

public interface UserServiceApi {

    default int createUserServe(Map<String, String> map) {
        return 0;
    }

    default int delUserServe(Claims claims) {
        return 0;
    }

    default Map<String, Object> loginServe(String email, String password) {
        return null;
    }


    default UserBase updateServe(String newpassword) {
        return null;
    }

    default int sendVCtoEmail(String email) throws MessagingException {
        return 0;
    }

    default ArrayList<UserBase> getList(int page) {
        return null;
    }

    default ArrayList<UserBase> getTwentyPages(int page){
        return null;
    }

    default UserBase getUser(String uuid){
        return null;
    }

}
