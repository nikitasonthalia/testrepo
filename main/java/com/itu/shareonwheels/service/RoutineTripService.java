package com.itu.shareonwheels.service;


import com.itu.shareonwheels.dao.RoutineTripDao;
import com.itu.shareonwheels.entity.RoutineTrip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nikitasonthalia on 10/10/15.
 */

public class RoutineTripService  implements GenericService<RoutineTrip, Long>
{
    @Autowired
    private RoutineTripDao routineTripDao;



    public void update(RoutineTrip routineTrip )
    {
        routineTripDao.update(routineTrip);
    }

    /* public void delete(OnetimeTrip onetimeTrip)
     {
         onetimeTripDao.delete(Long along);
     }*/
    public void removeById(Long aLong) {

    }

    public List<RoutineTrip> getAll() {
        return null;
    }

    public RoutineTrip get(Long aLong) {
        return null;
    }

    public Long create(RoutineTrip routineTrip) {
        return routineTripDao.create(routineTrip);
    }
}
