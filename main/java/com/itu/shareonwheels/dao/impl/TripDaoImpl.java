package com.itu.shareonwheels.dao.impl;

import com.itu.shareonwheels.dao.TripDao;
import com.itu.shareonwheels.entity.Trip;
import com.itu.shareonwheels.entity.TripDetail;
import com.itu.shareonwheels.entity.User;
import com.itu.shareonwheels.enumerations.DayOfWeek;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nikitasonthalia on 10/9/15.
 */

@Repository
public class TripDaoImpl extends NamedParameterJdbcDaoSupport implements TripDao
{


    @Autowired
    public TripDaoImpl(DataSource dataSource) {
        setDataSource(dataSource);
    }
    public void update(Trip trip) {

    }

    public void delete(Trip trip) {

    }

    public Long create(Trip trip) {

        String tripType = trip.getTripType();
        System.out.print(tripType);
        DayOfWeek[] days = trip.getDayOfWeek();
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int i;
        if(tripType.equalsIgnoreCase("Routine")) {
            for(i = 0;i <days.length;i++)
            {
                final String Trip_Creation_Query = "insert into Trip_Table (Start_Location,Destination,Trip_Time,Seat_Available,User_Id,User_Type,Day_of_Week,Frequency,Trip_Type,status)" +
                        "values(:startLocation , :destination , :tripTime, :seatAvailable, :userId, :userType, :daysOfWeek, :frequency,:tripType,:status)";


                //System.out.println("Value of enum " + days[i].name());

                getNamedParameterJdbcTemplate().update(
                        Trip_Creation_Query,
                        new MapSqlParameterSource()
                                .addValue("startLocation", trip.getStartLocation())
                                .addValue("destination", trip.getDestination())
                                .addValue("tripTime", trip.getTripTime())
                                .addValue("seatAvailable", trip.getSeatAvailable())
                                .addValue("userId", trip.getUserId())
                                .addValue("userType", trip.getUserType())
                                .addValue("daysOfWeek", days[i].name().toString())
                                .addValue("frequency", trip.getFrequency())
                                .addValue("tripType", trip.getTripType())
                                .addValue("status", "Incomplete"),

                        keyHolder);

            }

            return keyHolder.getKey().longValue();


        } else {
            final String OnetimeTrip_Creation_Query = "insert into Trip_Table (Start_Location,Destination,Trip_Time,Seat_Available,User_Id,User_Type,Trip_Date,Trip_Type,status)" +
                    "values(:startLocation , :destination , :tripTime, :seatAvailable, :userId, :userType, :tripDate, :tripType,:status)";


            System.out.println("Value of enum " );
            getNamedParameterJdbcTemplate().update(
                    OnetimeTrip_Creation_Query,
                    new MapSqlParameterSource()
                            .addValue("startLocation", trip.getStartLocation())
                            .addValue("destination", trip.getDestination())
                            .addValue("tripTime", trip.getTripTime())
                            .addValue("seatAvailable", trip.getSeatAvailable())
                            .addValue("userId", trip.getUserId())
                            .addValue("userType", trip.getUserType())
                            .addValue("tripDate", trip.getTripDate())
                            .addValue("tripType", trip.getTripType())
                            .addValue("status", "Incomplete"),

                    keyHolder);
            return keyHolder.getKey().longValue();


        }


    }

    public List<Trip> tripSearch(final Trip trip)
    {

        String startLocation = trip.getStartLocation();
        String destination=trip.getDestination();
        String tripTime=trip.getTripTime();
        String userType;
        String tripDate=trip.getTripDate();
        List<Trip> trips= new ArrayList<Trip>();


        if(startLocation!=null)
        {
            if(destination!=null) {
                if (tripDate != null) {
                    if (tripTime != null) {
                        String Trip_Request_Query = "select * from Trip_Table WHERE Start_Location=:startLocation and Destination = ? and Trip_Date = ? and Trip_Time=? and Seat_Available>0";
//                      SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("startLocation",startLocation)
//                                                                                        .addValue("destination",destination)
//                                                                                        .addValue("tripDate",tripDate)
//                                                                                        .addValue("tripTime",tripTime);
                        trips =  getJdbcTemplate().query(Trip_Request_Query, new Object[]{startLocation, destination, tripDate, tripTime}, new BeanPropertyRowMapper(Trip.class));

                        return trips;


                    } else {
                        String Trip_Request_Query = "select  * from Trip_Table WHERE Start_Location=:startLocation and Destination = ? and Trip_Date =? and Trip_Time= current_time and Seat_Available>0";
//                        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("startLocation", startLocation)
//                                .addValue("destination",destination)
//                                .addValue("tripDate",tripDate);
                        trips=  getJdbcTemplate().query(Trip_Request_Query, new Object[]{startLocation, destination, tripDate}, new BeanPropertyRowMapper(Trip.class));

                        return trips;


                    }


                }
                else
                {
                    if (tripTime != null) {
                        String Trip_Request_Query = "select * from Trip_Table WHERE Start_Location=:startLocation and Destination = ? and Trip_Date = current_date and Trip_Time=? and Seat_Available>0";
//                        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("startLocation", startLocation)
//                                .addValue("destination",destination)
//                                .addValue("tripTime", tripTime);

                         trips = getJdbcTemplate().query(Trip_Request_Query, new Object[]{startLocation, destination, tripTime}, new BeanPropertyRowMapper(Trip.class));
                        return trips;

                    } else {
                        String startLocation1 = startLocation.replaceAll("\\s","");
                       // System.out.println(startLocation1);
                        String destination1 = destination.replaceAll("\\s","");

                        String Trip_Request_Query = "select * from Trip_Table WHERE  REPLACE(LTRIM(RTRIM(lcase(Start_Location))),CHAR(32),'') like '%"+startLocation1+"%'   and  REPLACE(LTRIM(RTRIM(lcase(Destination))),CHAR(32),'') like '%"+destination1 +"%' and Seat_Available>0 ";//" and Trip_Date = current_date and Trip_Time=current_time and Seat_Available>0";
                        //SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("startLocation", startLocation)
                        //        .addValue("destination", destination);
                        //System.out.println(Trip_Request_Query);
                        trips= getJdbcTemplate().query(Trip_Request_Query, new Object[]{}, new BeanPropertyRowMapper<Trip>(Trip.class));
                        //List<Map<String, Object>> rows= getJdbcTemplate().queryForList(Trip_Request_Query);
                        //System.out.println(Trip_Request_Query);
                        return trips;
                    }
                }
            }
            else
            {
                // pass error
            }


        }
        else
        {
                // pass error
        }

        return trips;




    }

    @Override
    public List<TripDetail> getTripHistoryAsDriver(User user) {
        List<TripDetail> tripdrivers= new ArrayList<TripDetail>();

        String Trip_Request_Query = "select b.Start_Location,b.Destination,b.Trip_Time,b.Trip_Date,c.first_name from shareonwheels.Trip_record as a left join shareonwheels.Trip_Table as b on a.Trip_Id=b.Trip_Id  left join shareonwheels.user as c on a.Trip_Rider=c.user_id where a.Trip_Driver=?";
        tripdrivers =  getJdbcTemplate().query(Trip_Request_Query, new Object[]{user.getUserId()}, new BeanPropertyRowMapper(TripDetail.class));

        return tripdrivers;


    }

    @Override
    public List<TripDetail> getTripHistoryAsRider(User user) {
        List<TripDetail> tripRider= new ArrayList<TripDetail>();

        String Trip_Request_Query = "select b.Start_Location,b.Destination,b.Trip_Time,b.Trip_Date,c.first_name from shareonwheels.Trip_record as a left join shareonwheels.Trip_Table as b on a.Trip_Id=b.Trip_Id  left join shareonwheels.user as c on a.Trip_Driver=c.user_id where a.Trip_Rider=?";
        tripRider =  getJdbcTemplate().query(Trip_Request_Query, new Object[]{user.getUserId()}, new BeanPropertyRowMapper(TripDetail.class));

        return tripRider;

    }

    @Override
    public List<Trip> getTripHistory(User user) {
        List<Trip> tripUser= new ArrayList<Trip>();

        String Trip_Request_Query = "select * from shareonwheels.Trip_Table where User_Id=?";
        tripUser =  getJdbcTemplate().query(Trip_Request_Query, new Object[]{user.getUserId()}, new BeanPropertyRowMapper(Trip.class));

        return tripUser;

    }


}