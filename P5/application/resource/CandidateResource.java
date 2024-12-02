package com.example.application.resource;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.example.application.persistence.Candidate;
import com.example.application.service.CandidateService;

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
public class CandidateResource {

    @Autowired
    private CandidateService service;

    public CandidateResource(CandidateService service){
        this.service = service;
    }

    @GetMapping("/candidates")
    public List<Candidate> getAll(){
        return this.service.getAll();
    }
    @GetMapping("/candidates/{candidateID}")
    public Candidate getByID(@PathVariable Integer candidateID){
        return this.service.getByID(candidateID);
    }
    @PostMapping(value = "/candidates/add")
    public Candidate postCandidate(@RequestBody Candidate candidate){
        return this.service.saveCandidate(candidate);
        
    }
    //consumes = "application/json"
    @PutMapping(value = "/candidates/update/{candidateID}")
    public Candidate update(@PathVariable Integer candidateID, @RequestBody Candidate candidate){
        return this.service.update(candidateID, candidate);
    }
    @DeleteMapping("/candidates/delete/{candidateID}")
    public void delete(@PathVariable Integer candidateID){
        this.service.delete(candidateID);
    }
}
