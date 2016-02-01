package com.rln.acme.restaurant.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Menu extends AbstractDocument implements Serializable {

    private static final long serialVersionUID = -1455859434166085566L;

    @Id
    private String id;

    @DBRef
    private Restaurant restaurant;

    private List<MenuItem> items;

    public Menu() {

    }

    @Override
    public String getId() {
        return id;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public void setItems(List<MenuItem> items) {
        this.items = items;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

}
