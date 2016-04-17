package com.itu.shareonwheels.controller;
import com.itu.shareonwheels.dto.TripRequestDto;
import com.itu.shareonwheels.entity.Trip;
import com.itu.shareonwheels.service.TripRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by nikitasonthalia on 10/17/15.
 */
@Controller
public class TripRequestController {

    @Autowired
    private TripRequestService tripRequestService;

    @RequestMapping(value = "/v1/trip/request/{userId}", method ={RequestMethod.PUT, RequestMethod.POST})
    public @ResponseBody
    Long tripRequest(@RequestBody TripRequestDto tripRequestDto, @PathVariable("userId") Long requesterId,
                                                                        HttpServletRequest request,
                                                                         HttpServletResponse response){

        Trip trip = new Trip();


        trip.setUserId(tripRequestDto.getUserId());
        trip.setUserType(tripRequestDto.getUserType());
        trip.setTripId(tripRequestDto.getTripId());
        trip.setTripType(tripRequestDto.getTripType());


       return tripRequestService.tripRequest(trip,requesterId);



    }

}
