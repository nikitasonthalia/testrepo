package com.itu.shareonwheels.entity;

import com.itu.shareonwheels.enumerations.DayOfWeek;
import com.itu.shareonwheels.enumerations.Frequency;

/**
 * Created by nikitasonthalia on 10/9/15.
 */
public class Trip {

   private int tripId;
    private String startLocation;
    private String destination;
    private String tripTime;
    private int seatAvailable;
    private String userId;
    private String userType;
    private String tripDate;
    private DayOfWeek[] dayOfWeek;
    private Frequency frequency;
    private  String tripType;

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTripTime() {
        return tripTime;
    }

    public void setTripTime(String tripTime) {
        this.tripTime = tripTime;
    }

    public int getSeatAvailable() {
        return seatAvailable;
    }

    public void setSeatAvailable(int seatAvailable) {
        this.seatAvailable = seatAvailable;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTripType() {
        return tripType;
    }

    public void setTripType(String tripType) {
        this.tripType = tripType;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    public DayOfWeek[] getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek[] dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getTripDate() {
        return tripDate;
    }

    public void setTripDate(String tripDate) {
        this.tripDate = tripDate;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }






}
