package org.oj.api;

import org.oj.entity.UserBean;
import io.jsonwebtoken.Claims;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.Map;

public interface UserServiceApi {

    default int createUserServe(Claims claims) {
        return 0;
    }

    default int delUserServe(Claims claims) {
        return 0;
    }

    default Map<String, Object> loginServe(String email, String password) {
        return null;
    }

    default int logoutServe() {
        return 0;
    }

    default UserBean updateServe(String newpassword) {
        return null;
    }

    default int sendActivateEmail(UserBean user) throws MessagingException {
        return 0;
    }

    default ArrayList<UserBean> getList(int page) {
        return null;
    }

    default ArrayList<UserBean> getTwentyPages(int page){
        return null;
    }

    default UserBean getUser(String uuid){
        return null;
    }

}
