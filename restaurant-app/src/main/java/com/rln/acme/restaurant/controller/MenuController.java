package com.rln.acme.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rln.acme.restaurant.model.Menu;
import com.rln.acme.restaurant.repository.MenuRepository;

@RestController()
@RequestMapping("/api/menu")
public class MenuController extends AbstractCRUDController<Menu, String> {

    private final MenuRepository menuRepository;

    @Autowired
    public MenuController(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    MongoRepository<Menu, String> getRepository() {
        return menuRepository;
    }

}
