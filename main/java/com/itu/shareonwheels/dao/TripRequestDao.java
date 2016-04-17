package com.itu.shareonwheels.dao;

import com.itu.shareonwheels.entity.Trip;
import com.itu.shareonwheels.entity.User;

/**
 * Created by nikitasonthalia on 10/17/15.
 */
public interface TripRequestDao {

    Long checkSeat(Trip trip);

    User getDriverInfo(String driverId);

    User getRiderInfo(String requesterId);

    void updateSeat(Trip trip);



    void createComfrimedTrip(String driverId, String riderId, Trip trip);

    int checktripstatus(int tripId);
}
