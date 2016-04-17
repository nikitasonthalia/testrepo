package com.itu.shareonwheels.controller;

import com.itu.shareonwheels.dto.UserSignUpDto;
import com.itu.shareonwheels.entity.User;
import com.itu.shareonwheels.service.UserServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by nikitasonthalia on 9/28/15.
 */
//Rest Controller EndPoint
@Controller
public class UserController {

    private static Log logger = LogFactory.getLog(UserController.class);

    @Autowired
    private UserServiceImpl userService;


    @RequestMapping(value = "/v1/user", method = RequestMethod.POST)//headers = "Access-Control-Allow-Origin=http://localhost:63342" )
    public @ResponseBody Long signUp(@RequestBody UserSignUpDto userSignUpDto,
                                     HttpServletRequest request,
                       HttpServletResponse response) {

        User user = new User();
        user.setFirstName(userSignUpDto.getFirstName());
        System.out.println(userSignUpDto.getFirstName());
        user.setLastName(userSignUpDto.getLastName());
        user.setUserName(userSignUpDto.getEmailAddress());
        user.setEmailAddress(userSignUpDto.getEmailAddress());

        user.setAddressLine1(userSignUpDto.getAddressLine1());
        user.setAddressLine2(userSignUpDto.getAddressLine2());
        user.setCity(userSignUpDto.getCity());
        user.setState(userSignUpDto.getState());
        user.setZipCode(userSignUpDto.getZipCode());
       // System.out.println("The zip code recieved is"+userSignUpDto.getZipCode());
        user.setPhoneNumber(userSignUpDto.getPhoneNumber());
        user.setPassword(userSignUpDto.getPassword());
        user.setGender(userSignUpDto.getGender());
        user.setDateOfBirth(userSignUpDto.getDateOfBirth());
        user.setStatus(UUID.randomUUID().toString());
        return  userService.create(user);

    }


    @RequestMapping(value = "/v1/user/{userId}", method = RequestMethod.PUT)
    public void upateUser(@PathVariable("userId") Long userId,
                                             @RequestBody User user,
                                             HttpServletRequest request,
                                             HttpServletResponse response) {

        user.setUserId(userId);
        userService.update(user);
    }

    @RequestMapping(value = "/v1/user/{userId}", method = RequestMethod.DELETE)
    public void deleteUSer(@PathVariable("userId") Long userId,
                                  HttpServletRequest request,
                                  HttpServletResponse response) {
        userService.removeById(userId);
    }

    @RequestMapping(value = "/v1/user/{userId}", method = RequestMethod.GET)
    public void getUser(@PathVariable("userId") Long userId,
                                  HttpServletRequest request,
                                  HttpServletResponse response) {
        userService.get(userId);
    }


    @RequestMapping(value = "/v1/users", method = RequestMethod.GET)
    public List<User> getAllUsers(HttpServletRequest request,
                            HttpServletResponse response) {
        logger.info("Getting all users");
        return userService.getAll();
    }

    @RequestMapping(value = "/v1/user/verify/{userId}", method = {RequestMethod.GET,RequestMethod.PUT})
    public void upateStatus(@PathVariable("userId") Long userId, @RequestParam("token") String token,
                            HttpServletRequest request,
                            HttpServletResponse response) throws IOException {

        userService.statusUpdate(userId , token);
        response.sendRedirect("http://localhost:63342/shareonwheels/web/Index.html");
    }
    @RequestMapping(value = "/v1/user/forgotpassword", method = RequestMethod.POST)
    public void forgotpassword(@RequestBody UserSignUpDto userSignUpDto,
                            HttpServletRequest request,
                            HttpServletResponse response) throws IOException, MessagingException {
        User user = new User();
        user.setEmailAddress(userSignUpDto.getEmailAddress());
        userService.forgotpassword(user);

    }

}