package com.itu.shareonwheels.dto;

import com.itu.shareonwheels.entity.Vehicle;

/**
 * Created by ramya on 10/15/15.
 */
public class DriverDto {
    private Vehicle vehicle;

    private String driverLicenseNumber;

    public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    public void setDriverLicenseNumber(String driverLicenseNumber) {
        this.driverLicenseNumber = driverLicenseNumber;
    }
}
