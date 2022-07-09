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
     * 登录功能
     * @param loginAct 账户
     * @param loginPwd 密码
     * @param isRemPwd 是否记住密码
     * @return Result
     */
    @RequestMapping("settings/qx/user/login.do")
    @ResponseBody
    public Result login(String loginAct, String loginPwd, String isRemPwd, HttpServletRequest request, HttpServletResponse response){

        //判断是否有空值
        if(loginAct == null || loginPwd == null){
            return new Result<>(Message.LOGIN_FAIL,0,null);
        }

        //获取用户
        User user = userServiceIml.getUser(loginAct, loginPwd);

        if(user == null){
            return new Result<>(Message.LOGIN_FAIL,0,null);
        }

        HttpSession session = request.getSession();
        session.setAttribute("user",user);

        //记住密码 将user存入session中
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
