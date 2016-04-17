package com.itu.shareonwheels.controller;

import com.itu.shareonwheels.dto.LoginRequestDto;
import com.itu.shareonwheels.entity.User;
import com.itu.shareonwheels.service.LoginService;
import com.itu.shareonwheels.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by nikitasonthalia on 10/10/15.
 */
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private UserService userService;



    private String loggedInResult;

    @RequestMapping(value = "/v1/login", method ={RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody
    User signIn(@RequestBody(required=false) LoginRequestDto loginRequestDto,
                HttpServletRequest request,
                HttpServletResponse response) throws IOException {

        User user = new User();
        String userName = loginRequestDto.getEmailAddress();

        String password = loginRequestDto.getPassword();

        loggedInResult = loginService.validateUser(userName, password);

        if (loggedInResult == "USER_CONFIRMED")
        {
            response.setStatus(200);

            Cookie cookie = new Cookie("UserName",userName);
            cookie.setMaxAge(60 * 60);

            response.addCookie(cookie);
            // response.addCookie(Cookie);

            return userService.get(userName);

        }
        else if(loggedInResult == "NOT_CONFIRMED")
        {
            response.sendError(401, "Status not confirmed");
        }else
        {
            response.sendError(403,"Username and paasword not matching");
        }
        return user;
    }



}

