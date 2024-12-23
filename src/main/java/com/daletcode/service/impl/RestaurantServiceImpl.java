package com.daletcode.service.impl;

import com.daletcode.constant.Constant;
import com.daletcode.dto.RestaurantRequest;
import com.daletcode.dto.RestaurantResponse;
import com.daletcode.model.Restaurant;
import com.daletcode.repository.RestaurantRepository;
import com.daletcode.service.RestaurantService;
import com.daletcode.service.handler.RestaurantHandlerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantHandlerService restaurantHandlerService;

    @Override
    public RestaurantResponse create(RestaurantRequest restaurantRequest) {
        Restaurant restaurant = new Restaurant();
        restaurant = restaurantHandlerService
                .convertRestaurantRequestToRestaurant(restaurantRequest, restaurant);

        log.info("Creating restaurant: {}", restaurant);
        restaurantRepository.saveAndFlush(restaurant);

        return restaurantHandlerService.convertRestaurantToRestaurantResponse(restaurant);
    }

    @Override
    public RestaurantResponse update(Long id, RestaurantRequest restaurantRequest) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        if(restaurant.isPresent()) {
            Restaurant updateRestaurant = restaurantHandlerService
                    .convertRestaurantRequestToRestaurant(restaurantRequest, restaurant.get());

            updateRestaurant.setUpdatedAt(new Date());
            updateRestaurant.setUpdatedBy(Constant.SYSTEM);

            log.info("Updating restaurant: {}", updateRestaurant);
            restaurantRepository.saveAndFlush(updateRestaurant);

            return restaurantHandlerService.convertRestaurantToRestaurantResponse(updateRestaurant);
        }
        return new RestaurantResponse();
    }

    @Override
    public void delete(Long id) {
        restaurantRepository.deleteById(id);
    }

    @Override
    public RestaurantResponse getById(Long id) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        if(restaurant.isEmpty()){
            return new RestaurantResponse();
        }
        return restaurantHandlerService.convertRestaurantToRestaurantResponse(restaurant.get());
    }

    @Override
    public List<RestaurantResponse> getAll() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        if(restaurants.isEmpty()) {
            return List.of();
        }

        List<RestaurantResponse> restaurantResponses = new ArrayList<>();
        for(Restaurant restaurant : restaurants) {
            restaurantResponses
                    .add(restaurantHandlerService.convertRestaurantToRestaurantResponse(restaurant));
        }
        return restaurantResponses;
    }
}
