package com.daletcode.service;

import com.daletcode.dto.RestaurantRequest;
import com.daletcode.dto.RestaurantResponse;

import java.util.List;

public interface RestaurantService {

    RestaurantResponse create(RestaurantRequest restaurantRequest);
    RestaurantResponse update(Long id, RestaurantRequest restaurantRequest);
    void delete(Long id);
    RestaurantResponse getById(Long id);
    List<RestaurantResponse> getAll();

}
