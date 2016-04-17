package com.itu.shareonwheels.controller;

import com.itu.shareonwheels.dto.RoutineTripDto;
import com.itu.shareonwheels.entity.RoutineTrip;
import com.itu.shareonwheels.service.RoutineTripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by nikitasonthalia on 10/10/15.
 */

public class RoutineTripController {

    @Autowired
   private RoutineTripService routineTripService;

    @RequestMapping(value = "/v1/RoutineTripRegistration", method = RequestMethod.POST)
    public @ResponseBody long RoutineTripRegistration(@RequestBody RoutineTripDto routineTripDto,
                                                      HttpServletResponse response,
                                                      HttpServletRequest request)
    {
        RoutineTrip routineTrip = new RoutineTrip();
        routineTrip.setStartlocation(routineTripDto.getStartlocation());
        routineTrip.setDestination(routineTripDto.getDestination());
        routineTrip.setTriptime(routineTripDto.getTriptime());
        routineTrip.setSeatavailable(routineTripDto.getSeatavailable());
        routineTrip.setUserid(routineTripDto.getUserid());
        routineTrip.setUsertype(routineTripDto.getUsertype());
        routineTrip.setDayOfWeek(routineTripDto.getDayOfWeek());
        routineTrip.setFrequency(routineTripDto.getFrequency());

        return routineTripService.create(routineTrip);
    }


}
