package com.rln.acme.restaurant.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rln.acme.restaurant.model.AbstractDocument;

@RestController()
public abstract class AbstractCRUDController<T extends AbstractDocument, K extends String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractCRUDController.class);


    @RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public T create(@RequestBody @Valid T entity) {
        LOGGER.debug("Retrieving document {} from database with id {}", entity.getClass().getName(), (entity.getId()));
        return this.getRepository().save(entity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable("id") K id) {
        LOGGER.debug("Deleting document with id {}", id);
        this.getRepository().delete(id);
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public T get(@PathVariable("id") K id) {
        LOGGER.debug("Finding document with id {}", id);
        return this.getRepository().findOne(id);
    }

    abstract MongoRepository<T,K> getRepository();

    @RequestMapping(method = RequestMethod.GET)
    public List<T> list() {
        return this.getRepository().findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public T update(@PathVariable("id") K id, @RequestBody @Valid T document) {
        LOGGER.debug("Update document with id {}", id);
        return this.getRepository().save(document);
    }

}
