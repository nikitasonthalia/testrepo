package com.itu.shareonwheels.service;

import com.itu.shareonwheels.dao.TripDao;
import com.itu.shareonwheels.entity.Trip;
import com.itu.shareonwheels.entity.TripDetail;
import com.itu.shareonwheels.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nikitasonthalia on 12/8/15.
 */

@Service
public class TripHistoryService {

    @Autowired
    private TripDao tripDao;
    public List<TripDetail>  getTripHistoryAsDriver(User user)
    {
       return  tripDao.getTripHistoryAsDriver(user);
    }

    public List<TripDetail>  getTripHistoryAsRider(User user)
    {
        return  tripDao.getTripHistoryAsRider(user);
    }

    public List<Trip>  getTripHistory(User user)
    {
        return  tripDao.getTripHistory(user);
    }
}
