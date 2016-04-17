package com.itu.shareonwheels.controller;

import com.itu.shareonwheels.dto.OnetineTripRegistrationDto;
import com.itu.shareonwheels.entity.OnetimeTrip;
import com.itu.shareonwheels.service.OnetimeTripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by nikitasonthalia on 10/9/15.
 */
public class OnetineTripController {

    @Autowired
    private OnetimeTripService onetimeTripService;

    @RequestMapping(value = "/v1/trip", method = RequestMethod.POST)
    public @ResponseBody long TripRegistration(@RequestBody OnetineTripRegistrationDto oneTimeTripRegistrationDto,
                          HttpServletRequest request,
                          HttpServletResponse response)
    {

        OnetimeTrip onetimeTrip = new OnetimeTrip();

        onetimeTrip.setStartlocation(oneTimeTripRegistrationDto.getStartlocation());
        onetimeTrip.setDestination(oneTimeTripRegistrationDto.getDestination());
        onetimeTrip.setTriptime(oneTimeTripRegistrationDto.getTriptime());
        onetimeTrip.setSeatavailable(oneTimeTripRegistrationDto.getSeatavailable());
        onetimeTrip.setUserid(oneTimeTripRegistrationDto.getUserid());
        onetimeTrip.setUsertype(oneTimeTripRegistrationDto.getUsertype());
        onetimeTrip.setTripdate(oneTimeTripRegistrationDto.getTripdate());


        return  onetimeTripService.create(onetimeTrip);


    }



}
