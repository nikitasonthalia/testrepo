package com.itu.shareonwheels.service;

import com.itu.shareonwheels.entity.User;

import javax.mail.MessagingException;

/**
 * Created by ramya on 11/4/15.
 */
public interface UserService extends GenericService<User, Long> {

    User get(String userName);

    void forgotpassword(User user) throws MessagingException;
}
