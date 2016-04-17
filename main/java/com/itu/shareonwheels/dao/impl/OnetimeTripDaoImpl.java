package com.itu.shareonwheels.dao.impl;

import com.itu.shareonwheels.dao.OnetimeTripDao;
import com.itu.shareonwheels.entity.OnetimeTrip;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

/**
 * Created by nikitasonthalia on 10/9/15.
 */


public class OnetimeTripDaoImpl extends NamedParameterJdbcDaoSupport implements OnetimeTripDao {


   private static final String OnetimeTrip_Creation_Query= "insert into OnetimeTrip_Table (Start_Location,Destination,Time,Seat_Available,UserId,User_Type,Trip_Date)" +
           "values(:startlocation , :destination , :triptime, :seatavailable, :userid, :usertype, :tripdate)";








    public void insert(OnetimeTrip onetimeTrip) {

    }

    public void update(OnetimeTrip onetimeTrip) {

    }

    public void delete(OnetimeTrip onetimeTrip) {

    }

    public long create(OnetimeTrip onetimeTrip) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        getNamedParameterJdbcTemplate().update(
                OnetimeTrip_Creation_Query,
                new MapSqlParameterSource()
                .addValue("startlocation", onetimeTrip.getStartlocation())
                .addValue("destiantion",onetimeTrip.getDestination())
                .addValue("triptime",onetimeTrip.getTriptime())
                .addValue("seatavailable",onetimeTrip.getSeatavailable())
                .addValue("userid",onetimeTrip.getUserid())
                .addValue("usertype",onetimeTrip.getUsertype())
                .addValue("tripdate",onetimeTrip.getTripdate()),
                keyHolder);


        return keyHolder.getKey().longValue();
    }
}
