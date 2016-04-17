package com.itu.shareonwheels.controller;

import com.itu.shareonwheels.dto.VehicleRequestDto;
import com.itu.shareonwheels.entity.Vehicle;
import com.itu.shareonwheels.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by nikitasonthalia on 10/8/15.
 */
@Controller
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @RequestMapping(value = "v1/driver/{userId}/vehicle",method = RequestMethod.POST)
    public @ResponseBody Long addVehicle(@RequestBody VehicleRequestDto vehicleRequestDto,
                              @PathVariable("userId") Long ownerId,
                              HttpServletRequest request,
                              HttpServletResponse response)
    {
        Vehicle vehicle = new Vehicle();
        vehicle.setModel(vehicleRequestDto.getModel());
        vehicle.setCapacity(vehicleRequestDto.getCapacity());
        //System.out.println("The owner id is"+ ownerId);
        vehicle.setLicencePlateNumber(vehicleRequestDto.getLicencePlateNumber());
      //  vehicle.setVehicleType(vehicleRequestDto.getVehicleType());
        vehicle.setOwnerId(ownerId);

        return vehicleService.create(vehicle);
    }

    @RequestMapping(value = "v1/driver/{driverId}/vehicle/{vehicleId}",method = RequestMethod.PUT)
    public @ResponseBody void updateVehicle(@RequestBody VehicleRequestDto vehicleRequestDto,
                              @PathVariable("driverId") Long ownerId,
                              @PathVariable("vehicleId") Long vehicleId,
                              HttpServletRequest request,
                              HttpServletResponse response)
    {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleId(vehicleId);
        vehicle.setModel(vehicleRequestDto.getModel());
        vehicle.setCapacity(vehicleRequestDto.getCapacity());
        vehicle.setLicencePlateNumber(vehicleRequestDto.getLicencePlateNumber());
        //vehicle.setVehicleType(vehicleRequestDto.getVehicleType());
        vehicle.setOwnerId(ownerId);

        vehicleService.update(vehicle);
    }

    @RequestMapping(value = "v1/driver/{driverId}/vehicle/{vehicleId}",method = RequestMethod.DELETE)
    public @ResponseBody void removeVehicle(@PathVariable("driverId") Long ownerId,
                                            @PathVariable("vehicleId") Long vehicleId,
                                            HttpServletRequest request,
                                            HttpServletResponse response)
    {
        vehicleService.removeById(vehicleId);
    }

    @RequestMapping(value = "v1/driver/{driverId}/getvehical",method ={RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody Vehicle getVehicle(@PathVariable("driverId") Long ownerId,
                                            HttpServletRequest request,
                                            HttpServletResponse response)
    {
        return vehicleService.get(ownerId);
    }


    @RequestMapping(value = "v1/driver/{driverId}/vehicles",method = RequestMethod.GET)
    public @ResponseBody List<Vehicle> getAllVehicles(@PathVariable("driverId") Long ownerId,
                                            HttpServletRequest request,
                                            HttpServletResponse response)
    {
        return vehicleService.getAll();
    }

}
