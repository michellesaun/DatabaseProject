package com.example.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.application.persistence.Sponsor;
import com.example.application.persistence.SponsorRepository;

@Service
public class SponsorService {

    @Autowired
    private SponsorRepository repository;

    public SponsorService(SponsorRepository repository){
        this.repository = repository;
    }

    public List<Sponsor> getAll(){
        return this.repository.findAll();
    }

    public Sponsor getByID(Integer sponsorId) {
        return this.repository.findById(sponsorId).get();
    }

    public Sponsor saveSponsor(Sponsor sponsor){
        //Sponsor spon = new Sponsor(sponsor.getSponsorName());
        return this.repository.save(sponsor);
    }

    public Sponsor update(Integer sponsorID, Sponsor sponsor){
        System.out.println(sponsorID);
        Optional<Sponsor> spon = this.repository.findById(sponsorID);
        if(spon.isPresent()){
            spon.get().setSponsorName(sponsor.getSponsorName());
            return this.repository.save(spon.get());
        }
        throw new RuntimeException();
    }

    public void delete(Integer sponsorID){
        this.repository.deleteById(sponsorID);
    }

}
