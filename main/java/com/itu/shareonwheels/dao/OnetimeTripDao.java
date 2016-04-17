package com.itu.shareonwheels.dao;
import com.itu.shareonwheels.entity.OnetimeTrip;
/**
 * Created by nikitasonthalia on 10/9/15.
 */
public interface OnetimeTripDao {

    void insert(OnetimeTrip onetimeTrip);
    void update(OnetimeTrip onetimeTrip);
    void delete(OnetimeTrip onetimeTrip);
    long create(OnetimeTrip onetimeTrip);

}
