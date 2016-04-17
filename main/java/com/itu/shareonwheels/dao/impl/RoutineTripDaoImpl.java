package com.itu.shareonwheels.dao.impl;

import com.itu.shareonwheels.dao.RoutineTripDao;
import com.itu.shareonwheels.entity.RoutineTrip;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

/**
 * Created by nikitasonthalia on 10/10/15.
 */
public class RoutineTripDaoImpl extends NamedParameterJdbcDaoSupport implements RoutineTripDao {
    private static final String OnetimeTrip_Creation_Query= "insert into RoutineTrip_Table (Start_Location,Destination,Trip_Time,Seat_Available,UserId,User_Type,Days_of_week,Frequency)" +
            "values(:startLocation , :destination , :tripTime, :seatAvailable, :userId, :userType, :daysOfWeek, :frequency)";

    public void update(RoutineTrip routineTrip) {

    }

    public void delete(Long userid) {

    }

    public Long create(RoutineTrip routineTrip) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        getNamedParameterJdbcTemplate().update(
                OnetimeTrip_Creation_Query,
                new MapSqlParameterSource()
                        .addValue("startlocation", routineTrip.getStartlocation())
                        .addValue("destiantion", routineTrip.getDestination())
                        .addValue("triptime", routineTrip.getTriptime())
                        .addValue("seatavailable", routineTrip.getSeatavailable())
                        .addValue("userid", routineTrip.getUserid())
                        .addValue("usertype", routineTrip.getUsertype())
                        .addValue("daysOfWeek", routineTrip.getDayOfWeek())
                        .addValue("frequency", routineTrip.getFrequency()),
                keyHolder);


        return keyHolder.getKey().longValue();
    }

}
