package com.itu.shareonwheels.dao.impl;

import com.itu.shareonwheels.dao.TripRequestDao;
import com.itu.shareonwheels.entity.Trip;
import com.itu.shareonwheels.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

/**
 * Created by nikitasonthalia on 10/17/15.
 */
@Repository
public class TripRequestDaoImpl extends NamedParameterJdbcDaoSupport implements TripRequestDao {

    User user = new User();




    @Autowired
    public TripRequestDaoImpl(DataSource dataSource){
        setDataSource(dataSource);
    }


    @Override
    public Long checkSeat(Trip trip) {
        return null;
    }

    @Override
    public User getDriverInfo(String driverId) {

        String Driver_Info_Qrerry="select * from user where user_id=?";
        user  =(User)getJdbcTemplate().queryForObject(Driver_Info_Qrerry,new Object[] { driverId }, new BeanPropertyRowMapper(User.class));

        return user;
    }

    @Override
    public User getRiderInfo(String riderId) {

        String Driver_Info_Qrerry="select * from user where user_id=?";
        user  =(User)getJdbcTemplate().queryForObject(Driver_Info_Qrerry,new Object[] { riderId }, new BeanPropertyRowMapper(User.class));

        return user;

    }

    @Override
    public void updateSeat(Trip trip) {
        String Update_Seat_Query="update Trip_Table set Seat_Available=Seat_Available-1 where Trip_Id=:tripId";
        String Update_Status="update Trip_Table set status=:status where Trip_Id=:tripId and lcase(trip_Type)=:tripType and Seat_Available<=0";
        //getJdbcTemplate().query(Update_Seat_Query,new Object[]{trip.getTripId()},new BeanPropertyRowMapper());
        getNamedParameterJdbcTemplate().update(
                Update_Seat_Query,
                new MapSqlParameterSource()
                        .addValue("tripId", trip.getTripId())
        );
        KeyHolder keyHolder = new GeneratedKeyHolder();
        getNamedParameterJdbcTemplate().update(
                Update_Status,
                new MapSqlParameterSource()
                        .addValue("tripId", trip.getTripId())
                        .addValue("status", "Complete")
                        .addValue("tripType", "onetime"),keyHolder);




    }

    @Override
    public void createComfrimedTrip(String driverId, String riderId, Trip trip) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String Create_TripComfrimed_Query="insert into Trip_record (Trip_Driver,Trip_Rider,Trip_Id) values(:driverid,:riderid,:tripid) ";
        getNamedParameterJdbcTemplate().update(Create_TripComfrimed_Query,
                new MapSqlParameterSource()
                        .addValue("driverid",driverId)
                        .addValue("riderid", riderId)
                        .addValue("tripid", trip.getTripId()),keyHolder);

    }

    @Override
    public int checktripstatus(int tripId) {

        String VERIFY_trip_QUERY =  "select count(*) from Trip_Table WHERE status=:status and trip_Id=:tripId";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("tripId",tripId).addValue("status", "Incomplete");
        int rowCount = getNamedParameterJdbcTemplate().queryForObject(VERIFY_trip_QUERY, namedParameters, Integer.class);

        if(rowCount == 1){
            return 1;
        }
        else{
            return 0;
        }



    }


}
