package com.mapper;
import com.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    /**
     * 获取用户
     * @param username 用户名
     * @param password 密码
     * @return 用户
     */
    public User getOneUser(@Param("username") String username,@Param("password") String password);
}
