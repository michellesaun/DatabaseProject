package com.example.application.resource;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.example.application.persistence.Club;
import com.example.application.service.ClubService;

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
public class ClubResource {

    @Autowired
    private ClubService service;

    public ClubResource(ClubService service){
        this.service = service;
    }

    @GetMapping("/clubs")
    public List<Club> getAll(){
        return this.service.getAll();
    }
    @GetMapping("/clubs/{clubID}")
    public Club getByID(@PathVariable Integer clubID){
        return this.service.getByID(clubID);
    }
    @PostMapping(value = "/clubs/add")
    public Club postClub(@RequestBody Club club){
        return this.service.saveClub(club);
        
    }
    //consumes = "application/json"
    @PutMapping(value = "/clubs/update/{clubID}")
    public Club update(@PathVariable Integer clubID, @RequestBody Club club){
        return this.service.update(clubID, club);
    }
    @DeleteMapping("/clubs/delete/{clubID}")
    public void delete(@PathVariable Integer clubID){
        this.service.delete(clubID);
    }
}
