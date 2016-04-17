package com.itu.shareonwheels.entity;

import java.util.List;

/**
 * Created by ramya on 9/30/15.
 */
public class Rider extends User {

    private Long riderId;

    private double rating;

    private int totalNumberOfTrips;

    public Long getRiderId() {
        return riderId;
    }

    public void setRiderId(Long riderId) {
        this.riderId = riderId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getTotalNumberOfTrips() {
        return totalNumberOfTrips;
    }

    public void setTotalNumberOfTrips(int totalNumberOfTrips) {
        this.totalNumberOfTrips = totalNumberOfTrips;
    }
}
