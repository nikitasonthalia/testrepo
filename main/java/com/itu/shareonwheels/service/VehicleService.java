package com.itu.shareonwheels.service;

import com.itu.shareonwheels.dao.VehicleDao;
import com.itu.shareonwheels.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ramya on 10/8/15.
 */
@Service
public class VehicleService implements  GenericService <Vehicle, Long>{
    @Autowired
    private VehicleDao vehicleDao;


    @Override
    public Long create(Vehicle vehicle) {
        return vehicleDao.create(vehicle);
    }

    @Override
    public void update(Vehicle vehicle) {
        vehicleDao.update(vehicle);
    }

    @Override
    public Vehicle get(Long aLong) {
        return vehicleDao.get(aLong);
    }

    @Override
    public List<Vehicle> getAll() {
        return null;
    }

    @Override
    public void removeById(Long aLong) {
        vehicleDao.delete(aLong);
    }

    public Vehicle getVehicleDetailsByUserId(Long userId){
       return vehicleDao.getVehicleDetailsByUserId(userId);
    }

}
