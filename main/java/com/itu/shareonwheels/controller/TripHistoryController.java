package com.itu.shareonwheels.controller;

import com.itu.shareonwheels.dto.UserSignUpDto;
import com.itu.shareonwheels.entity.Trip;
import com.itu.shareonwheels.entity.TripDetail;
import com.itu.shareonwheels.entity.User;
import com.itu.shareonwheels.service.TripHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by nikitasonthalia on 12/8/15.
 */
@Controller
public class TripHistoryController {
    @Autowired
    TripHistoryService tripHistoryService;


    @RequestMapping(value = "/v1/triphistory/driver", method = {RequestMethod.GET,RequestMethod.POST})
    public  @ResponseBody
    List<TripDetail> tripHistroyDriver(@RequestBody UserSignUpDto userSignUpDto,
                                      HttpServletRequest request,
                                      HttpServletResponse response)
    {
         User user = new User();
        user.setUserId(userSignUpDto.getUserId());
        return tripHistoryService.getTripHistoryAsDriver(user);

    }

    @RequestMapping(value = "/v1/triphistory/rider", method = {RequestMethod.GET,RequestMethod.POST})
    public  @ResponseBody
    List<TripDetail> tripHistroyRider(@RequestBody UserSignUpDto userSignUpDto,
                                       HttpServletRequest request,
                                       HttpServletResponse response)
    {
        User user = new User();
        user.setUserId(userSignUpDto.getUserId());
        return tripHistoryService.getTripHistoryAsRider(user);

    }

    @RequestMapping(value = "/v1/alltriphistory", method = {RequestMethod.GET,RequestMethod.POST})
    public  @ResponseBody
    List<Trip> tripHistroy(@RequestBody UserSignUpDto userSignUpDto,
                                      HttpServletRequest request,
                                      HttpServletResponse response)
    {
        User user = new User();
        user.setUserId(userSignUpDto.getUserId());
        return tripHistoryService.getTripHistory(user);

    }
}
