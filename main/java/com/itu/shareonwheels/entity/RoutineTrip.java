package com.itu.shareonwheels.entity;
import com.itu.shareonwheels.enumerations.DayOfWeek;
import com.itu.shareonwheels.enumerations.Frequency;
/**
 * Created by nikitasonthalia on 10/10/15.
 */
public class RoutineTrip {
    private String startLocation;
    private String destination;
    private String tripTime;
    private int seatAvailable;
    private String userId;
    private String userType;
    private DayOfWeek dayOfWeek;
    private Frequency frequency;

    public String getStartlocation()
    {
        return this.startLocation;
    }

    public void setStartlocation(String startlocation)
    {
        this.startLocation=startlocation;
    }

    public String getDestination()
    {
        return this.destination;
    }

    public void setDestination(String destination)
    {
        this.destination=destination;
    }

    public String getTriptime()
    {
        return this.tripTime;
    }

    public void setTriptime(String time)
    {
        this.tripTime=time;
    }

    public int getSeatavailable()
    {
        return this.seatAvailable;
    }

    public void setSeatavailable(int seatavailable)
    {
        this.seatAvailable=seatavailable;
    }

    public String getUserid()
    {
        return this.userId;
    }

    public void setUserid(String userid)
    {
        this.userId=userid;
    }

    public String getUsertype()
    {
        return this.userType;
    }

    public void setUsertype(String usertype)
    {
        this.userType=usertype;
    }

    public DayOfWeek getDayOfWeek()
    {
        return this.dayOfWeek;
    }
    public void setDayOfWeek(DayOfWeek dayOfWeek)
    {
        this.dayOfWeek=dayOfWeek;
    }
    public Frequency getFrequency()
    {
        return this.frequency;
    }
    public void setFrequency(Frequency frequency)
    {
        this.frequency=frequency;
    }
}
