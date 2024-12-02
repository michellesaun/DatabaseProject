package com.example.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.application.persistence.Candidate;
import com.example.application.persistence.CandidateRepository;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository repository;

    public CandidateService(CandidateRepository repository){
        this.repository = repository;
    }

    public List<Candidate> getAll(){
        return this.repository.findAll();
    }

    public Candidate getByID(Integer candidateId) {
        return this.repository.findById(candidateId).get();
    }

    public Candidate saveCandidate(Candidate candidate){
        //candidate spon = new candidate(candidate.getcandidateName());
        return this.repository.save(candidate);
    }

    public Candidate update(Integer candidateID, Candidate candidate){
        System.out.println(candidateID);
        Optional<Candidate> spon = this.repository.findById(candidateID);
        if(spon.isPresent()){
            spon.get().setPosition(candidate.getPosition());
            return this.repository.save(spon.get());
        }
        throw new RuntimeException();
    }

    public void delete(Integer candidateID){
        this.repository.deleteById(candidateID);
    }

}
