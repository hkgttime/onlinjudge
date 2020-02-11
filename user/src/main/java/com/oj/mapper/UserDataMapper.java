package com.oj.mapper;

import com.oj.entity.UserBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataMapper {

    @Insert("insert ")
    @Result()
    public int insertUser(UserBean userBean);
}
