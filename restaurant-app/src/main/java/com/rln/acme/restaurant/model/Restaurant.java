package com.rln.acme.restaurant.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@TypeAlias("restaurant")
public class Restaurant extends AbstractDocument implements Serializable {

    private static final long serialVersionUID = -2489255854912222922L;

    @Id
    private String id;

    private String name;

    private Menu menu;

    public Restaurant() {
    }

    @Override
    public String getId() {
        return id;
    }

    public Menu getMenu() {
        return menu;
    }

    public String getName() {
        return name;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void setName(String name) {
        this.name = name;
    }

}
