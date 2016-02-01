package com.rln.acme.restaurant.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class MenuItem extends AbstractDocument implements Serializable {

    private static final long serialVersionUID = -1455859434166085566L;

    @Id
    private String id;

    private String itemName;

    private Double price;

    private String content;

    public MenuItem() {

    }

    public String getContent() {
        return content;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public Double getPrice() {
        return price;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
