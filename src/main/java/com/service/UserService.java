package com.service;

import com.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {

    /**
     * 获取用户
     * @param username 用户名
     * @param password 密码
     * @return 用户
     */
    public User getUser(@Param("username") String username ,@Param("password") String password);
}
