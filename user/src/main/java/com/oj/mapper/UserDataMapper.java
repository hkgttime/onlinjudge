package com.oj.mapper;

import com.oj.entity.UserBean;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataMapper {

    @Insert("INSERT INTO USERS (uname, password, email, creatDate) VALUES (#{name}, #{password}, #{email}, #{creatDate})")
    public int insertUser(UserBean userBean);
}
