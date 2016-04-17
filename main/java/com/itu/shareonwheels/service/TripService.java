package com.itu.shareonwheels.service;

import com.itu.shareonwheels.dao.TripDao;
import com.itu.shareonwheels.entity.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nikitasonthalia on 10/9/15.
 */
@Service
public class TripService implements GenericService< Trip, Long>
{
    @Autowired
    private TripDao tripDao;



    public void update(Trip trip)
    {
        tripDao.update(trip);
    }


    public void removeById(Long aLong) {

    }

    public List<Trip> getAll() {
        return null;
    }

    public Trip get(Long aLong) {
        return null;
    }

    public Long create(Trip trip) {

            return tripDao.create(trip);

    }

    public List<Trip> tripSearch(Trip trip)
    {

        return tripDao.tripSearch(trip);
    }

}

