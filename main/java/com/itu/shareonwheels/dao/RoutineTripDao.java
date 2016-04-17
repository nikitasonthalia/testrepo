package com.itu.shareonwheels.dao;

import com.itu.shareonwheels.entity.RoutineTrip;

/**
 * Created by nikitasonthalia on 10/10/15.
 */
public interface RoutineTripDao {

    Long create(RoutineTrip routineTrip);

    void update(RoutineTrip routineTrip);

    void delete(Long userId);

}
