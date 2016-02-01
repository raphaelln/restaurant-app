package com.rln.acme.restaurant.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rln.acme.restaurant.model.Restaurant;

@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant, String> {


}