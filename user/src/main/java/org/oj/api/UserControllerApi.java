package org.oj.api;

import org.oj.entity.Restful;
import org.oj.entity.UserBase;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

public interface UserControllerApi {

    default Restful register(String name, String email, String password, String verificationCode) {
        return null;
    }

    default Restful delUser(HttpServletRequest request) {
        return null;
    }

    default Restful login(String name, String password) {
        return null;
    }


    default Restful update(UserBase user) {
        return null;
    }

    default Restful sendVC(String email) throws MessagingException {
        return null;
    }

    default Restful getProfile(String name) {
        return null;
    }

    default Restful rankList(int page){
        return null;
    }

}
