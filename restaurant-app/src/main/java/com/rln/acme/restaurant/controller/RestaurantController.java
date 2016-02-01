package com.rln.acme.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rln.acme.restaurant.model.Restaurant;
import com.rln.acme.restaurant.repository.RestaurantRepository;

@RestController()
@RequestMapping("/api/restaurant")
public class RestaurantController extends AbstractCRUDController<Restaurant, String> {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    MongoRepository<Restaurant, String> getRepository() {
        return restaurantRepository;
    }

}
