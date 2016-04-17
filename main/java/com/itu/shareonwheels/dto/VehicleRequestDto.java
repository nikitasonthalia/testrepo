package com.itu.shareonwheels.dto;

/**
 * Created by ramya on 10/8/15.
 */
public class VehicleRequestDto {

    //DB generated vehicle Id
    private Long vehicleId;

    //e.g. Nissan Altima
    private String model;

    //# of passengers
    private int capacity;


    private Long ownerId;

    private String licencePlateNumber;

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getLicencePlateNumber() {
        return licencePlateNumber;
    }

    public void setLicencePlateNumber(String licencePlateNumber) {
        this.licencePlateNumber = licencePlateNumber;
    }
    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

}
