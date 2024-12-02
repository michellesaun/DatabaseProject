package com.example.application.resource;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.example.application.persistence.Sponsor;
import com.example.application.service.SponsorService;

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
public class SponsorResource {

    @Autowired
    private SponsorService service;

    public SponsorResource(SponsorService service){
        this.service = service;
    }

    @GetMapping("/sponsors")
    public List<Sponsor> getAll(){
        return this.service.getAll();
    }
    @GetMapping("/sponsors/{sponsorID}")
    public Sponsor getByID(@PathVariable Integer sponsorID){
        return this.service.getByID(sponsorID);
    }
    @PostMapping(value = "/sponsors/add")
    public Sponsor postSponsor(@RequestBody Sponsor sponsor){
        return this.service.saveSponsor(sponsor);
        
    }
    //consumes = "application/json"
    @PutMapping(value = "/sponsors/update/{sponsorID}")
    public Sponsor update(@PathVariable Integer sponsorID, @RequestBody Sponsor sponsor){
        return this.service.update(sponsorID, sponsor);
    }
    @DeleteMapping("/sponsors/delete/{sponsorID}")
    public void delete(@PathVariable Integer sponsorID){
        this.service.delete(sponsorID);
    }
}
