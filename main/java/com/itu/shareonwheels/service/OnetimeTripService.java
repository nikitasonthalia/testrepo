package com.itu.shareonwheels.service;

import com.itu.shareonwheels.dao.OnetimeTripDao;
import com.itu.shareonwheels.entity.OnetimeTrip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nikitasonthalia on 10/9/15.
 */

public class OnetimeTripService implements GenericService< OnetimeTrip, Long>
{
    @Autowired
    private OnetimeTripDao onetimeTripDao;

    public void insert(OnetimeTrip onetimeTrip)
    {
        onetimeTripDao.insert(onetimeTrip);
    }

    public void update(OnetimeTrip onetimeTrip)
    {
        onetimeTripDao.update(onetimeTrip);
    }

   /* public void delete(OnetimeTrip onetimeTrip)
    {
        onetimeTripDao.delete(Long along);
    }*/
    public void removeById(Long aLong) {

    }

    public List<OnetimeTrip> getAll() {
        return null;
    }

    public OnetimeTrip get(Long aLong) {
        return null;
    }

    public Long create(OnetimeTrip onetimeTrip) {
        return onetimeTripDao.create(onetimeTrip);
    }

}

