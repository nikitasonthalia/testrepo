package com.itu.shareonwheels.dao;
import com.itu.shareonwheels.entity.Trip;
import com.itu.shareonwheels.entity.TripDetail;
import com.itu.shareonwheels.entity.User;

import java.util.List;

/**
 * Created by nikitasonthalia on 10/9/15.
 */
public interface TripDao {


    void update(Trip trip);
    void delete(Trip trip);
    Long create(Trip trip);
    List<Trip> tripSearch(Trip trip);
    List<TripDetail>getTripHistoryAsDriver(User user);
    List<TripDetail>getTripHistoryAsRider(User user);
    List<Trip>getTripHistory(User user);

}
