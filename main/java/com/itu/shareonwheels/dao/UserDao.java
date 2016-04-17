package com.itu.shareonwheels.dao;

import com.itu.shareonwheels.entity.User;

/**
 * Created by ramya on 9/28/15.
 */
public interface UserDao {

    Long create(User user);

    void update(User user);

    void delete(Long userId);

    String verifyLogin(String userName, String password);

    void statusUpdate(Long userId, String token);

    User getByUserName(String userName);


    User forgotpassword(String emailId);
}
