package com.service;

import com.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {

    /**
     * ��ȡ�û�
     * @param username �û���
     * @param password ����
     * @return �û�
     */
    public User getUser(@Param("username") String username ,@Param("password") String password);
}
