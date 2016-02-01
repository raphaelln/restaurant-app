package com.rln.acme.restaurant.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeDeleteEvent;
import org.springframework.stereotype.Component;

import com.rln.acme.restaurant.model.Restaurant;
import com.rln.acme.restaurant.repository.MenuRepository;
import com.rln.acme.restaurant.repository.RestaurantRepository;

@Component
public class RestaurantMongoListener extends AbstractMongoEventListener<Restaurant> {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public void onBeforeDelete(BeforeDeleteEvent<Restaurant> event) {
        final Restaurant rest = restaurantRepository.findOne((String) event.getDBObject().get("id"));
        if (rest != null) {
            menuRepository.removeByRestaurant(rest);
        }

        super.onBeforeDelete(event);
    }

}
