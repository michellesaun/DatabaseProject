package com.example.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.application.persistence.Event;
import com.example.application.persistence.EventRepository;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;

    public EventService(EventRepository repository){
        this.repository = repository;
    }

    public List<Event> getAll(){
        return this.repository.findAll();
    }

    public Event getByID(Integer eventId) {
        return this.repository.findById(eventId).get();
    }

    public Event saveEvent(Event event){
        //event spon = new event(event.geteventName());
        return this.repository.save(event);
    }

    public Event update(Integer eventID, Event event){
        System.out.println(eventID);
        Optional<Event> spon = this.repository.findById(eventID);
        if(spon.isPresent()){
            spon.get().setEventName(event.getEventName());
            return this.repository.save(spon.get());
        }
        throw new RuntimeException();
    }

    public void delete(Integer eventID){
        this.repository.deleteById(eventID);
    }

}
