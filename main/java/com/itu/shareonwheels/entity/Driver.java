package com.itu.shareonwheels.entity;

import java.util.List;

/**
 * Created by ramya on 9/30/15.
 */
public class Driver extends User {

    private Long driverId;

    private Vehicle vehicle;

    private String driverLicenseNumber;

    private double rating;

    private int totalNumberOfTrips;

    private List<DriverSchedule> driverScheduleList;

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
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

    public List<DriverSchedule> getDriverScheduleList() {
        return driverScheduleList;
    }

    public void setDriverScheduleList(List<DriverSchedule> driverScheduleList) {
        this.driverScheduleList = driverScheduleList;
    }
    public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    public void setDriverLicenseNumber(String driverLicenseNumber) {
        this.driverLicenseNumber = driverLicenseNumber;
    }

}
