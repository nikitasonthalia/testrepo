package com.itu.shareonwheels.service;

import java.util.List;

/**
 * Created by ramya on 9/28/15.
 */
public interface GenericService <T, K> {

    K create(T t);
    void update(T t);
    T get(K k);
    List<T> getAll();
    void removeById(K k);
}
