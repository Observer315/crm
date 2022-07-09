package com.mapper;
import com.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    /**
     * ��ȡ�û�
     * @param username �û���
     * @param password ����
     * @return �û�
     */
    public User getOneUser(@Param("username") String username,@Param("password") String password);
}
