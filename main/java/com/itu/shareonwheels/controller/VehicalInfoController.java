package com.itu.shareonwheels.controller;

import com.itu.shareonwheels.dto.UserSignUpDto;
import com.itu.shareonwheels.entity.Vehicle;
import com.itu.shareonwheels.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by nikitasonthalia on 12/19/15.
 */
@Controller
public class VehicalInfoController {
    @Autowired
    VehicleService vehicleService;

    @RequestMapping(value = "/v1/owner/vehicle", method ={RequestMethod.POST,RequestMethod.GET})
    public @ResponseBody
    Vehicle vehicleDetails(@RequestBody UserSignUpDto userSignUpDto,
                HttpServletRequest request,
                HttpServletResponse response) throws IOException {
       return vehicleService.getVehicleDetailsByUserId(userSignUpDto.getUserId());


    }
}
