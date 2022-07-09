package com.web.controller;

import com.commons.Message;
import com.commons.Result;
import com.model.User;
import com.service.Iml.UserServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired(required = false)
    private UserServiceIml userServiceIml;

    /**
     * ��¼����
     * @param loginAct �˻�
     * @param loginPwd ����
     * @param isRemPwd �Ƿ��ס����
     * @return Result
     */
    @RequestMapping("settings/qx/user/login.do")
    @ResponseBody
    public Result login(String loginAct, String loginPwd, String isRemPwd, HttpServletRequest request, HttpServletResponse response){

        //�ж��Ƿ��п�ֵ
        if(loginAct == null || loginPwd == null){
            return new Result<>(Message.LOGIN_FAIL,0,null);
        }

        //��ȡ�û�
        User user = userServiceIml.getUser(loginAct, loginPwd);

        if(user == null){
            return new Result<>(Message.LOGIN_FAIL,0,null);
        }

        HttpSession session = request.getSession();
        session.setAttribute("user",user);

        //��ס���� ��user����session��
        if(isRemPwd.equals("true")){
            Cookie cookie = new Cookie("username",user.getUsername());
            cookie.setMaxAge(10*60*60*24);
            Cookie cookie1 = new Cookie("password",user.getPassword());
            cookie1.setMaxAge(10*60*60*24);
            response.addCookie(cookie);
            response.addCookie(cookie1);
        }

        return new Result<>(Message.LOGIN_SUCCESS,1,user);
    }

    @RequestMapping("settings/qx/user/logout.do")
    public String logout(HttpServletRequest request){

        HttpSession session = request.getSession();
        session.removeAttribute("user");


        return "settings/qx/user/login";
    }

}
