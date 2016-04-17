package com.itu.shareonwheels.service;

import com.itu.shareonwheels.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by nikitasonthalia on 10/10/15.
 */


@Service
public class LoginServiceImpl  implements LoginService{

    @Autowired
    private UserDao userDao;

    public String validateUser(String userName, String password)
    {
        return userDao.verifyLogin(userName,password);
    }

}
