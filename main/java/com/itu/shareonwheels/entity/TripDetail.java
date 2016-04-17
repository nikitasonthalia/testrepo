package com.itu.shareonwheels.entity;

/**
 * Created by nikitasonthalia on 12/7/15.
 */
public class TripDetail {
   private String  Start_Location;
    private String destination;
   private String tripDate;
   private String tripTime;
    private String first_name;


    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTripDate() {
        return tripDate;
    }

    public void setTripDate(String tripDate) {
        this.tripDate = tripDate;
    }

    public String getTripTime() {
        return tripTime;
    }

    public void setTripTime(String tripTime) {
        this.tripTime = tripTime;
    }


    public String getStart_Location() {
        return Start_Location;
    }

    public void setStart_Location(String start_Loction) {
        Start_Location = start_Loction;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
}
