package com.itu.shareonwheels.dao.impl;

import com.itu.shareonwheels.entity.Driver;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

/**
 * Created by nikitasonthalia on 10/15/15.
 */
public class DriverDaoImpl {
    public Long create(Driver driver) {

        KeyHolder driverIdHolder = new GeneratedKeyHolder();


        return driverIdHolder.getKey().longValue();

    }

}
