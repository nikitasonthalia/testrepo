package com.itu.shareonwheels.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by nikitasonthalia on 10/13/15.
 */
@Controller
public class StatusController {

    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public @ResponseBody String status(HttpServletRequest request,
                HttpServletResponse response) {

       return "ShareOnWheels Server is Healthy!!";

    }
}
