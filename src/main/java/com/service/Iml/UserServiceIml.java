package com.service.Iml;

import com.mapper.UserMapper;
import com.model.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceIml implements UserService {

    @Autowired(required = false)
    private UserMapper userMapper;


    @Override
    public User getUser(String username, String password) {
        return userMapper.getOneUser(username,password);
    }
}
