package com.itu.shareonwheels.dao;

import com.itu.shareonwheels.entity.Vehicle;

/**
 * Created by ramya on 10/8/15.
 */
public interface VehicleDao {
    Long create(Vehicle vehicle);

    void update(Vehicle vehicle);

    void delete(Long vehicleId);

    Vehicle get(Long aLong);

    Vehicle getVehicleDetailsByUserId(Long userId);
}
