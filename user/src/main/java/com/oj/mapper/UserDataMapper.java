package com.oj.mapper;

import com.oj.entity.UserBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataMapper {

    @Insert("INSERT INTO USERS (uuid, name, password, email, creatDate, status) VALUES (#{uuid}, #{name}, #{password}, #{email}, #{creatDate}, #{status})")
    public int insertUser(UserBean userBean);

    @Select("SELECT * FROM USERS WHERE email = #{email}, password = #{password}")
    public UserBean selectUser(String email, String password);
}
