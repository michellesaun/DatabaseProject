package com.example.application.resource;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.example.application.persistence.Event;
import com.example.application.service.EventService;

import ch.qos.logback.core.joran.spi.HttpUtil.RequestMethod;
//import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class EventResource {

    @Autowired
    private EventService service;

    public EventResource(EventService service){
        this.service = service;
    }

    @GetMapping("/events")
    public List<Event> getAll(){
        return this.service.getAll();
    }
    @GetMapping("/events/{eventID}")
    public Event getByID(@PathVariable Integer eventID){
        return this.service.getByID(eventID);
    }
    @PostMapping(value = "/events/add")
    public Event postEvent(@RequestBody Event event){
        return this.service.saveEvent(event);
        
    }
    //consumes = "application/json"
    @PutMapping(value = "/events/update/{eventID}")
    public Event update(@PathVariable Integer eventID, @RequestBody Event event){
        return this.service.update(eventID, event);
    }
    @DeleteMapping("/events/delete/{eventID}")
    public void delete(@PathVariable Integer eventID){
        this.service.delete(eventID);
    }
}
