package com.itu.shareonwheels.controller;


import com.itu.shareonwheels.dto.TripRegistrationDto;
import com.itu.shareonwheels.entity.Trip;
import com.itu.shareonwheels.enumerations.DayOfWeek;
import com.itu.shareonwheels.service.TripService;
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
 * Created by nikitasonthalia on 10/9/15.
 */
@Controller
public class TripController {

    @Autowired
    private TripService tripService;

    @RequestMapping(value = "/v1/trip", method = RequestMethod.POST)
    public @ResponseBody Long TripRegistration(@RequestBody TripRegistrationDto tripRegistrationDto,
                          HttpServletRequest request,
                          HttpServletResponse response) {

        Trip trip = new Trip();
        DayOfWeek[] dayofWeek = tripRegistrationDto.getDayOfWeek();

        trip.setStartLocation(tripRegistrationDto.getStartLocation());
        trip.setDestination(tripRegistrationDto.getDestination());
        trip.setTripTime(tripRegistrationDto.getTripTime());
        trip.setSeatAvailable(tripRegistrationDto.getSeatAvailable());
        System.out.println(trip.getSeatAvailable());
        trip.setUserId(tripRegistrationDto.getUserId());
        trip.setUserType(tripRegistrationDto.getUserType());
        trip.setTripDate(tripRegistrationDto.getTripDate());
        trip.setDayOfWeek(dayofWeek);
        trip.setFrequency(tripRegistrationDto.getFrequency());
        trip.setTripType(tripRegistrationDto.getTripType());


        return tripService.create(trip);


    }



    @RequestMapping(value = "/v1/tripper", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody
    List<Trip> tripSearch(@RequestBody TripRegistrationDto tripRegistrationDto,
                                         HttpServletRequest request,
                                         HttpServletResponse response)
    {
        Trip trip = new Trip();
        trip.setStartLocation(tripRegistrationDto.getStartLocation());
        trip.setDestination(tripRegistrationDto.getDestination());
        trip.setTripTime(tripRegistrationDto.getTripTime());
        trip.setSeatAvailable(tripRegistrationDto.getSeatAvailable());
        trip.setUserId(tripRegistrationDto.getUserId());
        trip.setUserType(tripRegistrationDto.getUserType());
        trip.setTripDate(tripRegistrationDto.getTripDate());
        trip.setDayOfWeek(tripRegistrationDto.getDayOfWeek());
        //trip.setFrequency(tripRegistrationDto.getFrequency());
        trip.setTripType(tripRegistrationDto.getTripType());

        return tripService.tripSearch(trip);

    }


}
