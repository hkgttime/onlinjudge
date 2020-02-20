package org.oj.api;

import org.oj.entity.Restful;
import org.oj.entity.UserBean;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

public interface UserControllerApi {

    default Restful activateAccount(HttpServletRequest request) {
        return null;
    }

    default Restful delUser(HttpServletRequest request) {
        return null;
    }

    default Restful login(String name, String password) {
        return null;
    }

    default Restful logout(String token) {
        return null;
    }

    default Restful update(String newpassword) {
        return null;
    }

    default Restful createAccount(UserBean user) throws MessagingException {
        return null;
    }

    default Restful getProfile(String name, String authorization) {
        return null;
    }

    default Restful rankList(int page){
        return null;
    }

}
