package com.itu.shareonwheels.entity;

/**
 * Created by nikitasonthalia on 10/9/15.
 */
public class OnetimeTrip {

    private String startlocation;
    private String destination;
    private String triptime;
    private int seatavailable;
    private String userid;
    private String usertype;
    private String tripdate;


    public String getStartlocation()
    {
        return this.startlocation;
    }

    public void setStartlocation(String startlocation)
    {
        this.startlocation=startlocation;
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
        return this.triptime;
    }

    public void setTriptime(String time)
    {
        this.triptime=time;
    }

    public int getSeatavailable()
    {
        return this.seatavailable;
    }

    public void setSeatavailable(int seatavailable)
    {
        this.seatavailable=seatavailable;
    }

    public String getUserid()
    {
        return this.userid;
    }

    public void setUserid(String userid)
    {
        this.userid=userid;
    }

    public String getUsertype()
    {
        return this.usertype;
    }

    public void setUsertype(String usertype)
    {
        this.usertype=usertype;
    }

    public String getTripdate()
    {
        return this.tripdate;
    }

    public void setTripdate(String tripdate)
    {
        this.tripdate=tripdate;
    }
}
