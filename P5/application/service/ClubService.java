package com.example.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.application.persistence.Club;
import com.example.application.persistence.ClubRepository;

@Service
public class ClubService {

    @Autowired
    private ClubRepository repository;

    public ClubService(ClubRepository repository){
        this.repository = repository;
    }

    public List<Club> getAll(){
        return this.repository.findAll();
    }

    public Club getByID(Integer clubId) {
        return this.repository.findById(clubId).get();
    }

    public Club saveClub(Club club){
        //club spon = new club(club.getclubName());
        return this.repository.save(club);
    }

    public Club update(Integer clubID, Club club){
        System.out.println(clubID);
        Optional<Club> spon = this.repository.findById(clubID);
        if(spon.isPresent()){
            spon.get().setClubName(club.getClubName());
            return this.repository.save(spon.get());
        }
        throw new RuntimeException();
    }

    public void delete(Integer clubID){
        this.repository.deleteById(clubID);
    }

}
