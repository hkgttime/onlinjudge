package org.oj.mapper;

import org.oj.entity.UserBean;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDataMapper {

    @Insert("INSERT INTO USERS (uuid, name, password, email, creatDate, status) VALUES (#{uuid}, #{name}, #{password}, #{email}, #{creatDate}, #{status})")
    @Options(useGeneratedKeys = true, keyProperty = "uuid")
    public String insertUser(UserBean userBean);

    @Select("SELECT * FROM USERS WHERE email = #{email}, password = #{password}")
    public UserBean findUser(String email, String password);

    @Delete("DELETE FROM USERS WHERE uuid = #{uuid}")
    public int delUser(String uuid);

    @Select("SELECT COUNT(email) FROM USERS WHERE email = #{email}")
    public int findEmail(String email);

    @Select("SELECT * FROM USERS LIMIT 0,200 ORDER BY score ASC")
    public List<UserBean> twentyPages();

    @Select("SELECT * FROM USERS LIMIT #{start},40 ORDER BY score DESC")
    public List<UserBean> findByPage(int start);

    @Select("SELECT * FROM USERS WHERE uuid = #{uuid}")
    public UserBean findUserById(String uuid);
}
