package com.rln.acme.restaurant.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rln.acme.restaurant.model.Menu;
import com.rln.acme.restaurant.model.Restaurant;

@Repository
public interface MenuRepository extends MongoRepository<Menu, String> {

    void removeByRestaurant(final Restaurant rest);


}