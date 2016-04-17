package com.itu.shareonwheels.entity;

import com.itu.shareonwheels.enumerations.DayOfWeek;
import com.itu.shareonwheels.enumerations.Frequency;
import com.itu.shareonwheels.enumerations.TripType;
import com.itu.shareonwheels.util.Time;

import java.util.Date;

/**
 * Created by ramya on 9/30/15.
 */
public class DriverSchedule {


    private Long scheduleId;

    private TripType tripType;

    private Time onwardTime;

    private Time returnTime;

    private DayOfWeek dayOfWeek;

    private Date scheduleStartDate;

    private Date scheduleEndDate;

    private Frequency frequency;

    private Long driverId;

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public TripType getTripType() {
        return tripType;
    }

    public void setTripType(TripType tripType) {
        this.tripType = tripType;
    }

    public Time getOnwardTime() {
        return onwardTime;
    }

    public void setOnwardTime(Time onwardTime) {
        this.onwardTime = onwardTime;
    }

    public Time getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Time returnTime) {
        this.returnTime = returnTime;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Date getScheduleStartDate() {
        return scheduleStartDate;
    }

    public void setScheduleStartDate(Date scheduleStartDate) {
        this.scheduleStartDate = scheduleStartDate;
    }

    public Date getScheduleEndDate() {
        return scheduleEndDate;
    }

    public void setScheduleEndDate(Date scheduleEndDate) {
        this.scheduleEndDate = scheduleEndDate;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }
}
