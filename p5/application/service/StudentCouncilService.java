package com.example.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.application.persistence.StudentCouncil;
import com.example.application.persistence.StudentCouncilRepository;

@Service
public class StudentCouncilService {

    @Autowired
    private StudentCouncilRepository repository;

    public StudentCouncilService(StudentCouncilRepository repository){
        this.repository = repository;
    }

    public List<StudentCouncil> getAll(){
        return this.repository.findAll();
    }

    public StudentCouncil getByID(Integer studentcouncilId) {
        return this.repository.findById(studentcouncilId).get();
    }

    public StudentCouncil saveStudentCouncil(StudentCouncil studentcouncil){
        //studentcouncil spon = new studentcouncil(studentcouncil.getstudentcouncilName());
        return this.repository.save(studentcouncil);
    }

    public StudentCouncil update(Integer studentcouncilID, StudentCouncil studentcouncil){
        System.out.println(studentcouncilID);
        Optional<StudentCouncil> spon = this.repository.findById(studentcouncilID);
        if(spon.isPresent()){
            spon.get().setEmail(studentcouncil.getEmail());
            return this.repository.save(spon.get());
        }
        throw new RuntimeException();
    }

    public void delete(Integer studentcouncilID){
        this.repository.deleteById(studentcouncilID);
    }

}
